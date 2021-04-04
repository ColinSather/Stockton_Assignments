package Accounts;

import java.util.ArrayList;
import Entity.Valuable;

public class Portfolio implements Valuable {

	private String name;
	private ArrayList<Account> accounts = new ArrayList<Account>();
		
	public Portfolio(String name, Account... accounts) {
		this.setName(name);
		for (Account account : accounts) {
			this.accounts.add(account);
		}
	}
	
	public String toString() {
		String portfolioDescription = "Portfolio: " + name + "\n";
		for (Account account : accounts) {
			portfolioDescription+=account+"\n";
		}
		portfolioDescription+="Total Value: $" + getValue();
		return portfolioDescription; 
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public boolean removeAccountByNumber(String accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				accounts.remove(account);
				return true;
			}
		}
		return false;
	}
	
	public double getPortfolioTotalValue() {
		double totalValue = 0;
		for (Account account : accounts) {
			totalValue+=account.getValue();
		}
		return totalValue;
	}
	
	public double getValue() {
		return getPortfolioTotalValue();
	}
	
	public String getDescription() {
		return getPortfolioMemberDescriptions().toString();
	}
	
	public ArrayList<String> getPortfolioMemberDescriptions() {
		ArrayList<String> accountNames = new ArrayList<String>();
		for (Account account : accounts) {
			accountNames.add(account.getDescription());
		}
		return accountNames;
	}
	
	public ArrayList<String> getPortfolioMemberTypes() {
		ArrayList<String> accountTypes = new ArrayList<String>();
		for (Account account : accounts) {
			if (!accountTypes.contains(account.getType())) {
				accountTypes.add(account.getType());
			}
		}
		return accountTypes;
	}
	
	public ArrayList<String> getPortfolioMemberNamesWithTypes() {
		ArrayList<String> accountList = new ArrayList<String>();
		for (Account account : accounts) {
			accountList.add(account.getDescription() + " (" + account.getType() + ")");
		}
		return accountList;
	}
	
	public ArrayList<Double> getPortfolioMemberValues() {
		ArrayList<Double> values = new ArrayList<Double>();
		for (Account account : accounts) {
			values.add(account.getValue());
		}
		return values;
	}
	
	public Account getAccountByNumber(String accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) 
				return account;
		}
		return null;		
	}
	
	public ArrayList<Account> getPortfolioAccounts() {
		return accounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
