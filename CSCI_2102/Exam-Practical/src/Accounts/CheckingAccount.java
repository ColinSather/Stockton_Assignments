package Accounts;

public class CheckingAccount extends Account {

	public CheckingAccount(double balance, String accountNumber) {		
		super.initializeAccount(balance, accountNumber);
		super.type = "Checking";
	}
	
	public double getValue() {
		return super.getBalance();
	}

	public String getDescription() {
		return super.getAccountNumber();
	}
	
}
