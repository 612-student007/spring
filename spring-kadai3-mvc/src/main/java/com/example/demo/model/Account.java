package com.example.demo.model;

public class Account {
	private String name;
	private String address;
	private String pass;

	public Account() {
	}

	public Account(String name, String address, String pass) {
		this.name = name;
		this.address = address;
		this.pass = pass;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return this.name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return this.pass;
	}

}
