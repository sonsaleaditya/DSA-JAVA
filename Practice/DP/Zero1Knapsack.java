public class Zero1Knapsack {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int capacity = 5; // Define the capacity of the knapsack
        int weights[] = {1, 2, 3, 4}; // Define the weights of the items
        int[] profits = {10, 15, 40, 50}; // Define the profits of the items
        int n = weights.length;
        int dp[][] = new int[capacity + 1][n + 1];
        
        // Initialize dp array with -1 indicating uncomputed states
        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int maxProfit = obj.knapSack(capacity, weights, profits, n, dp);
        System.out.println("Max Profit is " + maxProfit);

        // Print the dp array
        obj.printDpArray(dp, capacity, n);
    }
}

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n, int dp[][]) {
        return k(W, wt, val, n, dp);
    }

    static int k(int w, int wt[], int val[], int n, int dp[][]) {
        if (w == 0 || n == 0) return 0;

        if (dp[w][n] != -1) {
            return dp[w][n];
        }

        if (wt[n - 1] <= w) {
            dp[w][n] = Math.max(
                val[n - 1] + k(w - wt[n - 1], wt, val, n - 1, dp), // Include the nth item
                k(w, wt, val, n - 1, dp) // Exclude the nth item
            );
        } else {
            dp[w][n] = k(w, wt, val, n - 1, dp);
        }

        return dp[w][n];
    }

    static void printDpArray(int[][] dp, int w, int n) {
        System.out.println("DP Array:");
        System.out.print("     ");
        for (int j = 0; j <= n; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();
        for (int i = 0; i <= w; i++) {
            System.out.printf("%4d ", i);
            for (int j = 0; j <= n; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }
    }
}
