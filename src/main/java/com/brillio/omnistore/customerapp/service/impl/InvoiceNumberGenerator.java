package com.brillio.omnistore.customerapp.service.impl;

public class InvoiceNumberGenerator {

	public static String generateInvoiceNumber(int size) {
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			int index = (int) (alphaNumericString.length() * Math.random());
			sb.append(alphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(generateInvoiceNumber(20));
	}
}
