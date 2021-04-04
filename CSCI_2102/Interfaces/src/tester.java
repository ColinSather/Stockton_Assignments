import java.util.ArrayList;
public class tester {

	public static void main(String[] args) {
		
		
		Account a = new SavingsAcct(150,"bro1");
		Account b = new CheckingAcct(100,"bro2");
		a.bankName();// Example of runtime polymorphism
		
		ArrayList <Measurable> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		int i = 0;
		for(Measurable object : list) {
				i++;
				System.out.print(object.getTitle()+" is ");
				System.out.print("Object "+i+": ");
				System.out.println(object.getMeasure());
			}
		}
		
	}


