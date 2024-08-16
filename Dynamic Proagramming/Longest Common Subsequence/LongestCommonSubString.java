/**
 * Problem Statement:
 * 
 * Given two strings, find the longest common substring between them.
 * A substring is a contiguous sequence of characters within a string.
 * 
 * For example, the longest common substring of "agbcba" and "agbdeca" is "agb".
 * 
 * Input:
 * - Two strings s1 and s2.
 * 
 * Output:
 * - The longest common substring between s1 and s2.
 * 
 * Example:
 * Input:
 * s1 = "agbcba"
 * s2 = "agbdeca"
 * Output:
 * "agb"
 */

public class LongestCommonSubString {
    public static void main(String[] args) {
        // Test strings
        String s1 = "ABCDGH";

        String s2 = "ACDGHR";

        // Create an instance of the class
        LongestCommonSubString obj = new LongestCommonSubString();

        // Print the longest common substring
        System.out.println("Longest Common Substring is: " + obj.lcs(s1, s2));
        System.out.println(obj.longestCommonSubstr(s1, s2));
    }

    /**
     * Finds the longest common substring between two strings.
     *
     * @param s1 The first string
     * @param s2 The second string
     * @return The longest common substring of s1 and s2
     */
    int lcs(String s1, String s2) {
        int m = s1.length(); // Length of the first string
        int n = s2.length(); // Length of the second string

        // Create a 2D array to store lengths of longest common substring.
        int[][] dp = new int[m + 1][n + 1];

        int maxLength = 0; // To keep track of the maximum length of common substring
        int endIndex = 0; // To keep track of the ending index of the longest common substring in s1

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If characters match, extend the length of the current substring
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // Update maxLength and endIndex if a longer common substring is found
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    // If characters don't match, reset the current length to zero
                    dp[i][j] = 0;
                }
            }
        }

        // Extract the longest common substring from s1 using endIndex and maxLength
        return maxLength;
    }

    int longestCommonSubstr(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int dp[][] = new int[m + 1][n + 1];

        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }

                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }
}
