class DiameterOfTree {
    // Class-level variable to store the diameter
    int res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // Sample tree creation for testing
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        DiameterOfTree tree = new DiameterOfTree();
        tree.diameter(root);
        System.out.println("Diameter of the tree is: " + tree.res);
    }

    // Function to calculate the diameter of the tree
    int diameter(Node root) {
        // Base case: If the tree is empty
        if (root == null) {
            return 0;
        }

        // Recursively get the height of the left and right subtrees
        int left = diameter(root.left);
        int right = diameter(root.right);

        // Height of the current node is max of heights of left and right subtrees plus 1
        int temp = Math.max(left, right) + 1;

        // Diameter is the max value of the height of left subtree + height of right subtree + 1
        int ans = left + right + 1;

        // Update the result (the diameter)
        res = Math.max(res, ans);

        // Return the height of the current node
        return temp;
    }
}

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
