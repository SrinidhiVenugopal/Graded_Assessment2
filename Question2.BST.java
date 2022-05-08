package com.java.q2;

class Node
{
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    public static Node root;
    static Node prevNode = null;
    public static Node headNode = null;
    public void BST_To_SkewedTree(Node root) {
        if(root == null)
            return;

        BST_To_SkewedTree(root.left);

        if(headNode == null)
            headNode = root;
        else
            prevNode.right = root;

        root.left = null;
        prevNode = root;

        BST_To_SkewedTree(root.right);
    }

    public void Traverse_Tree(Node root) {
        if(root == null)
            return;

        if (root.left != null)
            Traverse_Tree(root.left);

        System.out.print(root.data + " ");

        if (root.right != null)
            Traverse_Tree(root.right);
    }
}
