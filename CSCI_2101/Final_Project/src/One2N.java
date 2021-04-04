// The last element is considered a leader.
public class One2N {
	public static void main(String[] args) {
		int N = 4; // Length N.
		int[] x = new int[N];
		for(int i=0;i<N;i++) {
			x[i]=(int)(Math.random()*100);
		}
		
		for(int i =0;i < N;i++) {
			int j;
			for(j=i+1;j < N;j++) {
				if(x[i] <= x[j]) {
					break;
				}
			}
			if(j==N) {
				// Prints leader elements.
				System.out.print(x[i]+" ");
			}
		}
		// Prints random array.
		System.out.println(java.util.Arrays.toString(x));
	}
}