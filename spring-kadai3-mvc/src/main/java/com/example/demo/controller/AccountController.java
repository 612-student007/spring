package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AccountController {

	@GetMapping("/account")
	public String index(Model model) {
		//空の会員インスタンスを自画面に引き継ぐためにスコープに登録
		model.addAttribute("account", new Account());
		return "accountForm";
	}

	@PostMapping("/account/confirm")
	public String confirm(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "pass", defaultValue = "") String pass,
			Model model) {

		Account account = new Account();
		account.setName(name);
		account.setAddress(address);
		account.setPass(pass);

		List<String> errors = new ArrayList<String>();
		if (name.isEmpty()) {
			errors.add("名前は必須です");
		}

		if (address.isEmpty()) {
			errors.add("メールアドレスの入力は必須です");
		}
		if (pass.isEmpty()) {
			errors.add("パスワードは必須です");

		}

		if (errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("account", account);
			return "accountForm";
		}

		model.addAttribute("account", account);
		return "accountConfirm";
	}

	@PostMapping("/account")
	public String store() {

		return "accountFinish";
	}

}
