/**
 * Problem Statement:
 * Given an array of integers and a target sum, find the count of subsets from the array that sum up to the target.
 * 
 * Input:
 * - An array of positive integers.
 * - A target sum.
 * 
 * Output:
 * - The count of subsets that sum up to the target.
 * 
 * Example:
 * Input: arr = {2, 3, 5, 6, 8, 10}, sum = 7
 * Output: 2
 * 
 * Explanation:
 * The subsets that sum to 7 are: {2, 5} and {7}.
 */

 public class CountOfSubset {
    public static void main(String[] args) {
        // Define the array and the target sum
        int arr[] = {2, 3, 5, 6, 8, 10};
      
        int sum = 7;

        // Call the countOfSubset method and print the result
        System.out.println("Count of Subsets is: " + countOfSubset(arr, sum));
    }

    /**
     * This method calculates the count of subsets in the array that sum up to the given target sum.
     * 
     * @param arr  The input array of integers
     * @param sum  The target sum
     * @return     The count of subsets that sum up to the target sum
     */
    static int countOfSubset(int arr[], int sum) {
        int n = arr.length;
        
        // Create a 2D dp array to store the count of subsets for each sum and array size
        // dp[i][j] will store the count of subsets of the first i elements with sum j
        int dp[][] = new int[n + 1][sum + 1];

        // Initialize the first row to 0: no subsets possible for positive sums with 0 elements
        for (int i = 1; i <= sum; i++) dp[0][i] = 0;

        // Initialize the first column to 1: only one subset (empty subset) is possible with sum 0 for any number of elements
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        // Fill the dp array using the subset-sum logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // If the current element arr[i-1] can be included in the subset
                    // The count will be the sum of:
                    // 1. Count of subsets including arr[i-1]: dp[i-1][j-arr[i-1]]
                    // 2. Count of subsets excluding arr[i-1]: dp[i-1][j]
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    // If the current element cannot be included, use the count excluding the element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Print the dynamic programming matrix for visualization (optional)
        printDPMat(dp);
        System.out.println("\n");

        // Return the count of subsets that sum up to the target
        return dp[n][sum];
    }

    /**
     * This method prints the 2D dp matrix for visualization.
     * 
     * @param arr  The 2D dp matrix
     */
    static void printDPMat(int arr[][]){
        int r = arr.length;
        int c = arr[0].length;
        // Print column headers
        System.out.print(" ");
        for (int i = 0; i < c; i++) System.out.print(" " + i);
        System.out.println();

        // Print each row of the matrix
        for (int i = 0; i < r; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
