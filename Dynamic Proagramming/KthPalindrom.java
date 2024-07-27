import java.util.*;
public class KthPalindrom {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "abcdefcba";
        int n = 9;
        int k = 1;
        int result = sol.kPalindrome(str, n, k);
        System.out.println(result); // Expected output is 0
    }
}

class Solution {
    public int kPalindrome(String str, int n, int k) {
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        // Check if the string can be a palindrome with at most k changes
        if (helper(str, 0, n - 1, dp) <= k)
            return 1;
        else
            return 0;
    }

    public int helper(String str, int left, int right, int[][] dp) {
        if (left >= right) return 0; // Base case: already a palindrome or single character
        if (dp[left][right] != -1) return dp[left][right]; // Use memoized result if available

        if (str.charAt(left) == str.charAt(right)) {
            // Characters match, move inward
            return dp[left][right] = helper(str, left + 1, right - 1, dp);
        } else {
            // Characters do not match, need at least one change
            int changeLeft = helper(str, left + 1, right, dp);
            int changeRight = helper(str, left, right - 1, dp);
            return dp[left][right] = Math.min(changeLeft, changeRight) + 1;
        }
    }

   
}
