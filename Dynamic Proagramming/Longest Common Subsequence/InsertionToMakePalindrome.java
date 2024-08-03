/**
 * Problem Statement:
 * Given a string, the task is to find the minimum number of insertions needed to make it a palindrome.
 * 
 * A palindrome is a string that reads the same backward as forward. For example, "madam" is a palindrome.
 * To solve this problem, we can use the concept of the Longest Common Subsequence (LCS). 
 * By finding the LCS of the string and its reverse, we can determine the longest palindromic subsequence.
 * The number of insertions required will be the difference between the length of the string and the length of the LCS.
 * 
 * Example:
 * Input: "fabebad"
 * Output: 2
 * Explanation: By inserting two characters ('a' at the beginning and 'f' at the end), 
 *              we can transform "fabebad" into "afabebafa", which is a palindrome.
 */

 public class InsertionToMakePalindrome {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("fabebad");
        // Find the LCS of the string and its reverse
        int lcs = lcs(sb.toString(), sb.reverse().toString());
        // Calculate the total number of insertions needed
        int totalInsertion = sb.length() - lcs;
        System.out.println("Number of insertions are: " + totalInsertion);
    }

    /**
     * Function to find the Longest Common Subsequence (LCS) of two strings
     * 
     * @param s1 The first string
     * @param s2 The second string (reverse of the first string)
     * @return The length of the LCS
     */
    static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m + 1][n + 1];

        // Build the LCS dynamic programming table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
