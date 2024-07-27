// In a restaurant, two waiters, A and B, receive n orders per day, earning tips as per arrays arr[i] and brr[i] respectively. If A takes the ith order, the tip is arr[i] rupees; if B takes it, the tip is brr[i] rupees.

// To maximize total tips, they must distribute the orders such that:

// A can handle at most x orders
// B can handle at most y orders
// Given that x + y ≥ n, all orders can be managed by either A or B. Return the maximum possible total tip after processing all the orders.

// Examples

// Input: n = 5, x = 3, y = 3, arr = {1, 2, 3, 4, 5}, brr = {5, 4, 3, 2, 1}
// Output: 21
// Explanation: Person A will serve the 3rd, 4th and 5th order while person B will serve the rest so the total tip from A = 3+4+5 & B = 5 + 4 i.e. 21. 

import java.util.*;

public class MaxTip {
    public static void main(String[] args) {
        Solution obj = new Solution();
         int n = 5, x = 3, y = 3, arr[] = {1, 2, 3, 4, 5}, brr[] = {5, 4, 3, 2, 1};
       // int n = 8, x = 4, y = 4, arr[] = {1, 4, 3, 2, 7, 5, 9, 6}, brr[] = {1, 2, 3, 6, 5, 4, 9, 8};
        System.out.println(obj.maxTip(n, x, y, arr, brr));
    }
}

class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        long tip = 0;

        // Create an array of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on the difference in tips (absolute values in descending order)
        Arrays.sort(indices, (i, j) -> Math.abs(arr[j] - brr[j]) - Math.abs(arr[i] - brr[i]));

        // Assign orders to maximize tips
        for (int i : indices) {
            if (arr[i] > brr[i]) {
                if (x > 0) {
                    tip += arr[i];
                    x--;
                } else {
                    tip += brr[i];
                    y--;
                }
            } else {
                if (y > 0) {
                    tip += brr[i];
                    y--;
                } else {
                    tip += arr[i];
                    x--;
                }
            }
        }

        return tip;
    }

    
}