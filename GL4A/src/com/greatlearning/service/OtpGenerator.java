package com.greatlearning.service;

public class OtpGenerator {
	
	public int generateRandomOtp() {
		return (int) (Math.random() * 10000); // 0.0 - 1.0 -> .00324278->  0032 -> 3242.78 -> 3242 -> 1 -> 10^6 -> 0000
	}
}
