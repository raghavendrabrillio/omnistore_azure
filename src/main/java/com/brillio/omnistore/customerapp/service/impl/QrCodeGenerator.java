package com.brillio.omnistore.customerapp.service.impl;

public class QrCodeGenerator {

	public static String generateQrCode(String userId, int size) {
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		alphaNumericString = userId + alphaNumericString;
		StringBuilder sb = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			int index = (int) (alphaNumericString.length() * Math.random());
			sb.append(alphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// Get the size n
		int n = 8;
		// Get and display the alphanumeric string
		System.out.println(QrCodeGenerator.generateQrCode("1", n));
	}
}
