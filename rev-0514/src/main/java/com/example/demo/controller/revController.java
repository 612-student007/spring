package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class revController {
	@GetMapping("/login")
	public String login() {
		return "revFirst";
	}

	@PostMapping("/login")
	public String result(
			@RequestParam(name = "id", defaultValue = "") String id,
			@RequestParam(name = "pass", defaultValue = "") String pass,
			Model model) {

		List<String> errors = new ArrayList<String>();

		if (!id.equals("student")) {
			errors.add("ユーザIDが一致しませんでした");

		}
		if (!pass.equals("himitu")) {
			errors.add("パスワードが一致しませんでした");
		}

		if (errors.size() > 0) {
			model.addAttribute("errors", errors);
			return "revFirst";
		}

		model.addAttribute("id", id);
		model.addAttribute("pass", pass);
		return "revResult";
	}

}
