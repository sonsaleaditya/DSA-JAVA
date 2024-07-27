import java.util.*;

public class FirstNegativeNumberInKthWindow {
    public static void main(String[] args) {
        int arr[] = { 12, -1, -7, -8, -16, 30, 16, 23 };
        int k = 3;

        // Call the method and print the result
        System.out.println(findFirstNegativeInWindow(arr, k));
    }

    // Method to find the first negative number in every window of size k
    static ArrayList<Integer> findFirstNegativeInWindow(int arr[], int k) {
        Queue<Integer> q = new LinkedList<>(); // Queue to store negative numbers in the current window

        int n = arr.length; // Length of the array
        int s = 0; // Start index of the window
        int e = 0; // End index of the window
        ArrayList<Integer> result = new ArrayList<>(); // List to store the result

        // Iterate over the array
        while (e < n) {
            // If the current element is negative, add it to the queue
            if (arr[e] < 0) {
                q.add(arr[e]);
            }

            // Check if the current window size is k
            if (e - s + 1 == k) {
                // If the queue is empty, add 0 to the result (no negative number in the current window)
                if (q.isEmpty()) {
                    result.add(0);
                } else if (arr[s] == q.peek()) {
                    // If the element at the start of the window is the same as the front of the queue,
                    // add the front of the queue to the result and remove it from the queue
                    result.add(q.poll());
                } else {
                    // If the front of the queue is not the element at the start of the window,
                    // add the front of the queue to the result
                    result.add(q.peek());
                }
                // Move the start index to the right to slide the window
                s++;
            }
            // Move the end index to the right to expand the window
            e++;
        }

        return result; // Return the result list
    }
}
