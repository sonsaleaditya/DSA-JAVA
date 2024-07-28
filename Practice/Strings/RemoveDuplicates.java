public class RemoveDuplicates {
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Test strings
        String testString1 = "banana";
        String testString2 = "apple";
        String testString3 = "mississippi";
        
        // Print results
        System.out.println("Original: " + testString1 + " -> Without Duplicates: " + solution.removeDups(testString1));
        System.out.println("Original: " + testString2 + " -> Without Duplicates: " + solution.removeDups(testString2));
        System.out.println("Original: " + testString3 + " -> Without Duplicates: " + solution.removeDups(testString3));
    }
}

class Solution {
    // Method to remove duplicate characters from a given string
    String removeDups(String str) {
        // Create a StringBuilder to store the result without duplicates
        StringBuilder sb = new StringBuilder();
        
        // Iterate over each character in the input string
        for (int i = 0; i < str.length(); i++) {
            // Check if the character is not already in the StringBuilder
            if (!sb.toString().contains(str.charAt(i) + "")) {
                // If the character is not present, append it to the StringBuilder
                sb.append(str.charAt(i));
            }
        }
        
        // Convert the StringBuilder to a String and return the result
        return sb.toString();
    }
}
