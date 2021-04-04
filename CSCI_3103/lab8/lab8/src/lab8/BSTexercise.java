package lab8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;




public class BSTexercise {
	/*
	 * Construct BST from preorder traversal
	 */
	public static Node<Integer> consBSTfromPreOrder(int[] arr, int start, int end)
	{
				
		if(start > end) return null;
		
		Node<Integer> root = new Node<Integer>(arr[start], null, null);
		
		
		int index = start+1;
		while(index <= end)
		{
			if (arr[index] < arr[start])
			{
				index ++;
			}
			else
			{
				break;
			}
		}
				
		root.left = consBSTfromPreOrder(arr, start + 1, index -1);
		
		root.right = consBSTfromPreOrder(arr, index, end);
		
		return root;		
	}
		
	
  /****************************************************
   *  Please implement the following functions 	
   * **************************************************/
	
	/**
	 * 
	 * @param root - the root of given BST
	 * @return the maximum data in the given BST or Integer.MAX_VALUE if empty BST
	 */
	public static int maxBST(Node<Integer> root)
	{
		if (root == null)
			return Integer.MAX_VALUE;
		
		while (root.right != null) {
			root = root.right;
		}

		return root.data;
	}	
		
	
	/**
	 * 
	 * @param root  - the root of given binary search tree
	 * @return - the minimum data in the given BST or Integer.MIN_VALUE if empty BST
	 */
	
	public static int minBST(Node<Integer> root)
	{
		if (root == null)
			return Integer.MIN_VALUE;
		
		while (root.left != null) {
			root = root.left;
		}
		
		return root.data; 
	}
	
	/**
	 * @param root1 - root of tree-1
	 * @param root2 - root of tree-2
	 * @return  true if the same; otherwise, false
	 */
	public static boolean sameBST(Node<Integer> root1, Node<Integer> root2)
	{
		if (root1 == null && root2 == null)
			return true;
		 if (root1 != null && root2 != null) {
			return (root1.data == root2.data && sameBST(root1.left, root2.left)
					&& sameBST(root1.right, root2.right));
		}
		return false;
	}
	
		
	/**
	 * 
	 * @param root - the root of the given BST
	 * @return the mirror of BST
	 */
	public static Node<Integer> mirrorBST(Node<Integer> root)
	{
		if (root == null)
			return root;
		Node<Integer> n1 = mirrorBST(root.left);
		Node<Integer> n2 = mirrorBST(root.right);
		root.left = n2;
		root.right = n1;
		
		return root; 
	}
	
	
	
	/* ====== Extra Credit (5% for each question)  ==============================*/	
	
	/**
	 * 
	 * @param root - the root of the given BST
	 * @return the height of BST
	 */
	
	public static int heightBST(Node<Integer> root)
	{
		
		//TODO: add your code here
		return 0;  //remove this line after your coding
	}
	
	
	
	/**
	 * 
	 * @param root - the given root of binary tree
	 * @return true if a binary search tree; otherwise false
	 */
	
	public static boolean isBST(Node<Integer> root)
	{
		//TODO: please add your code here
		
		return false; // please remove this line after your coding
		
	}
	
	
	
	
	
}
