package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.Cart;
import com.example.demo.model.Item;

@Controller
public class CartController {
	@Autowired
	HttpSession session;

	@Autowired
	Cart cart;

	@Autowired
	Account account;

	@GetMapping("/cart")
	public String showCart() {

		return "cart";
	}

	@GetMapping({ "/cart/login", "/cart/logout" })
	public String index() {
		session.invalidate();
		return "cartlogin";
	}

	/*@GetMapping({ "/cart", "/clear" })
	public String showCart() {
		session.invalidate();
		return "cart";
	}*/
	@GetMapping({ "/cart/clear" })
	public String clearCart() {
		session.invalidate();
		return "cart";
	}

	@PostMapping("/cart")
	public String login(
			@RequestParam("name") String name) {
		//accountのインスタンスに氏名を設定
		account.setName(name);//sessionから情報を引っ張り出すので、modelは必要なくなる
		return "cart";
	}

	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "price", defaultValue = "") Integer price) {

		List<Item> items = cart.getItems();

		Item item = new Item(name, price);

		if (name.length() == 0 || item.getPrice() == null) {
			return "cart";
		}
		items.add(item);

		return "cart";
	}

}
