package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Item;

@Controller
public class ItemController {
	@Autowired //依存性の注入

	@GetMapping("/item")
	public String index() {
		return "item";
	}

	@PostMapping("/item")
	public String add(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "0") int price,
			Model model) {

		//登録する商品をインスタンス化
		Item item = new Item();
		item.setName(name);
		item.setPrice(price);

		//[メイン処理：永続化]データベースへの登録

		//共用のデータ置き場にリクエストパラメータを置きなおす
		model.addAttribute("item", item);

		/*	model.addAttribute("name", name);
			model.addAttribute("price", price);*/
		return "item";
	}

}
