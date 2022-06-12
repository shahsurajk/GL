package com.greatlearning.service;

import java.util.Scanner;

public class Banking {
	
	private int balance = 1000;
	
	private Scanner sc = new Scanner(System.in);
	
	private OtpGenerator otpGenerator = new OtpGenerator();
	
	private int otp = -1;
	
	public void deposit() {
		System.out.println("Enter the amount to deposit: ");
		int amount = sc.nextInt();
		
		if (amount > 0) {
			balance += amount; 
			System.out.println(String.format("%d deposited successfully. Final balance is %d", amount, balance));
		} else {
			System.err.println("Invalid amount to deposit");
		}
	}
	
	public void withdraw() {
		System.out.println("Enter amount to withdraw: ");
		int amount = sc.nextInt();
		
		if (amount <= balance) {
			balance -= amount; 
			System.out.println(String.format("%d withdrawn successfully. Final balance is %d", amount, balance));
		} else {
			System.err.println("Invalid amount to withdraw");
		}
	}
	
	public void transfer() {
		System.out.println("Enter the account to transfer: ");
		String account = sc.next();
		
		System.out.println("Enter amount to transfer: ");
		int amount = sc.nextInt();
		
		otp = otpGenerator.generateRandomOtp();
		System.out.println("OTP is: " + otp);
		
		System.out.println("Enter the OTP to validate: ");
		int enteredOtp = sc.nextInt();
		
		if (enteredOtp != otp) {
			System.err.println("Invalid OTP! Try again!");
			return;
		}
		
		// OTP has been verified
		
		if (amount <= balance) {
			balance -= amount; 
			System.out.println(String.format("%d transferred successfully. Final balance is %d", amount, balance));
		} else {
			System.err.println("Invalid amount to transfer");
		}
	}
}
