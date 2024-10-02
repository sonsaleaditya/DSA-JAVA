/*
Problem Statement:
Given two strings s1 and s2, find the shortest supersequence such that both s1 and s2 are subsequences of it.
The shortest supersequence is defined as the smallest string that contains both s1 and s2 as subsequences.

Input:
s1 = "abcd"
s2 = "acd"

Output:
shortest supersequence is : "abcd"

Explanation:
The string "abcd" is the shortest supersequence that contains both "abcd" and "acd" as subsequences.
*/

class ShortestSuperSequence {
    public static void main(String[] args) {
        String s1 = "aditya", s2 = "adiyta";
        System.out.println("shortest supersequece is : " + scs(s1, s2));
    }

    // Method to find the shortest common supersequence of s1 and s2
    static String scs(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        // dp[i][j] will store the length of the longest common subsequence of s1[0..i-1] and s2[0..j-1]
        int dp[][] = new int[m+1][n+1];

        // Fill dp array using bottom-up approach
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Reconstruct the shortest supersequence from dp array
        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                sb.append(s1.charAt(i-1));
                i--;
            } else {
                sb.append(s2.charAt(j-1));
                j--;
            }
        }

        // Append remaining characters of s1 and s2
        while (i > 0) {
            sb.append(s1.charAt(i-1));
            i--;
        }
        while (j > 0) {
            sb.append(s2.charAt(j-1));
            j--;
        }

        // Reverse the string as we were adding characters from the end
        return sb.reverse().toString();
    }
}
