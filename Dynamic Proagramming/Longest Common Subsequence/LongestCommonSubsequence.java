/**
 * Problem Statement:
 * 
 * Given two strings, find the longest common subsequence (LCS) between them. 
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements 
 * without changing the order of the remaining elements.
 * 
 * For example, the longest common subsequence of "agbcba" and "agbdeca" is "agbca".
 * 
 * Input:
 * - Two strings s1 and s2.
 * 
 * Output:
 * - The longest common subsequence between s1 and s2.
 * 
 * Example:
 * Input:
 *   s1 = "agbcba"
 *   s2 = "agbdeca"
 * Output:
 *   "agbca"
 */

 public class LongestCommonSubsequence {

    public static void main(String[] args) {
        // Test strings
        String s1 = "agbcba";
        String s2 = "agbdeca";

        // Create an instance of the class
        LongestCommonSubsequence obj = new LongestCommonSubsequence();

        // Print the longest common subsequence
        System.out.println("Longest Common Subsequence is: " + obj.lcs(s1, s2));
    }

    /**
     * Finds the longest common subsequence (LCS) between two strings.
     *
     * @param s1 The first string
     * @param s2 The second string
     * @return The longest common subsequence of s1 and s2
     */
    String lcs(String s1, String s2) {
        int m = s1.length(); // Length of the first string
        int n = s2.length(); // Length of the second string

        // Create a 2D array to store lengths of longest common subsequence.
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If characters match, extend the length of the current LCS
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum of excluding either character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the longest common subsequence from the dp array
        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // If characters match, include this character in the result
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // Move up if the value above is greater
                i--;
            } else {
                // Move left if the value to the left is greater or equal
                j--;
            }
        }

        // The string is built backwards, so reverse it before returning
        return sb.reverse().toString();
    }
}
