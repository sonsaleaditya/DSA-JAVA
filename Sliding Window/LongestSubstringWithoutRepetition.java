/*Given a string s, find the length of the longest 
substring
 without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashMap;

public class LongestSubstringWithoutRepetition {
    public static void main(String[] args) {
        String str = "eeydgwdykpv";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int eptr = 0, sptr = 0;
        int ans = 0;
        while(eptr < n){
            char ch = s.charAt(eptr);
            map.put(ch,map.getOrDefault(ch,0)+1);
            // if map size is equals eptr - sptr + 1 
            // increment eptr and calculate max
            if(map.size() ==  eptr - sptr +1){
                 ans = Math.max(ans, eptr - sptr + 1);
                 eptr++;
            }else{
                while(map.size() !=  eptr - sptr +1 && sptr <= eptr){
                    ch = s.charAt(sptr);
                    if(map.get(ch) > 1){
                        map.put(ch, map.get(ch)-1);
                    }else{
                        map.remove(ch);
                    }
                    sptr++;
                }
                // if(sptr <= eptr && map.size() == eptr -  sptr + 1){
                //     ans = Math.max(ans, eptr - sptr + 1);

                // }
                eptr++;

            }
            
        }
        return ans;
    }
    
}
