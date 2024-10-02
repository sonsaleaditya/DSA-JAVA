/*
 * Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, 
 * find the number of ways you can make sum by using different combinations from coins[ ].  
 * Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.
 *
 * Example 1:
 * Input:
 * N = 3, sum = 4
 * coins = {1,2,3}
 * Output: 4
 * Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * 
 * Example 2:
 * Input:
 * N = 4, Sum = 10
 * coins = {2,5,3,6}
 * Output: 5
 * Explanation: Five Possible ways are: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 */

 public class coinChangeProblem {
    public static void main(String[] args) {
        // Define the array of coins and the target sum
        int[] coins = {1, 2, 3};
        int n = coins.length;
        int sum = 4;

        // Call the possibleWays method and print the result
        System.out.println("There are " + possibleWays(coins, n, sum) + " ways to make change for the given sum.");
    }

    static int possibleWays(int[] arr, int n, int sum) {
        // Create a 2D dp array to store the count of ways to make each sum using up to n coins
        int dp[][] = new int[n + 1][sum + 1];

        // Initialize the first row to 0, as there are no ways to make a positive sum with 0 coins
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }

        // Initialize the first column to 1, as there is exactly one way to make sum 0 with any number of coins (by choosing no coins)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp array with the number of ways to achieve each sum using up to the ith coin
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                  // Include the current coin (dp[i][j - arr[i - 1]]) + exclude the current coin (dp[i - 1][j])
                    dp[i][j] = dp[i][j-  arr[i - 1]] + dp[i - 1][j];
                } else {
                    // Exclude the current coin
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Print the dp matrix for debugging purposes
        printDPMat(dp);

        // Return the count of ways to make the target sum
        return dp[n][sum];
    }

    // Method to print the dp matrix
    static void printDPMat(int arr[][]) {
        int r = arr.length;
        int c = arr[0].length;

        // Print the column headers
        System.out.print("  ");
        for (int i = 0; i < c; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        // Print the dp matrix
        for (int i = 0; i < r; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
