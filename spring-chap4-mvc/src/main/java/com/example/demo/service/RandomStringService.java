package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomStringService {
	private static final int GENERATE_NUM = 10;

	@SuppressWarnings("deprecation")
	public List<String> generate(int charLength, boolean withNumber) {
		List<String> list = new ArrayList<>();
		String word = "";
		for (int i = 0; i < GENERATE_NUM; i++) {
			if (withNumber == false) {
				word = RandomStringUtils.randomAlphabetic(charLength);
				list.add(word);
			} else {
				word = RandomStringUtils.randomAlphanumeric(charLength);
				list.add(word);
			}
		}
		return list;
	}

}
