package lab2;

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

package lab2;

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
