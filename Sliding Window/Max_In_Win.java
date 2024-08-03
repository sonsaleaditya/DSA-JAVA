import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Max_In_Win {

    public static void main(String[] args) {
        int arr[] = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
        int k = 3;

        Solution sol = new Solution();
        ArrayList<Integer> result = sol.max_of_subarrays(arr, arr.length, k);
        System.out.println(result);
    }
}

class Solution {

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of this window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements not useful in this window
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add current element at the rear of deque
            deque.offer(i);

            // The element at the front of the deque is the largest element of
            // the current window, so add it to the result
            if (i >= k - 1) {
                result.add(arr[deque.peek()]);
            }
        }

        return result;
    }
}
