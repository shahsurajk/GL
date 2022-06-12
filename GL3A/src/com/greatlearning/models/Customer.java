package com.greatlearning.models;

public class Customer {
 
	String accNo; 
	
	String password; 
	
	public Customer() {
	}
	
	public Customer(String accNo, String password) {
		this.accNo = accNo;
		this.password = password;
	}
	
	public void setAccNo(String mAccNo) {
		accNo = mAccNo;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAccNo() {
		return accNo;
	}
	
	public String getPassword() {
		return password;
	}
}
