package Accounts;

import java.util.ArrayList;

public class Client {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	private ArrayList<Portfolio> portfolios = 
			new ArrayList<Portfolio>();
	
	public Client() {
		
	}
	
	public Client(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public Client(String firstName, String lastName, String phoneNumber, Portfolio... portfolios) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		for (Portfolio portfolio : portfolios) {
			this.portfolios.add(portfolio);	
		}
	}
	
	public ArrayList<Portfolio> getPortfolios() {
		return portfolios;
	}
	
	public double getClientPortfolioValue() {
		double total = 0;
		for (Portfolio portfolio : portfolios) {
			total+=portfolio.getPortfolioTotalValue();
		}
		return total;
	}
	
	public ArrayList<String> getClientPortfolioNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (Portfolio portfolio : portfolios) {
			names.add(portfolio.getName());
		}
		return names;
	}
	
	public int getPortfolioCount() {
		return portfolios.size();
	}
	
	public Portfolio getClientPortfolioByName(String name) {
		for (Portfolio portfolio : portfolios) {
			if (portfolio.getName().equals(name)) return portfolio;
		}
		return null;
	}

	public void addPortfolio(Portfolio portfolio) {
		portfolios.add(portfolio);
	}
	
	public boolean removePortfolio(Portfolio portfolio) {
		if (portfolios.remove(portfolio)) return true;
		return false;
	}
	
	public void setPortfolios(ArrayList<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
		
}
