public class LongestRepeatingSubSequence {
    public static void main(String[] args) {
        String s = "agbcgdadcba";
        System.out.println(lcs(s,s));
    }

   static int lcs(String s1, String s2) {
        int m = s1.length(); // Length of the first string
        int n = s2.length(); // Length of the second string

        // Create a 2D array to store lengths of longest common subsequence.
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) && i!=j) {
                    // If characters match, extend the length of the current LCS
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum of excluding either character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = m, j = n;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
               // sb.append(s1.charAt(i-1));
                i--;
            } else {
               // sb.append(s2.charAt(j-1));
                j--;
            }
        }

       

        System.out.println(sb.reverse().toString());
        // The string is built backwards, so reverse it before returning
        return dp[m][n];
    }
}
