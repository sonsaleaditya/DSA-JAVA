/*
 * There is an array arr of heights of stone and Geek is standing at the first stone and can jump to one of the following: Stone i+1, i+2, ... i+k stone, where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches the last stone.

Example:

Input: k = 3, arr[]= [10, 30, 40, 50, 20]
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30, which is minimum
 */


    public class MinimalCost {
        public static void main(String[] args) {
            int k = 3;
            int arr[] = { 10, 30, 40, 50, 20 };
    
            System.out.println(minCost(arr, k));  // Expected output: 30
        }
    
        static int minCost(int arr[], int k) {
            int n = arr.length;
            int dp[] = new int[n];
    
            // Initialize dp[0] to 0 because no cost is incurred on the first stone.
            dp[0] = 0;
    
            // Initialize all other stones' costs to a large number (Infinity).
            for (int i = 1; i < n; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
    
            // Iterate over each stone
            for (int i = 0; i < n; i++) {
                // For each stone i, try jumping to i+1, i+2, ..., i+k (if within bounds)
                for (int j = 1; j <= k && i + j < n; j++) {
                    // Update dp[i+j] with the minimum cost to reach that stone
                    dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(arr[i + j] - arr[i]));
                }
            }
    
            // The minimum cost to reach the last stone is stored in dp[n-1]
            return dp[n - 1];
        }
    }
    