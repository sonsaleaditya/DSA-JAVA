/*
Problem Statement:
Given a string s, partition s such that every substring of the partition is a palindrome. Return the minimum cuts needed for a palindrome partitioning of s.

Input:
s = "ababbbabbababa"

Output:
Min cuts needed : 3

Explanation:
The optimal partition requires 3 cuts, resulting in substrings "a | babbbabbababa".
*/

public class PalindromPartition_Optimized {
    public static void main(String[] args) {
        String str = "ababbbabbababa";

        int dp[][] = new int[str.length()][str.length()]; // Initialize the DP array
        System.out.println("Min cuts needed : " + mcm(str, 0, str.length() - 1, dp));
    }

    static int mcm(String s, int i, int j, int dp[][]) {
        // Base case: If substring is already a palindrome or single character
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        // Return precomputed result to avoid recomputation
        if (dp[i][j] != 0) return dp[i][j];

        int min = Integer.MAX_VALUE;

        // Try every possible position to split the substring
        for (int k = i; k < j; k++) {
            int left, right;

            // Check if the result is already computed for the left partition
            if (dp[i][k] != 0) {
                left = dp[i][k];
            } else {
                left = mcm(s, i, k, dp);
                dp[i][k] = left;
            }

            // Check if the result is already computed for the right partition
            if (dp[k + 1][j] != 0) {
                right = dp[k + 1][j];
            } else {
                right = mcm(s, k + 1, j, dp);
                dp[k + 1][j] = right;
            }

            // Calculate the minimum cuts needed
            min = Math.min(min, left + right + 1);
        }

        dp[i][j] = min; // Memoize the result
        return min;
    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
