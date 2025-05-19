package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Account {

	private String name;

	public Account() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
