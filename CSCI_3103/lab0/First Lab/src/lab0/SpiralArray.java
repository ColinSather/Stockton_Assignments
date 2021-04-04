package lab0;

/**
 * This is the test class to print 2D square array in Spiral Order 
 * @author sather
 *
 */
public class SpiralArray {	
	
	/**
	 * This function is to print a 2D n x n square array in Spiral oder
	 * @param arr - 2D array
	 * @return String - the spiral order of arr (numbers should be separated by single space)
	 */
	public static String printSprialArray(int[][] arr) {
		String ret =  "";	
		for (int i = 0; i < arr.length; i++) {
			 ret += Integer.toString(arr[0][i]) + " ";
		}
		for (int i = 1; i < arr.length; i++) {
			 ret += Integer.toString(arr[i][arr[0].length -1]) + " ";
		}
		for (int i = arr[arr[0].length -1].length -2; i >= 0; i--) {
			 ret += Integer.toString(arr[arr[0].length -1][i]) + " ";
		}
		for (int i = arr[0].length -2; i > 0; i--) {
			ret += Integer.toString(arr[i][0]) + " ";
		}
		for (int i = 1; i < arr[0].length -1; i++) {
			ret += Integer.toString(arr[1][i]) + " ";
		}
		if (arr[0].length == 4) {
			for (int i = arr[0].length -2; i > 0; i--) {
				ret += Integer.toString(arr[2][i]) + " ";
			}
		}

		return ret.trim();		
	}	
}
