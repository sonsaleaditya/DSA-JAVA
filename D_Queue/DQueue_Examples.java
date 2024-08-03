import java.util.Deque;
import java.util.LinkedList;

public class DQueue_Examples {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        // Adding elements to the Deque
        deque.addFirst(10); // Adds 10 at the beginning
        deque.addLast(20);  // Adds 20 at the end
        deque.offerFirst(5); // Offers 5 at the beginning
        deque.offerLast(25); // Offers 25 at the end

        System.out.println("Initial Deque: " + deque);

        // Removing elements from the Deque
        deque.removeFirst(); // Removes the first element (5)
        deque.removeLast();  // Removes the last element (25)
        deque.pollFirst();   // Polls (removes) the first element (10)
        deque.pollLast();    // Polls (removes) the last element (20)

        System.out.println("Deque after removals: " + deque);

        // Adding elements again
        deque.addFirst(15);
        deque.addLast(30);
        deque.offerFirst(7);
        deque.offerLast(35);

        System.out.println("Deque after adding elements again: " + deque);

        // Accessing elements without removing
        int firstElement = deque.getFirst(); // Gets the first element (7)
        int lastElement = deque.getLast();   // Gets the last element (35)
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);

        int peekFirstElement = deque.peekFirst(); // Peeks the first element (7)
        int peekLastElement = deque.peekLast();   // Peeks the last element (35)
        System.out.println("Peek first element: " + peekFirstElement);
        System.out.println("Peek last element: " + peekLastElement);

        // Iterating through the Deque
        System.out.println("Iterating through the Deque:");
        for (int elem : deque) {
            System.out.println(elem);
        }
    }
}
