import java.util.Stack;

/*
Problem Statement:
Given a stack of integers, reverse the stack using recursion. You are not allowed to use any loop constructs (for, while, etc.). The goal is to reverse the elements of the stack so that the last element becomes the first, the second-to-last becomes the second, and so on.

Input:
A stack of integers, for example: [1, 2, 3]

Output:
The reversed stack of integers, for example: [3, 2, 1]

Explanation:
The input stack [1, 2, 3] will be reversed so that the elements appear in the reverse order when popped. 
After reversing, the stack will be [3, 2, 1].
*/

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        ReverseStack rs = new ReverseStack();
        rs.reverse(st);
        
        // Printing the reversed stack
        System.out.println(st.toString()); // Output: [3, 2, 1]
    }

    // Function to reverse the stack using recursion
    void reverse(Stack<Integer> st) {
        // Base case: if stack has only one element, return
        if (st.size() == 1) {
            return;
        }
        
        // Pop the top element
        int temp = st.pop(); // temp holds the top element (e.g., 3, 2, 1)
        
        // Recursively reverse the remaining stack
        reverse(st);
        
        // Insert the popped element back into the reversed stack
        insert(st, temp);
        return;
    }

    // Helper function to insert an element at the bottom of the stack
    void insert(Stack<Integer> st, int element) {
        // If stack is empty, push the element
        if (st.isEmpty()) {
            st.push(element);
            return;
        }

        // Pop the top element
        int temp = st.pop();
        
        // Recursively insert the element at the bottom
        insert(st, element);
        
        // Push the popped element back to the top
        st.push(temp);
        return;
    }
}
