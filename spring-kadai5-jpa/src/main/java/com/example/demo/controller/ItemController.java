package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemController {
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;

	@GetMapping({ "/", "/items" })
	public String index(
			@RequestParam(name = "categoryId", defaultValue = "0") int categoryId,
			@RequestParam(name = "price", defaultValue = "0") int price,
			Model model) {
		//データベースからすべてのカテゴリーのカテゴリーリストを取得
		List<Category> categoryList = categoryRepository.findAll();
		//データベースからすべての商品の商品リストを取得
		List<Item> list = null;
		//categoryIdによってカテゴリ別の商品を取得
		if (categoryId == 0) {
			// 全検索:SELECT * FROM items
			list = itemRepository.findAll();
		} else {
			// SELECT * FROM items WHERE category_id =1
			list = itemRepository.findByCategoryId(categoryId);
		}
		//List<Item> list1 = null;
		if (price == 0) {
			list = itemRepository.findAll();
		} else {
			list = itemRepository.findBypriceLessThanEqual(price);
		}
		//取得したカテゴリーリストと商品リストをデータ置き場に設定
		model.addAttribute("categories", categoryList);
		model.addAttribute("items", list);
		//model.addAttribute("items", list1);
		//画面遷移
		return "items";
	}

}
