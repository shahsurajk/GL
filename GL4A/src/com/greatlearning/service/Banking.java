package com.greatlearning.service;

import java.util.Scanner;

public class Banking {
	
	private final Scanner sc = new Scanner(System.in);
	
	private OtpGenerator otpGenerator = new OtpGenerator();
	
	private int otp = -1; // -> -1
	
	private int balance = 1000;
	
	public void deposit() {
		System.out.println("Enter the amount to deposit: ");
		int amount = sc.nextInt();
		
		if (amount > 0) {
			balance += amount; 
			System.out.println(String.format("%d deposited. Final balance is %d", amount, balance));
		} else {
			System.err.println("Invalid amount entered!");
		}
	}
	
	public void withdraw() {
		System.out.println("Enter the amount to withdraw: ");
		int amount = sc.nextInt();
		
		if (amount <= balance) {
			balance -= amount; 
			System.out.println(String.format("%d withdrawn. Final balance is %d", amount, balance));
		} else {
			System.err.println("Invalid amount to withdraw!");
		}
	}
	
	public void transfer() {
		System.out.println("Enter the account number to transfer to: ");
		
		String accNo = sc.next();
		
		otp = otpGenerator.generateRandomOtp();
		
		System.out.println("OTP is: " + otp);
		
		System.out.println("Enter the OTP: ");
		int inputOtp = sc.nextInt();
		
		if (otp != inputOtp) {
			System.err.println("Invalid OTP! Try again!");
			return;
		}
		
		// OTP verified.
		System.out.println("Enter the amount to transfer: ");
		int amount = sc.nextInt();
		
		if (amount <= balance) {
			balance -= amount; 
			System.out.println(String.format("%d transferred. Final balance is %d", amount, balance));
		} else {
			System.err.println("Invalid amount to Transfer!");
		}	
	}	
}
