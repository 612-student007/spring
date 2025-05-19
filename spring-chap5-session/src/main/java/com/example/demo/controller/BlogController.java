package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.Post;
import com.example.demo.model.PostList;

@Controller
public class BlogController {
	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	PostList postList;

	@GetMapping({ "/", "/logout" })
	public String index() {
		session.invalidate();//セッションの破棄
		return "login";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam("name") String name) {
		//accountのインスタンスに氏名を設定
		account.setName(name);//sessionから情報を引っ張り出すので、modelは必要なくなる
		return "blog";
	}

	@PostMapping("/blog")
	public String posts(
			@RequestParam("title") String title,
			@RequestParam("content") String content) {

		//セッションスコープに保持された投稿リストを取得
		List<Post> allPosts = postList.getPosts();
		//リクエストパラメータをもとにして投稿記事をインスタンス化
		Post post = new Post(title, content);
		//post.setTitle(title);
		//post.setContent(content);
		allPosts.add(post);
		//投稿記事のインスタンスを投稿リストに追加
		return "blog";
	}

}
