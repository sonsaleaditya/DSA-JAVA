public class RodCut {
    public static void main(String[] args) {
        int n = 8;
        int profit[] = { 3, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println("max profit is " + maxProfit(n, profit));
    }

    static int maxProfit(int n, int p[]) {
        // Create an array to store rod lengths from 1 to n
        int lArr[] = new int[n];
        for (int i = 1; i <= n; i++) lArr[i - 1] = i;

        // Create a 2D dp array to store the maximum profit for each length and piece size
        int dp[][] = new int[n + 1][n + 1];

        // Fill the dp array using the given profit array and rod lengths
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current length of rod piece can fit into the rod of length j
                if (lArr[i - 1] <= j) {
                    // Calculate the maximum profit by either taking the current piece or not
                    dp[i][j] = Math.max(p[i - 1] + dp[i][j - lArr[i - 1]], dp[i - 1][j]);
                } else {
                    // If the current piece cannot fit, take the profit without the current piece
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // Return the maximum profit for a rod of length n
        return dp[n][n];
    }
}
