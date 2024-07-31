/**
 * Problem Statement:
 * Given two strings s1 and s2, determine if s2 is a subsequence of s1.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily consecutively.
 * 
 * Example:
 * Input:
 * s1 = "adergxchtyz"
 * s2 = "axt"
 * 
 * Output:
 * "s2 is subsequence of s1"
 * 
 * Explanation:
 * The characters 'a', 'x', and 't' in s2 appear in the same order in s1, so s2 is a subsequence of s1.
 */

 public class SequenceMatchingPattern {
    public static void main(String[] args) {
        String s1 = "adergxchtyz";
        String s2 = "axt";

        // Check if s2 is a subsequence of s1
        if (lcs(s1, s2, s1.length(), s2.length())) {
            System.out.println("s2 is subsequence of s1");
        } else {
            System.out.println("s2 is not subsequence of s1");
        }
    }
    
    /**
     * Function to determine if s2 is a subsequence of s1 using dynamic programming.
     * 
     * @param s1 The main string
     * @param s2 The subsequence to check
     * @param m The length of s1
     * @param n The length of s2
     * @return true if s2 is a subsequence of s1, otherwise false
     */
    static boolean lcs(String s1, String s2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, increment the length of common subsequence
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum of the two possible subsequences
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // If the length of the longest common subsequence is equal to the length of s2, s2 is a subsequence of s1
        return dp[m][n] == n;
    }
}
