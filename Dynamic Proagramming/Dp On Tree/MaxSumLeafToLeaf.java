public class MaxSumLeafToLeaf {
    // Class to store the result as an object to be updated in the recursive method
    static class Result {
        int maxSum = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        // Example tree:
        //         10
        //       /    \
        //      2      10
        //     / \       \
        //    20   1      -25
        //               /  \
        //              3    4
        
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        
        MaxSumLeafToLeaf tree = new MaxSumLeafToLeaf();
        Result result = new Result();
        tree.maxSum(root, result);
        System.out.println("Maximum path sum between two leaves is: " + result.maxSum);
    }

    /**
     * This function calculates the maximum path sum between two leaves of the binary tree.
     * It recursively traverses the tree and updates the maximum sum encountered.
     *
     * @param root The root node of the current subtree
     * @param result An object to store the maximum path sum
     * @return The maximum path sum for the current subtree
     */
    int maxSum(Node root, Result result) {
        // Base case: If the node is null, return 0 as it contributes nothing to the sum
        if (root == null) {
            return 0;
        }

        // If the node is a leaf node, return its value
        if (root.left == null && root.right == null) {
            return root.data;
        }

        // Recursively find the maximum sum on the left and right subtrees
        int leftSum = maxSum(root.left, result);
        int rightSum = maxSum(root.right, result);

        // If either left or right child is null, return the sum of the non-null child and current node value
        if (root.left == null) {
            return rightSum + root.data;
        }
        if (root.right == null) {
            return leftSum + root.data;
        }

        // Calculate the maximum sum for the path passing through the current node
        int currentMax = leftSum + rightSum + root.data;

        // Update the overall maximum path sum if the current maximum is greater
        result.maxSum = Math.max(result.maxSum, currentMax);

        // Return the maximum sum of the path which includes the current node and one of its children
        return Math.max(leftSum, rightSum) + root.data;
    }
}

/**
 * Node class for the binary tree.
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
