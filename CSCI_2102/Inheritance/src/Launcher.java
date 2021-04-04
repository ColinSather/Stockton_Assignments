
import java.util.*;
import java.util.Collections;
public class Launcher {

	public static void main(String[] args) {
		
		ArrayList <Account> list = new ArrayList<>();
		Account b = new Savings(410,"Daqwando");
		Account c = new Checking(40,"Derric");
		list.add(b);
		list.add(c);
		
		Collections.sort(list,new SortByBalance());
		for(Account x : list) {
			System.out.println("$"+x);
		}	
		if (b.equals(c)) {
			System.out.println("Have Equal Balances!");
		}
		else
			System.out.println("Do Not Have Equal Balances!");
			

		
			
	}

}
