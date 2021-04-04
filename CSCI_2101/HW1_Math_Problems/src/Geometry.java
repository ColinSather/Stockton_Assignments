import java.lang.Math;
public class Geometry { 

		public static void main(String[] args) { 
										
		int N = 100;
		double sum = 0;
        double Geomean = 0;  
		
		for (int i = 1; i <= N; i++)
			{
				sum = sum + i;
          		Geomean = Math.pow(sum * N,1/N);
			}
		
		System.out.println(Geomean);
		}
}