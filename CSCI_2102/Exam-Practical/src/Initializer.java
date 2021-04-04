import java.io.*;
import java.util.*;

import Accounts.Account;
import Accounts.CheckingAccount;
import Accounts.Client;
import Accounts.Portfolio;
import Accounts.SavingsAccount;

public class Initializer {
	
	// Set the Savings Account Creation Bonus
	public static final double SAVINGS_BONUS = 100;

	public static void main(String[] args) {
		
		// Set the relative file path
		String filename = "account.txt";
		
		// Open the file
		File file = new File(filename);
		
		// Create the Scanner object and scope to the entire main method
		Scanner in = null;
		
		try {
			// Try to open the file
			in = new Scanner(file);
			
			try {
				// Read in the Account Data
				String firstname = in.nextLine();
				String lastname = in.nextLine();
				String phone = in.nextLine();
				
				// Setup the Client
				Client customer = new Client(firstname, lastname, phone);
				ArrayList<Portfolio> portfolios = new ArrayList<>();
				ArrayList<Integer> accountCounts = new ArrayList<>();
			
				// Split the data into a String Array pivoting on , characters
				String data = in.nextLine();
				String[] dataVector = data.split(",");
				
				// Set the number of portfolios
				int portfolioCount = Integer.parseInt(dataVector[0])+1;
		
				// Push account counts to a list
				for (int i=1; i<portfolioCount; i++) {
					accountCounts.add(Integer.parseInt(dataVector[i]));
					System.out.println(accountCounts);
				}

				// Create the portfolios
				for (int j : accountCounts) {
					
					// Setup the Account list
					ArrayList<Account> records = new ArrayList<>();
					String portfolioName = in.nextLine();
					
					for (int k = 0; k<j; k++) {

						// Read in the line
						String line = in.nextLine();
						
						// Split the line into a String Array pivoting on TAB characters
						String[] values = line.split("\t");
						
						// Map the data into useful local variables
						String accountType = values[1];
						String accountNumber = values[2];
						double balance = Double.parseDouble(values[0]);
						
						// Create a cohesive record based on the accountType specified
						switch (accountType) {
						case "Checking":
							// Create a Checking Account
							records.add(new CheckingAccount(balance, accountNumber));
							break;
						case "Savings":
							// Create a Savings Account
							records.add(new SavingsAccount(balance, accountNumber, SAVINGS_BONUS));
							break;
						default:
							// Type is unknown
							throw new IndexOutOfBoundsException("Invalid Account type (" + accountType + ")");	
						}
					
					}
					
					Portfolio portfolio = new Portfolio(portfolioName);
					
					for (Account account : records)
					 portfolio.addAccount(account);
					 portfolios.add(portfolio);
					 customer.addPortfolio(portfolio);

				}
				
				System.out.println("ALL PORTFOLIOS VALUE: $" + customer.getClientPortfolioValue());
				System.out.println(customer.getPortfolios());
				
				FormWindow fW = new FormWindow(customer);
				fW.frame.setVisible(true);
				
			// Fix anything that broke and clean up
			} catch (NoSuchElementException e) {
				System.err.println("Record Error: " + e.getMessage());
			} catch (IndexOutOfBoundsException e) {
				System.err.println("Parse Error: " + e.getMessage());
			} catch (NumberFormatException e) {
				System.err.println("Data Error: " + e.getMessage());
			} finally {
				in.close();
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("File Unavailable: " + e.getMessage());
		} 
		
	}

}
