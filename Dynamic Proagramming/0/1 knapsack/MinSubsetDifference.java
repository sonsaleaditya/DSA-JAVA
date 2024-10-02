/**
 * Problem Statement:
 * Given an array of integers, divide the array into two subsets such that the difference between the sum of the two subsets is minimized.
 * 
 * Input:
 * - An array of integers.
 * 
 * Output:
 * - The minimum difference between the sums of two subsets.
 * 
 * Example:
 * Input: arr = {1, 2, 7}
 * Output: 4
 * 
 * Explanation:
 * Subset 1: {1, 2}, Subset 2: {7}
 * Sum of Subset 1 = 3
 * Sum of Subset 2 = 7
 * Difference = |7 - 3| = 4
 */

 import java.util.ArrayList;

 public class MinSubsetDifference {
     public static void main(String[] args) {
         int[] arr = {1, 2, 7}; // Example array
         int range = 0;
 
         // Calculate the total sum of the array elements
         for (int k : arr)
             range += k;
 
         // Call the method to find the minimum subset difference and print the result
         System.out.println("Minimum difference is: " + minSubsetDiff(arr, range));
     }
 
     /**
      * This method calculates the minimum difference between the sums of two subsets of the given array.
      * 
      * @param arr    The input array of integers
      * @param range  The total sum of all elements in the array
      * @return       The minimum difference between two subsets
      */
     static int minSubsetDiff(int arr[], int range) {
         int n = arr.length;
 
         // Create a dp array to store whether a subset with a given sum is possible
         boolean dp[][] = new boolean[n + 1][range + 1];
 
         // Initialize the first row to false (except dp[0][0]), since no positive sum can be achieved with 0 elements
         for (int i = 1; i <= range; i++) 
             dp[0][i] = false;
 
         // Initialize the first column to true, since a sum of 0 can always be achieved with an empty subset
         for (int i = 0; i <= n; i++) 
             dp[i][0] = true;
 
         // Fill the dp array using the subset-sum logic
         for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= range; j++) {
                 if (arr[i - 1] <= j) {
                     // Include or exclude the current element arr[i-1]
                     dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                 } else {
                     // If the current element cannot be included, exclude it
                     dp[i][j] = dp[i - 1][j];
                 }
             }
         }
 
         // Find the subset sums that can be achieved (stored in the last row of the dp array)
         ArrayList<Integer> lastRow = new ArrayList<>();
         for (int i = 0; i <= range; i++) {
             if (dp[n][i]) {
                 lastRow.add(i); // Collect all achievable subset sums
             }
         }
 
         // Calculate the minimum difference between two subsets
         int min = Integer.MAX_VALUE;
         for (int i = 0; i <= lastRow.size() / 2; i++) {
             // The difference between two subsets is given by |totalSum - 2 * subsetSum|
             min = Math.abs(Math.min(min, range - 2 * lastRow.get(i)));
             System.out.println(min); // Print intermediate minimum values for debugging
         }
 
         return min; // Return the minimum difference
     }
 }
 