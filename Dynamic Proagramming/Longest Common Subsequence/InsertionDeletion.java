/**
 * Problem Statement:
 * 
 * Given two strings, compute the number of deletions and insertions required
 * to convert one string into the other. This is based on the Longest Common
 * Subsequence (LCS) of the two strings.
 * 
 * For example, to convert "heap" to "pea":
 * lcs of strings is :  "ea"
 * - Deletions: "h" and "p" (from "heap")
 * - Insertions: "p" (to form "pea" from "heap")
 * 
 * Logic:
 * if we remove "ea" from "heap" we get "hp" i.e deletion 
 * if remove "ea" from "pea" we get "p" i.e insertion
 * Input:
 * - Two strings s1 and s2.
 * 
 * Output:
 * - The number of deletions and insertions required to convert s1 into s2.
 * 
 * Example:
 * Input:
 *   s1 = "heap"
 *   s2 = "pea"
 * Output:
 *   Deletions: 2
 *   Insertions: 1
 */

 public class InsertionDeletion {
    public static void main(String[] args) {
        // Test strings
        String s1 = "heap";
        String s2 = "pea";

        // Create an instance of the class
        InsertionDeletion obj = new InsertionDeletion();

        // Calculate the length of the longest common subsequence
        int common = obj.lcs(s1, s2);

        // Calculate deletions and insertions
        int deletion = s1.length() - common;
        int insertion = s2.length() - common;

        // Print the results
        System.out.println("Deletions to convert from " + s1 + " to " + s2 + ": " + deletion);
        System.out.println("Insertions to convert from " + s1 + " to " + s2 + ": " + insertion);
    }

    /**
     * Finds the length of the longest common subsequence (LCS) between two strings.
     *
     * @param s1 The first string
     * @param s2 The second string
     * @return The length of the longest common subsequence of s1 and s2
     */
    int lcs(String s1, String s2) {
        int m = s1.length(); // Length of the first string
        int n = s2.length(); // Length of the second string

        // Create a 2D array to store lengths of longest common subsequences
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

        // The length of the longest common subsequence is in dp[m][n]
        return dp[m][n];
    }
}
