import java.util.ArrayList;

public class LeftView {
    public static void main(String[] args) {
        // Create nodes of the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);

        // Create Tree object and get the left view
        Tree tree = new Tree();
        ArrayList<Integer> leftView = tree.leftView(root);

        // Print the left view of the binary tree
        System.out.println("Left view of the binary tree: " + leftView);
    }
}

// Definition of a Binary Tree node
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

// Class to handle the binary tree operations
class Tree {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        fill(root, arr, 0);
        return arr;
    }

    // Helper function to fill the left view of the binary tree.
    void fill(Node root, ArrayList<Integer> arr, int level) {
        if (root == null) {
            return;
        }

        // If this is the first node of its level
        if (arr.size() == level) {
            arr.add(root.data);
        }

        // Recur for left subtree first, then right subtree
        fill(root.left, arr, level + 1);
        fill(root.right, arr, level + 1);
    }
}


