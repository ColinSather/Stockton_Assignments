/*f(r) = 1 + r + r2 + r3 + ... 
is equal to 1/(1 - r), if |r| < 1*/
public class InfiniteSeries {
  public static void main(String[] args) {
    double r = 0.5;
    double currentTerm = 0.0;
    double series = 0.0;
    double series2 = 0.0;
    
      for(int i = 0; i <=100; i++)
      {
        if(r<1)
        {
        currentTerm = Math.pow(r,i);
        series = series+currentTerm;  
        }
        else
          System.out.println("Not a valid input.");
      }
      for(int j = 0; j <=200; j++)
      {
        if(r<1)
        {  
        currentTerm = Math.pow(r,j);
        series2 = series2+currentTerm;
        }
        else
          System.out.println("Not a valid input.");
      }  
    System.out.println(series);
    System.out.println(series2);
    }
}