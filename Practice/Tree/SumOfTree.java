import java.util.LinkedList;
import java.util.Queue;

public class SumOfTree {
    public static void main(String[] args) {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        Solution solution = new Solution();
        System.out.println("Is the given tree a Sum Tree? " + solution.isSumTree(root));
    }
}

    



/**
 * Problem Statement:
 * Given a binary tree, write a function to check whether the given tree is a Sum Tree.
 * A Sum Tree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree.
 * An empty tree is considered a Sum Tree. A leaf node is also considered a Sum Tree.
 */

 
 class Solution {
     // Function to check if the given tree is a Sum Tree
     boolean isSumTree(Node root) {
         // An empty tree is a Sum Tree
         if (root == null) return true;
 
         // Queue for level order traversal
         Queue<Node> q = new LinkedList<>();
         q.add(root);
 
         // Perform level order traversal
         while (!q.isEmpty()) {
             Node p = q.remove();
 
             // Value of the current node
             int v = p.data;
 
             // If left child exists, subtract its value from the current node's value
             if (p.left != null) {
                 q.add(p.left);
                 v -= p.left.data;
             }
 
             // If right child exists, subtract its value from the current node's value
             if (p.right != null) {
                 q.add(p.right);
                 v -= p.right.data;
             }
 
             // If the value is not zero, it's not a Sum Tree
             if (v != 0) return false;
         }
 
         // If all nodes satisfy the Sum Tree property
         return true;
     }
    }
 
     // Main method to test the function
     
 
 // Definition for a binary tree node
 class Node {
     Node left, right;
     int data;
 
     // Constructor to create a new tree node
     Node(int k) {
         this.data = k;
         this.right = null;
         this.left = null;
     }
 }
 