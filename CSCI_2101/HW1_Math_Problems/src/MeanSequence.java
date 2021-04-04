public class MeanSequence { 

		public static void main(String[] args) { 
										
		int N = 100;
		double sum = 0;
        double mean = 0;  
		
		for (int i = 1; i <= N; i++)
			{
				sum = sum + i;
          		mean = sum / N;
			}
		
		System.out.println("Sum of Averages from 1 to "+N);
		System.out.println(mean);
		}
}