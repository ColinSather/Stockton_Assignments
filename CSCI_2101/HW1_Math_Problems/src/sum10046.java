
public class sum10046 { 

		public static void main(String[] args) { 
										
		int N = 100;
		int sum = 0;
		
		for (int i = 1; i <= N; i++)
			{
				if(  (i % 4 == 0) || (i % 6 == 0)  )
				sum = sum + i;
			}
	
		
		System.out.println(sum);
		}
}