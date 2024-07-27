import java.util.HashMap;

public class CountOfAnagrams {
    public static void main(String[] args) {
        CountOfAnagrams obj = new CountOfAnagrams();
        String str = "cbaebabacd";
        String pattern = "abc";
        int result = obj.countAnagrams(str, pattern);
        System.out.println("Count of anagrams: " + result);
    }

    int countAnagrams(String str, String pattern) {
        int k = pattern.length(); // Length of the pattern
        int count = 0;
        int s = 0, e = 0;

        // Frequency map for the pattern
        HashMap<Character, Integer> patternMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        // Copy of the pattern map to reset when needed
        HashMap<Character, Integer> originalPatternMap = new HashMap<>(patternMap);

        // Iterate over the string with a sliding window
        while (e < str.length()) {
            char endChar = str.charAt(e);

            // If the character is part of the pattern, decrement its count in the pattern map
            if (patternMap.containsKey(endChar)) {
                patternMap.put(endChar, patternMap.get(endChar) - 1);
                if (patternMap.get(endChar) == 0) {
                    patternMap.remove(endChar);
                }
            }

            // If the window size matches the pattern length
            if (e - s + 1 == k) {
                // If the pattern map is empty, it means the current window is an anagram
                if (patternMap.isEmpty()) {
                    count++;
                    patternMap = originalPatternMap;
                }
                s++; // Slide the window forward
            }
            e++; // Expand the window
        }

        return count;
    }
}
