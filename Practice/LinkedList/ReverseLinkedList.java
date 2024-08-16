public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        ReverseLinkedList obj = new ReverseLinkedList();
        Node h = obj.reverseList(head);
        Node temp = h;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    Node reverseList(Node head) {
        Node prev = null, next = null, curr = head;
        
        while (curr != null) {
            next = curr.next;  // Store the next node
            curr.next = prev;  // Reverse the current node's pointer
            prev = curr;       // Move prev to the current node
            curr = next;       // Move to the next node
        }
        
        return prev;  // Prev will be the new head after the loop
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
