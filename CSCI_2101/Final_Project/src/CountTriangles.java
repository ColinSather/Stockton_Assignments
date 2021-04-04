
import java.util.*; 
public class CountTriangles 
{ 
    // Function to count all possible triangles with arr[] elements. 
    static int findNumberOfTriangles(int arr[]) 
    { 
        int n = arr.length; 
        // Sort the array elements in non-decreasing order 
        Arrays.sort(arr); 
  
        // Initialize count of triangles 
        int count = 0; 
  
        for (int i = 0; i < n-2; ++i) 
        { 
            // Initialize index of the rightmost third element 
            int k = i + 2; 
  
            // Fix the second element 
            for (int j = i+1; j < n; ++j) 
            { 
                while (k < n && arr[i] + arr[j] > arr[k]) 
                    ++k; 
                if(k>j) 
                count += k - j - 1; 
            } 
        } 
        return count; 
    } 
    public static void main (String[] args) { 
    	Scanner in = new Scanner(System.in);
  	  	System.out.println("Enter the array length");
  	  	int n = in.nextInt();
        int[] arr = new int[n]; 
        for(int i = 0; i<n;i++) {
  		  arr[i]=(int)(1+Math.random()*100);
  	  	}
        if(n>=3) {
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println("Total number of triangles is " + 
                            findNumberOfTriangles(arr)); 
        }
        else
        	System.out.println("Array length must be at least 3 ");
        in.close();
    }
}