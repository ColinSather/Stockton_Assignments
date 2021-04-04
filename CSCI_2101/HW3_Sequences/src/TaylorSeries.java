// Save as taylor.java in code editor program works as of 11/2.
// Taylor Series Formula: sin(x) = x – x^3/3! + x^5/5! – x^7/7! + ... to the 100th term.
import java.util.Scanner;
public class TaylorSeries
{
	public static void main(String[] args) 
    {
		Scanner in = new Scanner(System.in);
	    System.out.println("Enter a value for x.");
	    double x = in.nextInt(); // Accepts angle x for the Taylor Series Formula.
	    double rad = Math.toRadians(x); // Converts var x to radians. 
	    int power = 1; // Starting exponent.
	    int no = 100; // Up to 100th term.
	    double sinX = 0.0;
	    double currentTerm = 0.0;
	    for (int i = 1; i <= no; i++)
	    {
	    	if(i%2==0)
	    	{
	    		currentTerm = -Math.pow(rad, power)/getFact(power);
	    	}
	    	else 
	    	{
	    		currentTerm = Math.pow(rad, power)/getFact(power);
	    	}
	    power = power + 2;
	    sinX = sinX + currentTerm;
	    }
	    System.out.println(sinX);
	    in.close();
	}
	static double getFact(int no) // Factorial Method.
	{
		double fact = 1;
		for (int i=1; i <= no;i++)
		{
			fact=fact*i;
		}
		return fact;
	}
}