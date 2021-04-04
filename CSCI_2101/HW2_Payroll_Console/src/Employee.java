
public class Employee {
	public String name = "";
	public String title = "";
	public double salary = 0;
	public int id = 0;
	public double bonus = 0;
	
	public double getSalary() {
		return salary;
	}

	public double getBonus() {
		return bonus * salary;
	}

	public String getName() {
		return name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getId() {
		return id;
	}
	
	
}
