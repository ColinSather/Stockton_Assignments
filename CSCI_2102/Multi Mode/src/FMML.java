import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class FMML {
	static ArrayList<Integer> findModes(ArrayList<Integer> list) {
		ArrayList<Integer> modes = new ArrayList<Integer>();
		int maxCount = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == list.get(i))
                    ++count;
            }

            if (count > maxCount) {
                maxCount = count;
                modes.clear();
                modes.add(list.get(i));
            } else if (count == maxCount) {
            	modes.add(list.get(i));
            }
        }
        return modes;
	}
	
	static int getCount(ArrayList<Integer> list) {
		 int maxCount = 0;
	        for (int i = 0; i < list.size(); i++) {
	            int count = 0;
	            for (int j = 0; j < list.size(); j++) {
	                if (list.get(j) == list.get(i))
	                    count++;
	            }
	            if (count > maxCount) {
	                maxCount = count;
	            }
	        }
	     return maxCount;
	}
	
	public static void main(String[] args) {
		 ArrayList<Integer> numList = new ArrayList<>();
		 StopWatch s = new StopWatch();
		 Random generator = new Random();
		 
		 // Do not call System.out.println/printf until after s.stop();
		 s.start();
		 for (int i =0; i<60; i++) {
		   numList.add(generator.nextInt(90)+10);
		 }
		 Collections.sort(numList);
		 ArrayList<Integer> list = findModes(numList);
		 int y = getCount(list);
		 Set<Integer> NoDuplicates = new LinkedHashSet<Integer>(list);
		 list.clear();
		 list.addAll(NoDuplicates);
		 s.stop();
		 
		 // Print out the multi-mode and the elapsed run time
		 System.out.println("Found the Multi Modal Limit of 60 Random Integers between 10 and 100");
		 System.out.println(numList);
		 System.out.println("");
		 System.out.println("Multi-modes: "+list+" each occur "+y+" time(s).");
		 System.out.printf("Run time: %.2f seconds", s.getElapsedTime()/100.0 ); 
	}
}
