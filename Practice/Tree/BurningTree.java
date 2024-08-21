import java.util.*;

public class BurningTree {
    public static void main(String[] args) {
        // Construct the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.right = new Node(6);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);

        int target = 8;

        Solution obj = new Solution();
        System.out.println("Minimum time to burn the tree: " + obj.minTime(root, target)); // Output: 7
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {

    // Helper method to create a parent map and return the target node
    private static Node createParentMap(Node root, int target, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        Node targetNode = null;

        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.data == target) {
                targetNode = node;
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        return targetNode;
    }

    // Method to calculate the minimum time to burn the tree
    public static int minTime(Node root, int target) {
        // Base case
        if (root == null) {
            return 0;
        }

        // Map to store parent references
        Map<Node, Node> parentMap = new HashMap<>();

        // Create parent map and get the target node
        Node targetNode = createParentMap(root, target, parentMap);

        // BFS to calculate the minimum time
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                // Burn left child
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                    burned = true;
                }

                // Burn right child
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                    burned = true;
                }

                // Burn parent
                Node parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                    burned = true;
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;
    }

}
