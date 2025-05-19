package com.example.demo.Quiz;

import java.util.Scanner;

public class quiz3 {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in);) {
			System.out.println("お金を入れてください:");
			int money = scan.nextInt();

			if (money > 120) {
				System.out.println("お金が足りません");
				return;
			} else {
				int oturi = money - 120;
				System.out.println("購入できました。おつりは" + oturi + "円です!");
			}

		}
	}

}
