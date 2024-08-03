/**
 * Problem Statement:
 * Given an array of strings, find the longest common prefix among all the
 * strings in the array.
 * If there is no common prefix, return "-1".
 * 
 * Example:
 * Input: ["flower", "flow", "flight"]
 * Output: "fl"
 * 
 * Input: ["dog", "racecar", "car"]
 * Output: "-1"
 */
public class LongestPrefix {
    public static void main(String[] args) {
        Solution obj = new Solution();

        // String[] arr = { "geeksforgeeks", "geeks", "geek", "geet" };
        String[] arr = { "ol", "xozic" };

        System.out.println(obj.longestCommonPrefix(arr));
    }
}

class Solution {
    /**
     * Finds the longest common prefix string amongst an array of strings.
     * 
     * @param arr An array of strings
     * @return The longest common prefix or "-1" if there is none
     */
    public String longestCommonPrefix(String arr[]) {
        // If the array has only one string, return that string
        if (arr.length == 1)
            return arr[0];

        // Find the shortest string in the array
        int min = Integer.MAX_VALUE;
        String minString = "";
        for (String k : arr) {
            if (min > k.length()) {
              
                minString = k;
            }
        }

        int i = 0;
        // Check each character of the shortest string against all other strings
        while (i < minString.length()) {
            char ch = minString.charAt(i);
            for (String str : arr) {
                // If the current character doesn't match, return the prefix up to this point
                if (ch != str.charAt(i)) {
                    return minString.substring(0, i).length() == 0 ? "-1" : minString.substring(0, i);
                }
            }
            i++;
        }

        // If the loop completes, the entire shortest string is the common prefix
        return minString;
    }
}
