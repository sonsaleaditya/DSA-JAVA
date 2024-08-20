import java.util.Stack;

public class SortStack {

    /*
     * Problem Statement:
     * Given a stack of integers, write a function to sort the stack in ascending order
     * using recursion. You are not allowed to use any loop constructs like while, for, etc.
     * The only functions that can be used are push, pop, peek, and isEmpty on the stack.
     * The sorted stack should have the smallest elements on top.
     * 
     * Input:
     * Stack elements in the order they are pushed: [5, 2, 7]
     * 
     * Output:
     * Sorted stack: [2, 5, 7]
     */

    public static void main(String[] args) {
        // Initialize the stack and push elements onto it
        Stack<Integer> stk = new Stack<>();
        stk.push(5);
        stk.push(2);
        stk.push(7);

        // Create an instance of SortStack and sort the stack
        SortStack obj = new SortStack();
        obj.sort(stk);

        // Print the sorted stack
        System.out.println(stk.toString());
    }

    // Method to sort the stack using recursion
    void sort(Stack<Integer> stk) {
        // Base case: If stack has only one element, return
        if (stk.size() == 1) {
            return;
        }

        // Pop the top element and store it in a temporary variable
        int temp = stk.pop();

        // Recursively sort the remaining stack
        sort(stk);

        // Insert the popped element back in the sorted order
        insert(stk, temp);
    }

    // Helper method to insert an element into the sorted stack
    void insert(Stack<Integer> stk, int element) {
        // If the stack is empty or the top element is smaller or equal to the element
        // Push the element back onto the stack
        if (stk.isEmpty() || stk.peek() <= element) {
            stk.push(element);
            return;
        }

        // Pop the top element and store it in a temporary variable
        int temp = stk.pop();

        // Recursively insert the element into the sorted stack
        insert(stk, element);

        // Push the popped element back onto the stack
        stk.push(temp);
    }
}
