/*
Problem Statement:
Given two strings s1 and s2, determine if s2 is a scrambled version of s1. A scrambled string is one that can be obtained by recursively splitting s1 into two non-empty substrings and swapping them. 

Example:
s1 = "great", s2 = "rgeat" is a scrambled string.
s1 = "abcde", s2 = "caebd" is not a scrambled string.
*/

public class ScrambledString {
    public static void main(String[] args) {
        String s1 = "adityba", s2 = "adityav";
        
        // Check if the lengths of the two strings are different
        if (s1.length() != s2.length()) {
            System.out.println("not scrambled");
        } else {
            System.out.println(isScrambled(s1, s2));
        }
    }

    static boolean isScrambled(String s1, String s2) {
        // Base cases: if both strings are empty or they are equal
        if (s1.isEmpty() && s2.isEmpty()) return true;
        if (s1.equals(s2)) return true;

        // If the length of either string is less than or equal to 1 and they are not equal
        if (s1.length() <= 1) return false;

        int n = s1.length();
        boolean flag = false;
        
        // Loop to check for scrambled string possibilities
        for (int i = 1; i < n; i++) {
            // Check if swapping the first half of s1 with the second half of s2 
            // and vice versa forms a scrambled string
            if (
                    (isScrambled(s1.substring(0, i), s2.substring(n - i, n)) 
                 && isScrambled(s1.substring(i, n), s2.substring(0, n - i)))
                ||  (isScrambled(s1.substring(0, i), s2.substring(0, i))
                 && isScrambled(s1.substring(i, n), s2.substring(i, n)))) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
