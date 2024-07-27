public class ZeroOneKnapSack {
    public static void main(String[] args) {
        // Example input: weights, profits, maximum weight capacity, number of items
        int[] wt = {1, 2, 3, 4};
        int[] profit = {10, 15, 40, 50};
        int w = 5;
        int n = wt.length;
        int dp[][] = new int[w+1][n+1];
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        // Calculate the maximum profit
        int maxProfit = knapSack(wt, profit, w, n, dp);
        
        // Print the maximum profit
        System.out.println("Maximum Profit: " + maxProfit);
        
        // Print the dp array
        printDpArray(dp, w, n);
    }

    static int knapSack(int[] wt, int[] profit, int w, int n, int[][] dp) {
        // Base case: if the weight capacity is 0 or there are no items left
        if (w == 0 || n == 0) {
            return 0;
        }

        // If value is already computed, return it
        if (dp[w][n] != -1) {
            return dp[w][n];
        }

        // If the weight of the nth item is less than or equal to the capacity
        // We have two choices: include the nth item or exclude it
        if (wt[n-1] <= w) {
            dp[w][n] = Math.max(
                profit[n-1] + knapSack(wt, profit, w - wt[n-1], n - 1, dp), // Include the nth item
                knapSack(wt, profit, w, n - 1, dp) // Exclude the nth item
            );
        } else {
            // If the weight of the nth item is greater than the capacity, exclude it
            dp[w][n] = knapSack(wt, profit, w, n - 1, dp);
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
