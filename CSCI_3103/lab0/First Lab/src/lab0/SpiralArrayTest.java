/**
 *  This is the test file for SprialArray Class
 */
package lab0;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Zheng
 *
 */
public class SpiralArrayTest {

	@Test
	public void testPrintSpiral1() {
		int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};	
		String str = "1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10";		
		assertEquals("SpiralArrayPrint function is wrong !", str, SpiralArray.printSprialArray(arr));
		
	}
	
	@Test
	public void testPrintSpiral2() {
		int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};	
		String str = "1 2 3 6 9 8 7 4 5";
		assertEquals("SpiralArrayPrint function is wrong !", str, SpiralArray.printSprialArray(arr));
	}

}
