import java.util.*;
public class BallToss {

	// The number of tosses in the simulation
	private static final int NUMBER_OF_TOSSES = 100;
	
	// Finds the mode of the list cupsMade[]
	public static int mode(int list[], int n) {
		int maxValue = 0;
		int maxCount = 0;
		for(int i = 0; i<list.length;i++) {
			int count = 0;
			for(int j = 1; j< list.length;j++) {
				if(list[j] == list[i]) {
					++count;
				}
				if(count > maxCount) {
					maxCount = count;
					maxValue = list[i];
				}
				
			}
			
		}
		return maxValue;
	}
	// Altered method that returns the count of mode(), works correctly.
	// Needs to show if there is multiple modes.
	public static int modeCount(int list[], int n) {
			
			int maxCount = 0;
			for(int i = 0; i<list.length;i++) {
				int count = 0;
				for(int j = 0; j< list.length;j++) {
					if(list[j] == list[i]) {
						++count;
					}
					if(count > maxCount) {
						maxCount = count;
					}
					
				}
				
			}
			return maxCount;
		}
// this doesnt fucking work do something different.
	static int leastFreq(int list[], int n) {
		Arrays.sort(list);
		int minCount = n+1;
		int res = -1;
		int currentCount = 1;
		
		for(int i = 1; i<n; i++) {
			if(list[i]==list[i-1]) {
				currentCount++;
			}
			else if(currentCount < minCount) {
				res = list[i-1];
			}
			currentCount = 1;
		}
		// if last element is the least frequent
		if(currentCount > minCount) {
			minCount  = currentCount;
			res = list[n-1];
		}
		return res;
	}
	// Altered method that returns the count of leastFreq()
	// Returns incorrect results.
	// Problem: if an element was picked 0 times min = 0
	// least frequent cup would be found in the absent element
		static int leastCount(int list[], int n) {
			Arrays.sort(list);
			int minCount = n+1;
			int res = -1;
			int currentCount = 1;
			
			for(int i = 1; i<n; i++) {
				if(list[i]==list[i-1]) {
					currentCount++;
				}
				else if(currentCount < minCount) {
					res = list[i-1];
				}
				currentCount = 1;
			}
			// if last element is the least frequent
			if(currentCount > minCount) {
				minCount  = currentCount;
				res = list[n-1];
			}
			return currentCount;
		}
		
	public static void main(String[] args) {

		// The maximum number observed
		int max = 0;
		// The minimum number observed
		int min = 0;
		// The cup containing the maximum number
		int maxC = 0;
		// The cup containing the minimum number
		int minC = 0;
		ArrayList<Integer> beers = new ArrayList<>();
		ArrayList<Integer> buckets = new ArrayList<>();
		//ArrayList<Integer> buckets = new ArrayList<>();
		Random gener = new Random();
	
		for(int i = 0; i < 10; i++) {
			beers.add(i);
		}
		int[] cupsMade = new int[10];
		// The mode count of buckets will = max.
		for (int i = 0; i < 10;i++) {
			int random = gener.nextInt(beers.size());
			cupsMade[i] = random;
			buckets.add(random);
		}
		int n = cupsMade.length;
		/*int count = 0;
		for(int i = 0; i<10; i++) {	
			
			for(int cup : buckets) {
				if (cup == buckets.get(i)) {
					count++;
				}
			}
		}*/
		System.out.println("The possible cups are "+beers);
		System.out.println("The random makes are "+buckets);

		System.out.println("\nThe most frequent cup is "+mode(cupsMade,n));
		System.out.println("The least frequent cup is "+leastFreq(cupsMade,n));
		maxC = mode(cupsMade,n);
		minC = leastFreq(cupsMade,n);
		max = modeCount(cupsMade,n);
		min = leastCount(cupsMade,n);
		// print the occurrence count of each element in buckets
		
		// ------------------------------------------------------------------------
		//    Complete the program such that the output below is created.
		//     This should be the last thing your program does,
		//      insert your code above this block...
		// ------------------------------------------------------------------------
		
		System.out.println("MAX: " + max + "\tfound in cup " + maxC);
		System.out.println("MIN: " + min + "\tfound in cup " + minC);
		System.out.println("Range: " + (max - min));
		
	}

}