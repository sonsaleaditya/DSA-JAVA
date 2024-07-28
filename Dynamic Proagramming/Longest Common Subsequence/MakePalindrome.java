/**
 * Problem Statement:
 * Given a string, find the minimum number of insertions required to make the string a palindrome.
 * 
 * A palindrome is a string that reads the same forward and backward, e.g., "radar" or "level".
 * 
 * Example:
 * Input: "dmtjtvqyiedezraoqkfu"
 * Output: 19
 * 
 * Explanation: The minimum number of insertions required to make the input string a palindrome is 19.
 * 
 * Approach:
 * 1. Compute the longest common subsequence (LCS) between the original string and its reverse.
 * 2. The length of the LCS represents the maximum length of the palindrome that can be formed from the string without insertions.
 * 3. The minimum number of insertions required to make the string a palindrome is the length of the original string minus the length of the LCS.
 */

 public class MakePalindrome {
    public static void main(String[] args) {
        String str = "dmtjtvqyiedezraoqkfu"; // Example input string
        Solution obj = new Solution();
        // Output the minimum number of insertions required to make the string a palindrome
        System.out.println("Min operations to make it palindrome: " + obj.countMin(str));
    }
}

class Solution {
    /**
     * Calculate the minimum number of insertions required to make the string a palindrome.
     * 
     * @param str The input string.
     * @return The minimum number of insertions needed.
     */
    public int countMin(String str) {
        // Reverse the string
        String reversedStr = new StringBuilder(str).reverse().toString();
        // Calculate the minimum number of insertions using the LCS approach
        return minInsertionsToMakePalindrome(str, reversedStr);
    }

    /**
     * Calculate the minimum number of insertions required to make the string a palindrome.
     * This is done by finding the length of the longest common subsequence (LCS) between the
     * original string and its reverse.
     * 
     * @param s1 The original string.
     * @param s2 The reversed string.
     * @return The minimum number of insertions needed.
     */
    private int minInsertionsToMakePalindrome(String s1, String s2) {
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];

        // Build the DP table to find the length of LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Characters match, increase the length of LCS by 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Characters do not match, take the maximum value from previous computations
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Length of the longest common subsequence
        int lcsLength = dp[n][n];
        // Minimum number of insertions required
        return n - lcsLength;
    }
}
