import java.util.HashMap;
import java.util.Map;

/**
 * InnerLongestSubstringWithoutRepetition
 */
public class InnerLongestSubstringWithoutRepetition {
    public static void main(String[] args) {
        String s = "lvodevelerhytuiop";
        System.out.println(ls(s));
    }

    static int ls(String s) {
        int ans = 0;
        Map<Character, Integer> mp = new HashMap<>();

        int start = 0, end = 0, n = s.length();
        while (end < n) {
            char ch = s.charAt(end);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            // calculate index and map size

            if (mp.size() == (end - start + 1)) {
                ans = Math.max(end - start + 1, ans);
               

            } else {
                // occur duplicates // remove and start new count
                while (end - start + 1 != mp.size() && start <= end) {

                    ch = s.charAt(start);
                    if (mp.get(ch) > 1) {
                        mp.put(ch, mp.get(ch) - 1);
                    } else {
                        mp.remove(ch);
                    }
                    start++;

                }

            }
            end++;
        }

        return ans;
    }

}