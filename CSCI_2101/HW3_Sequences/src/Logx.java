//log(x) = (x – 1) – (1/2)(x – 1)^2 + (1/3)(x – 1)^3 - (1/4)(x – 1)^4 + … (for 0 < x <= 2).
import java.util.Scanner;
public class Logx 
{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter a value for x such that 0<x<=2 ");
 double x = in.nextInt(); // Change to equal an integer to test later.
 double rad = Math.toRadians(x);
 int limit = 100;
 double currentTerm = 0;
 double logx = 0;
 //int power = 1;
 if(0<x && x<=2)
 {
	    for(int i = 1; i <= limit; i++)
	    {
	      currentTerm =  -Math.pow((rad - 1),i)/getDenom(i); 
	      logx = logx + currentTerm;
	    }
	    // Compare answers still incorrect
	    System.out.println("Math.log(x) returns "+Math.log(x));
	    System.out.println("My program returns "+logx);
	    System.out.println("The difference is "+ (logx-Math.log(x)));
 }  
 else
 	System.out.println("Invalid Input!");
 	in.close();
}
static double getDenom(int limit)
{
		double denominator = 1; 
		for(int i = 1; i<=limit;i++)
     {
     	denominator=denominator+1;
     }
  	return denominator;
}  
}