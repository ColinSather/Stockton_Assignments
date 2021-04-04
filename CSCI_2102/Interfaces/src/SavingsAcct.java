
public class SavingsAcct extends Account {
	int points;
	
	public SavingsAcct() {
		super();
		points = 0; 
	}
	
	public SavingsAcct(double amount, String str) {
		super(amount,str);
		points = (int) (amount/100);
	}
	public void bankName() {
		String bankname = "TD";
		System.out.println(bankname);
	}
	public int getPoints() {
		return points;
	}
	public void setBalance(double balance) {
		System.out.println("test");
	}
	
	public double getValue() {
		return points;
	}

}
