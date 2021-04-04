public class BankAccount {
	private int acct;
    private static int base = 10000;
	private double balance;
  // Initialize int balance
	public BankAccount() {
      	balance=0;
	}
  // Sequential acct numbers
	public int getNumber() {
        base++;
        acct=base;
	    return acct;
    }
  // Account Methods
   public void deposit(double amount) {
	   if(amount <= 0) {
		   assert amount >= balance;
		   System.err.println("Invalid option");
	   }
	   else 
		   balance = balance + amount;
   }
   public void withdraw(double amount) {
	   if(amount >= balance) {
		   assert amount >= balance;
		   System.err.println("Invalid option"); 
	   } 
	   else 
		   balance = balance - amount;
  }
  public void transfer(double amount) {
	  if(amount >= balance) {
		  assert amount >= balance;
		  System.err.println("Invalid option");
	  }
		  
	  else 
		  balance = balance - amount;
	  	
  }
  public double getBalance() {
	  	return balance;
  }
}