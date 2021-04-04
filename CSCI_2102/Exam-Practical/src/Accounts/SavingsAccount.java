package Accounts;

public class SavingsAccount extends Account {

	public SavingsAccount(double balance, String accountNumber, double bonus) {
		super.initializeAccount(balance+bonus, accountNumber);
		super.type = "Savings";
	}
	
	public double getValue() {
		return super.getBalance();
	}
	
	public String getDescription() {
		return super.getAccountNumber();
	}

}
