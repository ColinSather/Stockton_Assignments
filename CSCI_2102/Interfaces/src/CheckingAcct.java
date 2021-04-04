
public class CheckingAcct extends Account {
	int points;
	
	public CheckingAcct() {
		super();
		points = 0; 
	}
	public CheckingAcct(double amount, String str) {
		super(amount,str);
		points = (int) (amount/100);
	}
	public int getPoints() {
		return points;
	}
	
	public double getValue() {
		return super.getMeasure()*100;
	}

}
