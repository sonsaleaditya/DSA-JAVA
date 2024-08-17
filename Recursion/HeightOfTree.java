/*
 * Problem Statement:
 * 
 * Given a binary tree, write a program to find its height. The height of a 
 * binary tree is the number of edges on the longest path from the root to a 
 * leaf node. If the tree is empty, its height is considered to be 0.
 * 
 * Example:
 * Consider the following binary tree:
 * 
 *          1
 *         / \
 *        0   0
 *           /
 *          0
 * 
 * The height of the above tree is 2 (edges: 1 -> 0 -> 0).
 */

 public class HeightOfTree {
    public static void main(String[] args) {
        // Creating the root node of the binary tree with value 1
        Node root = new Node(1);
        
        // Adding left and right children to the root
        root.left = new Node(0);
        root.right = new Node(0);
        
        // Adding a left child to the right child of the root
        root.right.left = new Node(0);

        // Calculating and printing the height of the binary tree
        System.out.println("Height of the tree: " + height(root));
    }

    // Function to calculate the height of the binary tree
    static int height(Node root) {
        // If the root is null, return 0 (base case)
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int l = height(root.left);
        int r = height(root.right);

        // Return the height of the tree by taking the maximum of left and right subtree heights, plus 1 for the root
        return 1 + Math.max(l, r);
    }
}

// Node class representing a node in the binary tree
class Node {
    Node left, right; // Pointers to the left and right children
    int data; // Data stored in the node
    
    // Constructor to initialize a new node with the given data
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
