package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RandomStringService;

@Controller
public class RandomStringController {

	@PostMapping("/random")
	public String generate(
			@RequestParam("charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "false") boolean withNumber,
			Model model) {

		//[メイン処理]ランダム文字列の生成
		RandomStringService service = new RandomStringService();
		List<String> list = service.generate(charLength, withNumber);
		//[ルーチン処理]生成したランダム文字列を共用のデータ置き場に設定
		model.addAttribute("randlist", list);
		//[画面遷移]自画面遷移
		return "random";
	}

	@GetMapping("/random")
	public String index() {
		return "random";
	}

}
