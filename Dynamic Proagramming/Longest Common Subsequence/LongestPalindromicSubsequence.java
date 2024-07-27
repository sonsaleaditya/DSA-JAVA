/**
 * Problem Statement:
 * Given a string, find the longest palindromic subsequence in it. A subsequence of a string is a new string 
 * generated from the original string with some characters(can be none) deleted without changing the 
 * relative order of the remaining characters.
 * A palindromic subsequence is a subsequence that reads the same backward as forward.
 * 
 * For example:
 * Input: "agbcba"
 * Output: "agbcba" (which is a palindrome and is the longest palindromic subsequence in this case)
 */

 public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "agbcba";

        // Reverse the input string
        String revered = "";
        for(int i = s.length() - 1; i >= 0; i--){
            revered += s.charAt(i);
        }

        // Create an instance of LongestPalindromicSubsequence
        LongestPalindromicSubsequence spc = new LongestPalindromicSubsequence();

        // Compute the longest palindromic subsequence
        System.out.println("Longest Palindromic Subsequence is: " + spc.longestPalindrome(s, revered));
    }

    /**
     * Function to find the longest palindromic subsequence using dynamic programming.
     * 
     * @param s1 First string (original string)
     * @param s2 Second string (reversed version of the original string)
     * @return The longest palindromic subsequence
     */
    String longestPalindrome(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        // Create a 2D DP array to store lengths of longest common subsequences
        int dp[][] = new int[m + 1][n + 1];

        // Fill the DP table
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // If characters match, add 1 to the length of the longest subsequence found so far
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Otherwise, take the maximum of excluding either character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the longest palindromic subsequence from the DP table
        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                // If characters match, add this character to the result and move diagonally
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]){
                // Move in the direction of the maximum value
                i--;
            } else {
                j--;
            }
        }

        // Reverse the result string to get the correct order
        sb.reverse();
        return sb.toString();
    }
}
