public class FindMIddle {
    public static void main(String[] args) {
        Node newnNode = new Node(1);
        newnNode.next = new Node(2);
        newnNode.next.next = new Node(3);
        newnNode.next.next.next = new Node(4);
        newnNode.next.next.next.next = new Node(5);
//20 15 2 13 2 10 13 3 2 6
        Solution obj  = new Solution();

        System.out.println(obj.getMiddle(newnNode));
    }


}

class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next=null;
    }
}

class Solution {
    int getMiddle(Node head) {
        Node slow = head, fast = head;
        
        while(fast!=null & fast.next!=null){
           // System.out.println(fast.data + " ");
            slow  = slow.next; 
            if(fast.next.next != null)
                 fast = fast.next.next;
            else return slow.data;

        }
        
        return slow.data;
        
    }
}
