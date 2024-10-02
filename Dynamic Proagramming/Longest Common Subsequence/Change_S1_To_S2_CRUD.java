/*
Problem Statement:
Given two strings s1 and s2, find the minimum number of operations required to convert s1 into s2. The allowed operations are:
1. Insert a character
2. Delete a character
3. Replace a character

Input:
s1 = "abdgba"
s2 = "abcgdba"

Output:
Min operations : 1

Explanation:
To convert "abdgba" to "abcgdba", you need 1 operation:
- Replace the character 'd' at position 3 in s1 with 'c' to get "abcgdba".
*/

public class Change_S1_To_S2_CRUD {
    public static void main(String[] args) {
        String s1 = "heap", s2 = "pea";
        Solution obj = new Solution();

        System.out.println("Min operations : " + obj.editDistance(s1, s2));
    }
}

class Solution {
    public int editDistance(String str1, String str2) {
        return lcs(str1, str2);
    }

    static int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        // Create a DP array to store results of subproblems
        int dp[][] = new int[m + 1][n + 1];

        // Fill dp array with the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Minimum operations to convert s1[0..i] to empty string
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i; // Minimum operations to convert empty string to s2[0..i]
        }

        // Fill the dp array in bottom-up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, no new operation needed
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    // Min operations of Insert, Delete, Replace + 1 new operation
                }
            }
        }

        // Print the DP matrix
        printDPMatrix(dp, m, n);

        // dp[m][n] contains the minimum number of operations required to convert s1 to s2
        return dp[m][n];
    }

    static void printDPMatrix(int[][] dp, int m, int n) {
        System.out.println("DP Matrix:");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
