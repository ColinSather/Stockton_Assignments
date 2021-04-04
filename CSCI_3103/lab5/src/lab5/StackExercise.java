package lab5;


import java.util.LinkedList;
import java.util.Stack;

public class StackExercise {

		/*
		 * Given an expression string exp,
		 *  write a program to examine whether the pairs and 
		 *  the orders of parenthesis are correct in exp. 
		 *  For example, the program should print true for exp = [()[]]
		 *  and false for exp = [()[])
		 */
		/**
		 * 
		 * @param str 
		 * @return  true if balanced; false is unbalanced 
		 */
		public static boolean isBalancedParentheses(String str)
		{
			Stack<Character> stk = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '[' || ch == '(') {
					stk.push(ch);
					continue;
				}
				/*
				 *  If left ] check if stack != empty
				 *  and if it contains right [
				 */
				if (ch == ']') {
					if (!stk.isEmpty() && stk.peek() == '[') {
						stk.pop();
						continue;
					}
					else
						stk.push(ch);
				}
				
				if (ch == ')') {
					if (!stk.isEmpty() && stk.peek() == '(') {
						stk.pop();
						continue;
					}
					else
						stk.push(ch);
				}
			}
			return stk.isEmpty();
		}
		
		/*
		 * 
		 * Reverse the all the items in the linkedlist and return the return the head of the 
		 * reversed one, for example: A -> B -> C should be reversed as: C->B->A
		 */

		/**
		 * @param lst - the linkedlist to be reversed
		 * @return the linkedlist with all items reversed - 
		 */
		public static LinkedList<String> revLinkedList(LinkedList<String> lst)
		{
			LinkedList<String> reversedList = new LinkedList<String>(); 
			for (int i = lst.size() -1; i >= 0; --i) {
				reversedList.add(lst.get(i));
			}
			return reversedList; 
		}
		
		/* Extra credit exercise (10%):  This function evaluates "postfix" expressions (also called "Reverse Polish 
		 * Notation"), which are mathematical expressions but with the operators placed
		 * after operands instead of between.
		 * For example: 1 + 2 * 3 + 4  is written as 1 2 3 * + 4 + 
		 */
		/**
		 * 
		 * @param str
		 * @return the result of postfix expression
		 */
		
		public static int postfixEvaluate(String exp) {
		 	
			
			return -1; // remove this line
		}
	}
