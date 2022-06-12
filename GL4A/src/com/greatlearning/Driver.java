package com.greatlearning;

import java.util.Scanner;

import com.greatlearning.models.Customer;
import com.greatlearning.service.Banking;

public class Driver {
	
	public static void main(String[] args) {
		
		// account numbers as String? -> 
		// 2^32 -> 2^64 
		// 00012412582412137 -> 
		final Customer customer = new Customer("1234" , "pass");
		
		Scanner sc = new Scanner(System.in);
		
		while (!verifyCreds(sc, customer)) {
			System.out.println("Invalid credentials. Try again!");
		}
		
		System.out.println("Welcome to Indian Bank!");
		
		Banking banking = new Banking();
		
		int input;
		
		do {
			
			System.out.println("\n ----------- \n"
					+ "1. Deposit\n"
					+ "2. Withdraw\n"
					+ "3. Transfer\n"
					+ "4. Logout\n");
			
			input = sc.nextInt();
			
			// if - else -> switch -> 1 : N -> when.  
			switch(input) {
			case 1: 
				banking.deposit();
				break;
			case 2: 
				banking.withdraw();
				break;
			case 3: 
				banking.transfer();
				break;
			case 4: 
				System.out.println("Thank you for banking with us!");
				break;
				default: 
					System.err.println("Invalid option! Try again!");
			} 
			
		} while(input != 4);
		
	}
	
	private static boolean verifyCreds(Scanner sc, Customer customer) {
		System.out.println("Enter account number: ");
		String accNo = sc.next();
		
		System.out.println("Enter password: ");
		String pass = sc.next();
		
		/*
		 *  == -> object address comparison and not value 
		 *  .equals -> value comparison
		 */
		
		return accNo.equals(customer.getAccNo()) && pass.equals(customer.getPassword());
	}
}
