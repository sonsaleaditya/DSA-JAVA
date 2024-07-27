/*Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example 1:

Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output: 
3 3 4 5 5 5 6 
Explanation: 
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6
Example 2:

Input:
N = 10, K = 4
arr[] = 8 5 10 7 9 4 15 12 90 13
Output: 
10 10 10 15 15 90 90
Explanation: 
1st contiguous subarray = {8 5 10 7}, Max = 10
2nd contiguous subarray = {5 10 7 9}, Max = 10
3rd contiguous subarray = {10 7 9 4}, Max = 10
4th contiguous subarray = {7 9 4 15}, Max = 15
5th contiguous subarray = {9 4 15 12}, 
Max = 15
6th contiguous subarray = {4 15 12 90},
Max = 90
7th contiguous subarray = {15 12 90 13}, 
Max = 90 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaxOfAllSubArrays {
    ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // remove number out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = arr[q.peek()];
            }
        }
        for (int max : r) {
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxOfAllSubArrays solution = new MaxOfAllSubArrays();
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int n1 = 9, k1 = 3;
        ArrayList<Integer> result1 = solution.max_of_subarrays(arr1, n1, k1);
        System.out.println("Example 1 Output: " + result1); // Output: [3, 3, 4, 5, 5, 5, 6]

        int[] arr2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int n2 = 10, k2 = 4;
        ArrayList<Integer> result2 = solution.max_of_subarrays(arr2, n2, k2);
        System.out.println("Example 2 Output: " + result2); // Output: [10, 10, 10, 15, 15, 90, 90]
    }
}
