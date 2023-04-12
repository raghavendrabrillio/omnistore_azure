package com.brillio.omnistore.dto;

import java.util.ArrayList;
import java.util.List;

public class TestTrim {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("sms");
		list.add("");
		list.add(null);
		System.out.println(String.join(",", list).replaceAll("\\s", ""));
	}

}
