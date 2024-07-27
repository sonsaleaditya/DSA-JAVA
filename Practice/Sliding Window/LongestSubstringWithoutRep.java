import java.util.HashMap;

public class LongestSubstringWithoutRep {
    public static void main(String[] args) {
        String str = "pwwkewmnopqrs";
        System.out.println("The Longest SubString is : " + findLongSubString(str));
    }

    static int findLongSubString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = str.length(), max = 0, s = 0, e = 0;

        while (e < n) {
            map.put(str.charAt(e), map.getOrDefault(str.charAt(e), 0) + 1);

            

          while(e-s+1 > map.size() && s<=e) {
                map.put(str.charAt(s),map.getOrDefault(str.charAt(s),0)-1);
                if(map.get(str.charAt(s))==0){
                    map.remove(str.charAt(s));
                }
                s++;
            }

            if (map.size() == e-s+1) {
                max = Math.max(max, map.size());
            }
            e++;
        }

        return max;
    }
}
