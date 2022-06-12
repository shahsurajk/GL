package com.greatlearning;

import java.util.Scanner;

import com.greatlearning.models.Customer;
import com.greatlearning.service.Banking;

public class Driver {

	public static void main(String[] args) {
	   Customer customer = new Customer("1234", "pass");
	   
	   Scanner sc = new Scanner(System.in);
	   
	   while (!verifyCreds(sc, customer)) {
		   System.err.println("Invalid credentials, try again!");
	   }
	   
	   // verified
	   System.out.println("Welcome to Indian Bank!!");
	   
	   Banking banking = new Banking();
	   
	   int input; 
	   
	   do {
		
		   System.out.println(
				   "\n ---------- \n"
		   		+ "Enter your choice: \n"
		   		+ "1. Deposit\n"
		   		+ "2. Withdraw\n"
		   		+ "3. Tranfer \n"
		   		+ "4. Logout"
				);
		   
		   input = sc.nextInt();
		   
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
				 System.err.println("Invalid input!");
		   } 
	   } while(input != 4); 
	   
	   sc.close();
	}
	
	private static boolean verifyCreds(Scanner sc, Customer customer) {
		System.out.println("Enter account number: ");
		String accNo = sc.next();
		
		System.out.println("Enter password: ");
		String pass = sc.next();
		
		// .equals and == ? 
		return accNo.equals(customer.getAccNo()) && pass.equals(customer.getPassword());
	}
}
