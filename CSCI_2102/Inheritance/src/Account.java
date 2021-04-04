
// Base class
public class Account {
	private String name;
	double balance;
	public Account() {
		balance = 0;
	}
	public Account(double balance,String name) {
		this.balance = balance;
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public String getName() {
		return name;
	}

	//override equals() in order to compare objects
	public boolean equals(Object obj) {
		if(obj == this) {
			//they equal
			return true;
		}
		// type cast to Account.
				Account account = (Account) obj;
		if(!(obj instanceof Account)) {
			return false;
		}
		
		return Double.compare(balance, account.balance) == 0;
		
	}
	//override toString()
	public String toString() {
		return balance+" "+name;
	}
	
}
