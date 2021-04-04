/**
 * 
 */
package lab5;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

/**
 * @author Zheng
 *
 */
public class StackExerciseTest {

	
	@Test(timeout = 100)
	public void isBalancedParenthesestest1() {
		String str = "[]()";		
		assertTrue(StackExercise.isBalancedParentheses(str));
	}
	
	@Test(timeout = 100)
	public void isBalancedParenthesestest2() {
		String str = "[[](())]";		
		assertTrue(StackExercise.isBalancedParentheses(str));
	}
	
	@Test(timeout = 100)
	public void isBalancedParenthesestest3() {
		String str = "[()]](())]";			
		assertEquals(false, StackExercise.isBalancedParentheses(str));
	}
	
	
		
	@Test(timeout = 100)
	public void revLinkedListtest1() {
		LinkedList<String> lst = new LinkedList<String>();
		lst.add("A");
		lst.add("B");
		lst.add("C");
		String ret = "[C, B, A]";
		
		assertEquals(ret, StackExercise.revLinkedList(lst).toString());
	}
	
	@Test(timeout = 100)
	public void revLinkedListtest2() {
		LinkedList<String> lst = new LinkedList<String>();
		lst.add("A");
		lst.add("B");
		lst.add("C");
		lst.add("D");
		lst.add("E");
		String ret = "[E, D, C, B, A]";
		
		assertEquals(ret, StackExercise.revLinkedList(lst).toString());
	}
	
	
	@Test(timeout = 100)
	public void revLinkedListtest3() {
		LinkedList<String> lst = new LinkedList<String>();
		lst.add("A");
		
		String ret = "[A]";		
		assertEquals(ret, StackExercise.revLinkedList(lst).toString());
	}
	
/*
 *   Uncomment the following test cases for extra credit exercise
 * 		
 */
/*	@Test(timeout = 100)
	public void postfixEvaluatetest1() {
		String str = "1 2 +";		
		assertEquals(3, StackExercise.postfixEvaluate(str));
	}
	
	@Test(timeout = 100)
	public void postfixEvaluatetest2() {
		String str = "1 2 3 * + 4 +";		
		assertEquals(11, StackExercise.postfixEvaluate(str));
	}
	
	@Test(timeout = 100)
	public void postfixEvaluatetest3() {
		String str = "8 5 * 7 4 2 + * +";		
		assertEquals(82, StackExercise.postfixEvaluate(str));
	}
	
	@Test(timeout = 100)
	public void postfixEvaluatetest4() {
		String str = "6 8 2 / 1 - *";		
		assertEquals(18, StackExercise.postfixEvaluate(str));
	}
	*/

}
