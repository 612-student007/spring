package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Cart {
	public Cart() {
	}

	private List<Item> items = new ArrayList<Item>();

	public List<Item> getItems() {
		return this.items;
	}
}
