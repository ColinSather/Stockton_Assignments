
public class Account implements Measurable {
	private String name;
	private double balance;
	public Account() {
		balance = 0;
	}
	public void bankName() {
		String bankname = "PNC";
		System.out.println(bankname);
	}
	public Account(double amount, String str) {
		balance = amount;
		name = str;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getMeasure() {
		return balance;
	}

	public String getTitle() {
		return name;
	}
	
}
