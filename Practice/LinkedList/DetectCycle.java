/**
 * Problem Statement:
 * 
 * Given the head of a Singly LinkedList, write a function to determine if the 
 * LinkedList has a cycle in it or not.
 * 
 * A LinkedList cycle occurs when a node's next pointer points back to one of 
 * the previous nodes, forming a loop. The goal is to detect whether such a loop 
 * exists in the LinkedList.
 * 
 * Approach:
 * 
 * We'll use the Fast & Slow pointer (Hare & Tortoise) approach to solve this problem:
 * - The slow pointer moves one step at a time.
 * - The fast pointer moves two steps at a time.
 * - If the LinkedList has a cycle, the fast pointer will eventually meet the slow 
 *   pointer inside the loop. If there's no cycle, the fast pointer will reach the 
 *   end of the list (null) without ever meeting the slow pointer.
 */

 public class DetectCycle {
    
    public static void main(String[] args) {
        // Creating a LinkedList: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        
        // Uncomment the following line to create a cycle: 6 -> 3
         head.next.next.next.next.next.next = head.next.next;

        // Create an object of DetectCycle and check if the list has a cycle
        DetectCycle obj = new DetectCycle();
        System.out.println(obj.isCycle(head)); // Output: false (or true if cycle exists)
    }

    /**
     * Function to detect if a cycle exists in the LinkedList.
     * 
     * @param head The head node of the LinkedList.
     * @return true if a cycle is found, false otherwise.
     */
    boolean isCycle(Node head) {
        // Initialize both slow and fast pointers to the head of the LinkedList
        Node fast = head;
        Node slow = head;

        // Traverse the LinkedList
        while(fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by one step
            fast = fast.next.next;   // Move fast pointer by two steps

            // If slow and fast pointers meet, a cycle is detected
            if(slow == fast) {
                return true;
            }
        }
        // If no cycle is found, return false
        return false;
    }
}

/**
 * Node class representing a single node in the LinkedList.
 */
class Node {
    int value;   // Value of the node
    Node next;   // Pointer to the next node

    // Constructor to create a new node
    Node(int value) {
        this.value = value;
        this.next = null;
    }
}
