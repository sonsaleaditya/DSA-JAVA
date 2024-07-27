import java.util.HashMap;

public class MaxCountOfkthUniqueChar {
    public static void main(String[] args) {
        char arr[] = { 'a', 'b', 'c', 'a', 'b', 'c', 'e', 'd', 'f', 'd', 'a','f', 'f','f','f','f','f','f','f','a'};
        int k = 3;
        System.out.println("Max count: " + findMax(arr, k));
    }

    static int findMax(char arr[], int k) {
        int s = 0, e = 0, max = 0, n = arr.length;
        HashMap<Character, Integer> countMap = new HashMap<>();

        while (e < n) {
           countMap.put(arr[e], countMap.getOrDefault(arr[e],0)+1);
           while(countMap.size()>k){
            countMap.put(arr[s], countMap.getOrDefault(arr[s], 0)-1);
            if(countMap.get(arr[s])==0){
                countMap.remove(arr[s]);
            }
            s++;
           }
            // Update max count if the current window has exactly k unique characters
            if (countMap.size() == k) {
                max = Math.max(calculateMax(countMap), max);
            }

            e++;
        }

        return max;
    }

    static int calculateMax(HashMap<Character, Integer> countMap) {
        int count = 0;
        for (int value : countMap.values()) {
            count += value;
        }
        return count;
    }
}
