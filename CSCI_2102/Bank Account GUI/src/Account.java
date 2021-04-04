import java.time.Instant;
import java.util.Date;
public class Account implements Comparable<Account> {

	//Instance Variables.
	private double balance;
	private static int idBase = 1000;
	private int acctId;
	private String name;
	private Date lastUpdate;

	// Constructors.
	public Account() {
		balance = 0;
		acctId = idBase++; 
	}
	public Account(String name, double amt) {
		this.balance = amt;
		init(name);
	}
	
	// Methods.
	public void init(String name) {
		this.name = name;
		acctId = idBase++;
		lastUpdate = new Date();
	}
	public void updateDate() {
		lastUpdate.setTime(Instant.now().toEpochMilli());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAcctId() {
		return acctId;
	}
	public double getBalance() {
		return balance;
	}
	public double withdraw(double amt) {
		if(amt<=this.balance && amt>0) {
			this.balance -= amt;
			updateDate();
		}	
		return amt;
	}
    public double deposit(double amt) {
		if(amt>0) {
			this.balance += amt;
		}
		return amt;
    }
    public String getLastUpdate() {
    	return lastUpdate.toString();
    }
	@Override
	public int compareTo(Account arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}