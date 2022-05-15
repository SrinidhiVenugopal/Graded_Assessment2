package com.java.q2;

public class Main {
    static BinarySearchTree tree = new BinarySearchTree();

    public static void main(String[] args) {

       
        BinarySearchTree.root = new Node(50);
        BinarySearchTree.root.left = new Node(30);
        BinarySearchTree.root.right = new Node(60);
        BinarySearchTree.root.left.left = new Node(10);
        BinarySearchTree.root.right.left= new Node(55);

        tree.BST_To_SkewedTree(BinarySearchTree.root);

        System.out.print("\nSkewed Tree: ");
        tree.Traverse_Tree(BinarySearchTree.headNode);
    }

}
