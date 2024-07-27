import java.util.TreeMap;

public class RemoveAllDuplicateElements {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Construct the original linked list: 23->28->28->35->49->49->53->53
        Solution.Node head = new Solution.Node(23);
        head.next = new Solution.Node(28);
        head.next.next = new Solution.Node(28);
        head.next.next.next = new Solution.Node(35);
        head.next.next.next.next = new Solution.Node(49);
        head.next.next.next.next.next = new Solution.Node(49);
        head.next.next.next.next.next.next = new Solution.Node(53);
        head.next.next.next.next.next.next.next = new Solution.Node(53);

        System.out.print("Original List: ");
        solution.printList(head); // Print the original list

        // Remove duplicates and print the modified list
        Solution.Node newHead = solution.removeAllDuplicates(head);
        System.out.print("Modified List: ");
        solution.printList(newHead); // Print the modified list
    }
}

class Solution {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to remove all duplicates and return a sorted list with unique elements
    public Node removeAllDuplicates(Node head) {
        if (head == null) return null; // If the list is empty, return null

        // First pass: count occurrences of each element using TreeMap for sorted order
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        Node temp = head;
        while (temp != null) {
            countMap.put(temp.data, countMap.getOrDefault(temp.data, 0) + 1);
            temp = temp.next;
        }

        // Second pass: rewrite nodes with elements that have count 1
        temp = head;
        Node newHead = null, newTail = null;

        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == 1) { // If the element occurs only once
                if (newHead == null) {
                    newHead = new Node(key); // Initialize the new list
                    newTail = newHead;
                } else {
                    newTail.next = new Node(key); // Add unique elements to the new list
                    newTail = newTail.next;
                }
            }
        }

        return newHead; // Return the head of the new list
    }

    // Helper method to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
