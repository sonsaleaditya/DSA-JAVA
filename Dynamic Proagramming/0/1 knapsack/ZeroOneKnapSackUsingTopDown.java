public class ZeroOneKnapSackUsingTopDown {
    public static void main(String[] args) {
        // Sample weights and values of items
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        
        // Maximum weight capacity of the knapsack
        int w = 7;
        
        // Number of items
        int n = wt.length;
        
        // Print the maximum value that can be achieved
        System.out.println("Maximum value in Knapsack = " + knapsack(w, wt, val, n));
    }

    /**
     * Function to solve the 0/1 Knapsack problem using a top-down dynamic programming approach.
     * @param w Maximum weight capacity of the knapsack.
     * @param wt Array of weights of the items.
     * @param val Array of values of the items.
     * @param n Number of items.
     * @return Maximum value that can be achieved with the given weight capacity.
     */
    static int knapsack(int w, int wt[], int val[], int n) {
        // Create a 2D array to store the maximum value that can be achieved with a given number of items and weight capacity
        int dp[][] = new int[n + 1][w + 1];

        // Iterate over all items
        for (int i = 1; i < n + 1; i++) {
            // Iterate over all possible weight capacities
            for (int j = 1; j < w + 1; j++) {
                // Check if the weight of the current item is less than or equal to the current capacity
                if (wt[i - 1] <= j) {
                    // Include the current item and take the maximum of including or not including the item
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    // Do not include the current item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the maximum value that can be achieved with the given number of items and weight capacity
        return dp[n][w];
    }
}
