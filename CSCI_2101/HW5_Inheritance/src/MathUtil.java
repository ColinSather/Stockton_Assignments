
public class MathUtil {
  //Power Method.
  public static double intPower(double x, int n){
    if(n<0){
      return 1/Math.pow(x,-n);
      }
      else if(n>0 && n%2==0)
        return (int)Math.pow(Math.pow(x,n/2),2);
      else
        return (int)Math.pow(x,n-1)*(int)x; 
  }
  //Taylor Series Method.
  public static double computeSine(double x){
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
    return sinX;
  }
  // Factorial Method for taylor series method.
	static double getFact(int no) 
	{
		double fact = 1;
		for (int i=1; i <= no;i++)
		{
			fact=fact*i;
		}
		return fact;
	}
  // Printed factorial Method (int).
  static int factorial(int n) 
	{
		double fact = 1;
		for (int i=1; i <= n;i++)
		{
			fact=fact*i;
		}
		return (int)fact;
	}
}