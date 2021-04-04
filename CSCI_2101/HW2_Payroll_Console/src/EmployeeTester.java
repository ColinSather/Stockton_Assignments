// Tester Class for printing purposes
public class EmployeeTester {
  public static void main(String args[]){
	Employee grace = new Employee();
	grace.name = "Grace";
	grace.title = "IT Analyst";
	grace.salary = 80000;
	grace.bonus = 0.50;
	
	Employee sally = new Employee();
	sally.name = "Sally";
	sally.title = "Systems Engineer";
	sally.salary = 80000;
	sally.bonus = 0.50;
	
	Employee barb = new Employee();
	barb.name = "Barbara";
	barb.title = "Assistant Consultant";
	barb.salary = 40000;
	barb.bonus = 0.10;
	
	Employee sean = new Employee();
	sean.name = "Sean";
	sean.title = "Senior Consultant";
	sean.salary = 70000;
	sean.bonus = 0.10;
	
	Employee employees[] = new Employee[4];
	employees[0] = grace;
	employees[1] = sally;
	employees[2] = barb;
	employees[3] = sean;
	
    int i = 0;
    
    for(i = 0; i < employees.length; i++)
    {
	  // Prints employee i name, position, salary plus bonus, id and the amount of their bonus.
      employees[i].id = i;
	  System.out.println("Employee ID: #"+employees[i].getId());
	  System.out.println("Employee Name: "+employees[i].getName());
	  System.out.println("Employee Designation: "+employees[i].getTitle());
	  System.out.println("Employee Salary: $"+employees[i].getSalary());
	  System.out.println("Employee Bonus: $"+employees[i].getBonus());
	  System.out.println();
     } 
  }
}