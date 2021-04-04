package lab8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class TestBSTexercise {
	
	private Node<Integer> root1;
	private Node<Integer> root2;
	private Node<Integer> root3;	
	private Node<Integer> root4;
	
	
	@Before
	  public void setUp()
	  {
		int[] arr1 = {20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40};
		int[] arr2 = {10, 5, 2, 7, 40, 50};
		int[] arr3 = {2,1,3};
		int[] arr4 = {3,2,7,4,8};
		root1 = BSTexercise.consBSTfromPreOrder(arr1, 0, arr1.length-1);
		root2 = BSTexercise.consBSTfromPreOrder(arr2, 0, arr2.length-1);
		root3 = BSTexercise.consBSTfromPreOrder(arr3, 0, arr3.length-1);
		
		root4 = BSTexercise.consBSTfromPreOrder(arr4, 0, arr4.length-1);
	  }
	
		
	@Test(timeout = 100)
	public void testmaxBST()
	{
		assertEquals("maxBST function failed",40, BSTexercise.maxBST(root1));
		assertEquals("maxBST function failed", 50, BSTexercise.maxBST(root2));
		assertEquals("maxBST function failed", 3, BSTexercise.maxBST(root3));
	}
	
	@Test(timeout = 100)
	public void testminBST()
	{
		assertEquals("minBST function failed",1, BSTexercise.minBST(root1));
		assertEquals("minBST function failed", 2, BSTexercise.minBST(root2));
		assertEquals("minBST function failed", 1, BSTexercise.minBST(root3));
	}
		
	@Test(timeout = 100)
	public void testsameBST()
	{
		int[] arr1 = {20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40};
		int[] arr4 = {3,2,7,4,8};
		
		Node<Integer> root4_2 =  BSTexercise.consBSTfromPreOrder(arr4, 0, arr4.length-1);
		Node<Integer> root1_2 =  BSTexercise.consBSTfromPreOrder(arr1, 0, arr1.length-1);
		assertEquals("sameBST function failed",true, BSTexercise.sameBST(root1, root1_2));
		assertEquals("sameBST function failed", true, BSTexercise.sameBST(root4, root4_2));
		changeNode(root4, 0);
		assertEquals("sameBST function failed", false, BSTexercise.sameBST(root4_2, root4));
	}
	
	@Test(timeout = 100)
	public void testmirrorBST()
	{	
		int[] arr5 = {3,2,7,4,8};
		Node<Integer> root5 =  consrevBSTfromPreOrder(arr5, 0, arr5.length-1);
	    Node<Integer> mirror_r4 = BSTexercise.mirrorBST(root4);		
		assertEquals("mirrorBST function failed",true, BSTexercise.sameBST(root5, mirror_r4));
		changeNode(root5, 1);
		assertEquals("mirrorBST function failed",false, BSTexercise.sameBST(root5, mirror_r4));
	}
		
	/*
	 * Construct mirror-BST from preorder traversal
	 */
	public Node<Integer> consrevBSTfromPreOrder(int[] arr, int start, int end)
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
				
		root.right = consrevBSTfromPreOrder(arr, start + 1, index -1);
		
		root.left = consrevBSTfromPreOrder(arr, index, end);
		
		return root;		
	}
	
	
	public void changeNode(Node<Integer> root, int val)
	{
		if (root == null) return;
		
		Node<Integer> temp = root;
		while(temp.left != null)
		{
			temp = temp.left;
		}
		
		temp.data = val;
	}
	
	
	
/**
 * 	
 *  Uncomment the following test cases for extra credit questions
 */
/*	@Test(timeout = 100)
	public void testheightBST()
	{
		assertEquals("theightBST function failed",2, BSTexercise.heightBST(root3));
		assertEquals("theightBST function failed", 3, BSTexercise.heightBST(root2));
		assertEquals("theightBST function failed", 3, BSTexercise.heightBST(root4));
	}
	
	
	@Test(timeout = 100)
	public void testisBST()
	{
		assertEquals("isBST function failed", true, BSTexercise.isBST(root1));
		assertEquals("isBST function failed", true, BSTexercise.isBST(root2));
		assertEquals("isBST function failed", true, BSTexercise.isBST(root3));
		changeNode(root1, 19);
		assertEquals("isBST function failed", false, BSTexercise.isBST(root1));
		changeNode(root2, 8);
		assertEquals("isBST function failed", false, BSTexercise.isBST(root2));
		
	}*/	
	
}


  