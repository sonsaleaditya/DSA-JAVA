import java.util.*;
public class isHeap {
    public static void main(String[] args) {
    Solution obj = new Solution();
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    System.out.println(obj.isHeap(root));
    }
 
   
}
class Solution {
    boolean isHeap(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        levelOrder(root, arr);
        
        // Check if the tree is complete and satisfies max-heap property
        int n = arr.size();
        boolean lastLevelStarted = false;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == null) {
                lastLevelStarted = true;
                continue;
            }
            
            if (lastLevelStarted && arr.get(i) != null)
                return false; // If any node after the first null in the array is not null, return false
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            if (leftChildIndex < n && arr.get(leftChildIndex) != null && arr.get(i) < arr.get(leftChildIndex))
                return false;
            if (rightChildIndex < n && arr.get(rightChildIndex) != null && arr.get(i) < arr.get(rightChildIndex))
                return false;
        }
        return true;
    }

    static void levelOrder(Node root, ArrayList<Integer> arr) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr != null) {
                arr.add(curr.data);
                q.add(curr.left);
                q.add(curr.right);
            } else {
                // If the current node is null, mark it as a missing node
                arr.add(null);
            }
        }
    }
}


class Node{
    Node left, right;
    int data;
    Node(int data){
        this.data=data;
        left = right = null;
    }
}
