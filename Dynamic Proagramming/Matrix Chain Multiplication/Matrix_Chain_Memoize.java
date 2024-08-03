/*
Problem Statement:
Given an array `arr` where `arr[i]` represents the dimension of the ith matrix such that the ith matrix has dimension `arr[i-1] x arr[i]`, find the minimum number of scalar multiplications needed to multiply the chain of matrices.

Input:
arr = {20, 35, 46, 22}

Output:
Min operations : 33620

Explanation:
The optimal way to multiply the given chain of matrices requires 33620 scalar multiplications.
*/

public class Matrix_Chain_Memoize {
    public static void main(String[] args) {
        int arr[] = {20, 35, 46, 22};
        int n = arr.length;
        int dp[][] = new int[n][n]; // DP array to store minimum multiplication costs
        System.out.println("Min operations : " + solve(arr, 1, n - 1, dp));
    }

    static int solve(int arr[], int i, int j, int dp[][]) {
        // Base case: No cost if the chain length is 1 (single matrix)
        if (i >= j) {
            return 0;
        }

        // Return already computed value for the subproblem
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        // Try every possible position to split the chain
        for (int k = i; k < j; k++) {
            // Recursive calls to calculate the minimum cost of the two subchains
            int temp = solve(arr, i, k, dp) + solve(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];

            // Update min cost
            min = Math.min(temp, min);
        }

        // Memoize the result
        dp[i][j] = min;
        return min;
    }
}
