// original
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSTtoMaxHeap {
    public static void main(String[] args) {
        Solution obj = new Solution();
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        obj.convertToMaxHeapUtil(root);

        obj.printLevelOrder(root);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public void convertToMaxHeapUtil(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        levelOrder(root, arr);
        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i);
        }

        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            int l = i*2 + 1;
            int r = i*2 + 2;
            if(arr.get(l) > arr.get(r)){
                int temp = arr.get(l);
                arr.set(l, arr.get(r));
                arr.set(r, temp);
            }

        }
       
        rebuildBST(root, arr, 0);
        
    }

    private void levelOrder(Node root, ArrayList<Integer> arr) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            arr.add(curr.data);
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    private void maxHeapify(ArrayList<Integer> arr, int index) {
        int largest = index;
        int l = 2 * index + 1;
        int r = 2 * index + 2;

        if (l < arr.size() && arr.get(largest) < arr.get(l)) {
            largest = l;
        }
        if (r < arr.size() && arr.get(largest) < arr.get(r)) {
            largest = r;
        }
        if (largest != index) {
            int temp = arr.get(index);
            arr.set(index, arr.get(largest));
            arr.set(largest, temp);
            maxHeapify(arr, largest);
        }
    }

    private void rebuildBST(Node root, ArrayList<Integer> arr, int index) {
        if (root == null || index >= arr.size())
            return;
        root.data = arr.get(index);
        rebuildBST(root.left, arr, 2 * index + 1);
        rebuildBST(root.right, arr, 2 * index + 2);
    }

    public void printLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            System.out.print(curr.data + " -> ");
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    void postOrder(Node root){
        if(root == null)
        {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
