class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    public Node addOne(Node head) {
        // Reverse the linked list to make addition easier
        head = reverseList(head);
        
        // Add one to the reversed list
        Node temp = head;
        int carry = 1;
        Node prev = null;
        
        while (temp != null) {
            int sum = temp.data + carry;
            carry = sum / 10;
            temp.data = sum % 10;
            prev = temp;
            temp = temp.next;
        }
        
        // If there's still a carry left, add a new node
        if (carry > 0) {
            prev.next = new Node(carry);
        }
        
        // Reverse the list back to its original order
        head = reverseList(head);
        
        return head;
    }
    
    // Helper function to reverse the linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}

public class AddOne {
    public static void main(String[] args) {
        // Test case: input is 9, which should become 10
        Node head = new Node(9);

        Solution obj = new Solution();
        Node h = obj.addOne(head);

        while (h != null) {
            System.out.print(h.data + "");
            h = h.next;
        }
    }
}
