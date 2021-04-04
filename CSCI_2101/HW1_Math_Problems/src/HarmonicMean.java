public class HarmonicMean { 

		public static void main(String[] args) { 
										
		int N = 100;
		double sum = 0;
        double mean = 0;  
		
		for (int i = 1; i <= N; i++)
			{
				sum = sum + i;
          		mean = N / ((1/sum) + i);
			}
		
		System.out.println(mean);
		}
}

