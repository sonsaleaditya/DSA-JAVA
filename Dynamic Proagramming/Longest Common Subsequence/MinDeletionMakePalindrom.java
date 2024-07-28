/*
 * Problem Statement:
 * Given a string, find the minimum number of deletions required to make the string a palindrome.
 * 
 * Input:
 * A single string 's1'. For example: "agbcba"
 * 
 * Output:
 * An integer representing the minimum number of deletions required to make 's1' a palindrome. 
 * For example: 1 (since deleting 'g' from "agbcba" makes it "abcba", which is a palindrome)
 * 
 * Explanation:
 * To solve this problem, we use the concept of the Longest Common Subsequence (LCS). 
 * The idea is to find the LCS between the given string and its reverse. 
 * The minimum number of deletions required will be the length of the string 
 * minus the length of this LCS.
 */

 public class MinDeletionMakePalindrom {
    public static void main(String[] args) {
        String s1 = "agbcba";
        // Reverse the string s1 to get s2
        String s2 = "";
        for(int i = s1.length() - 1; i >= 0; i--) {
            s2 += s1.charAt(i);
        }

        // Calculate the minimum number of deletions
        int minDeletions = s1.length() - lcs(s1, s2);
        System.out.println("Minimum Deletion to make it palindrome are: " + minDeletions);
    }

    // Function to find the Longest Common Subsequence (LCS) between two strings
    static int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m + 1][n + 1];

        // Fill dp array using the concept of LCS
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n]; // Length of LCS
    }
}
