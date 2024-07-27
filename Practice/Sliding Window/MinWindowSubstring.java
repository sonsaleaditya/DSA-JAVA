/*
 * given two strings str and pattern, we need return min length string such that
 * pattern should be present in string can contious or discontinious 
 * we need to return min length and frequency should be sam of char
 */

 import java.util.HashMap;

 public class MinWindowSubstring {
     public static void main(String[] args) {
         String str = "atoaccattaodcaogjt";
         String pat = "toc";
         System.out.println("min window is : " + minWindow(str, pat));
     }
 
     // Function to find the minimum window substring in 'str' that contains all characters of 'pat'
     static String minWindow(String str, String pat) {
         int s = 0, e = 0, minLen = Integer.MAX_VALUE, start = 0;
         int n = str.length();
         HashMap<Character, Integer> origionalMap = new HashMap<>();
 
         // Create a frequency map for the pattern
         for (char c : pat.toCharArray()) {
             origionalMap.put(c, origionalMap.getOrDefault(c, 0) + 1);
         }
 
         int count = origionalMap.size(); // Number of unique characters to be matched
 
         // Loop through the string with the end pointer 'e'
         while (e < n) {
             char endChar = str.charAt(e);
 
             // If endChar is in the pattern, decrease its frequency in the map
             if (origionalMap.containsKey(endChar)) {
                 origionalMap.put(endChar, origionalMap.get(endChar) - 1);
                 // If the character frequency becomes zero, one unique character is completely matched
                 if (origionalMap.get(endChar) == 0) {
                     count--;
                 }
             }
 
             // If all characters are matched
             while (count == 0) {
                 // Update the minimum length and starting point of the window
                 if (e - s + 1 < minLen) {
                     minLen = e - s + 1;
                     start = s;
                 }
 
                 char startChar = str.charAt(s);
 
                 // If startChar is in the pattern, increase its frequency in the map
                 if (origionalMap.containsKey(startChar)) {
                     origionalMap.put(startChar, origionalMap.get(startChar) + 1);
                     // If the character frequency becomes positive, one unique character is unmatched
                     if (origionalMap.get(startChar) > 0) {
                         count++;
                     }
                 }
 
                 s++; // Move the start pointer forward to find the new minimum window
             }
 
             e++; // Move the end pointer forward to include new characters in the window
         }
 
         // Return the minimum length substring if found, else return an empty string
         return minLen == Integer.MAX_VALUE ? "" : str.substring(start, start + minLen);
     }
 }
 