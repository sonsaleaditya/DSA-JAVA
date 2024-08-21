import java.util.Stack;

/*
 * Problem Statement:
 * Given a stack, delete the middle element of the stack without using any additional data structures 
 * like another stack, queue, etc. The middle element here is defined as the ⌈size/2⌉th element.
 * 
 * Example:
 * Input: Stack = [1, 2, 3, 4, 5]
 * Output: Stack after deletion = [1, 2, 4, 5]
 * 
 * Input: Stack = [1, 2, 3, 4, 5, 6]
 * Output: Stack after deletion = [1, 2, 3, 5, 6]
 */

public class Delete_Middle_Of_Stack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);

        // Calculate the position of the middle element
        delete(stk, stk.size() / 2 + 1);
        
        // Print the stack after deletion
        System.out.println(stk.toString());
    }

    static void delete(Stack<Integer> st, int k) {
        // Base case: When k is 1, we have reached the middle element
        if (k == 1) {
            st.pop();  // Remove the middle element
            return;
        }

        // Remove the top element and store it temporarily
        int temp = st.pop();
        
        // Recursive call to reach the middle element
        delete(st, k - 1);
        
        // Push the stored element back to the stack
        st.push(temp);
    }
}
