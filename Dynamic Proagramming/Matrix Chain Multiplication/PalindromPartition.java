/*
Problem Statement:
Given a string s, partition s such that every substring of the partition is a palindrome. Return the minimum cuts needed for a palindrome partitioning of s.

Input:
s = "adidt"

Output:
Min cuts needed : 2

Explanation:
The optimal partition is "a | did | t", which requires 2 cuts.
*/

public class PalindromPartition {
    public static void main(String[] args) {
        PalindromPartition p = new PalindromPartition();

        String s = "adidt";

        System.out.println("Min cuts needed : " + p.mcm(s, 0, s.length() - 1));
    }

    int mcm(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = mcm(s, i, k) + mcm(s, k + 1, j) + 1;
            min = Math.min(min, temp);
        }
        return min;
    }

    boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
