public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "elephant", s2 = "erepat";
        // Calling the lcs method to find the length of the longest common subsequence
        // and printing the result
        System.out.println(lcs(s1, s2, 0, 0));
    }

    /**
     * This method calculates the length of the longest common subsequence (LCS)
     * between two strings starting from given indices i1 and i2.
     *
     * @param s1 First string
     * @param s2 Second string
     * @param i1 Current index in the first string
     * @param i2 Current index in the second string
     * @return Length of the longest common subsequence
     */
    static int lcs(String s1, String s2, int i1, int i2) {
        // Base case: if either string has been fully traversed, return 0
        if (s1.length() == i1 || s2.length() == i2) {
            return 0;
        }
        int c1 = 0;
        // Check if characters at the current indices match
        if (s1.charAt(i1) == s2.charAt(i2)) {
            // If they match, move to the next indices in both strings
            c1 = 1 + lcs(s1, s2, i1 + 1, i2 + 1);
        }
        // Recursively find the LCS by either advancing in the first string or the second string
        int c2 = lcs(s1, s2, i1 + 1, i2);
        int c3 = lcs(s1, s2, i1, i2 + 1);
        // Return the maximum of the three possibilities
        return Math.max(c1, Math.max(c2, c3));
    }
}
