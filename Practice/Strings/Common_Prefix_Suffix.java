/*
Problem Statement:
Given a string, the task is to find the length of the longest prefix which is also a suffix.
The prefix and suffix should not overlap.

Example:
Input: "abab"
Output: 2

Explanation:
The string "abab" has a prefix "ab" and a suffix "ab" which are equal and non-overlapping. 
The length of this prefix/suffix is 2.

Input/Output:

Input:
"abab"

Output:
2
*/

public class Common_Prefix_Suffix {
    public static void main(String[] args) {
        String s = "abab"; // Test case: input string
        System.out.println(ps(s)); // Prints the result of the ps function
    }

    static int ps(String str){
        int count = 0; // Keeps track of the length of matching prefix and suffix
        int p = 0; // Pointer for the prefix part of the string
        int s = 1; // Pointer for the suffix part of the string
        int n = str.length(); // Total length of the string
        int positionMemory = 0; // Memory for the next starting point of the suffix pointer
        
        // Continue until either the prefix or suffix pointer reaches the end of the string
        while (p < n - 1 && s < n) {
            if (str.charAt(p) == str.charAt(s)) { // If prefix and suffix characters match
                count++; // Increase the count of matching characters
                p++; // Move prefix pointer forward
                s++; // Move suffix pointer forward
            } else {
                count = 0; // Reset count if characters don't match
                positionMemory++; // Move suffix starting position forward
                p = 0; // Reset prefix pointer to the start
                s = positionMemory; // Move suffix pointer to the new starting position
            }
        }
        return count; // Return the length of the longest prefix that is also a suffix
    }
}
