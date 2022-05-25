package learnJava;

import java.io.*;

class Node
{
	int val;
	Node left, right;
	
		Node(int item)
	{
		val = item;
		left = right = null;
	}
}

class GFG
{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	// Function to to flatten the binary
	// search tree into a skewed tree in
	// increasing / decreasing order
	static void BSToSkewed(Node root,
								int order)
	{
		
		if(root == null)
		{
			return;
		}
		
		if(order > 0)
		{
			BSToSkewed(root.right, order);
		}
		else
		{
			BSToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
	
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		
		if (order > 0)
		{
			BSToSkewed(leftNode, order);
		}
		else
		{
			BSToSkewed(rightNode, order);
		}
	}
	
	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);	
	}

	public static void main (String[] args)
	{
	
		GFG tree = new GFG();
		
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(55);
	
		int order = 0;
		BSToSkewed(node, order);
		traverseRightSkewed(headNode);
	}
}
