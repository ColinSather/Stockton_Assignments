package exam1;
import java.util.*;
// pick 3 from 00 - 29 no duplicates. For 100,000 iterations
// calculate the sum of the three, then reset. List repeated sum amounts.
public class Lottery {
	void findCounts(ArrayList <Integer> x, int n) {
		int i = 0;
		while (i < n) {
			if (x.get(i) <= 0) {
				i++;
				continue;
			}
			int elementIndex = x.get(i) - 1;
			if (x.get(elementIndex) > 0) {
				//x.get(i) = x.get(elementIndex);
			}
		}
	}
	public static void main(String[] args) {
	
	Random generator = new Random();  
	ArrayList <Integer> pool = new ArrayList<>();
	ArrayList <Integer> Hopper = new ArrayList<>();
	ArrayList <Integer> Results = new ArrayList<>();
	ArrayList <Integer> TrialSum = new ArrayList<>();
	ArrayList <Integer> Samesies = new ArrayList<>();
	// Looping construct to create 100,000 drawings.
	for(int j = 0; j<10; j++) {
		// Adds numbers to Pool.
			for (int i = 0; i <= 29; i++) {
			 	pool.add(i);
			}
			// Adds 3 Numbers to Hopper.
			 for (int i = 1; i <= 3; i++) {
				 int random = generator.nextInt(pool.size());
				 int ball = pool.remove(random);
				 Hopper.add(ball);
			 }
			 // Sum of Hopper Integers.
			 int RandomSum = 0;
			 for(int i = 0; i< Hopper.size();i++) {
				 RandomSum += Hopper.get(i);
			 }
			 // Store result in an array list Results.
			 Results.add(RandomSum);
			 // Clears Lottery Integers.
			 pool.clear();
			 Hopper.clear();
	}
	// Possible random sums are 3 - 84.
	for (int i = 3; i <= 84; i++) {
		TrialSum.add(i);
	}
	System.out.println("Trials");
	for (int count : TrialSum) {
		System.out.println(count);
	}
	// Prints each random sum. Needs to print # of occurrences in TrialSum ArrList. 
	System.out.println("Random Hopper Sums");
	Collections.sort(Results);
	for (int count : Results) {
		System.out.println(count);			
	}
int count = 0;
	for (int i = 0; i < Results.size(); i++) { 
		for (int j = i + 1 ; j < Results.size(); j++) { 
			if (Results.get(i).equals(Results.get(j))) { 
				// gets the duplicate element index spot. 
					count = Results.get(i);
				 //Samesies.add(i);
			}
		}
	}
	System.out.println("Same elems "+ count);
	
	//System.out.println(Samesies);

	/*System.out.println("Occurences");
	for(Integer S : Results) {
		for (Integer R : TrialSum) {
			if(R.intValue()== S.intValue()) {
				Occurences.add(R);
			}
		}
	}
	int[] occur = new int[2];
	Collections.sort(Occurences);
	System.out.println(Occurences);
	*/
	// Print each list side by side. should print count instead of results
	/*for (int i = 0; i < TrialSum.size(); i++) {
		System.out.printf("%d\t%d\n", Results.get(i), TrialSum.get(i));
	}*/
	
  }
	
 }

