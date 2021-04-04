package Accounts;

import Entity.Valuable;

public abstract class Account implements Valuable {

	private double balance;
	private String accountNumber;
	protected String type;
	
	protected void initializeAccount(double balance, String accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	} 
	
	public double getBalance() {
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		return accountNumber + ": " + balance + " (" + type + ")";
	}
	
}
