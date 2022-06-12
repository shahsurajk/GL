package com.greatlearning.service;

public class OtpGenerator {
	
	public int generateRandomOtp() {
		return (int) (Math.random() * 10000); // 0.9328 * 10000 9328
	}
}
