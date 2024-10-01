import java.util.HashMap;
import java.util.Map;

public class CountOfSumOfSubArrayWithTargetSum {
    public static void main(String[] args) {
        int arr[] = { 3, 4, -7, 1, 3, 3, 1, -4 };
        int target = 7;
        System.out.println(findSubarray(arr, target));
    
    }

    // Method to find and print subarrays with the given target sum
    static int findSubarray(int arr[], int target) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remainingSum = sum - target;
            if (map.containsKey(remainingSum)) {
                count+=map.get(remainingSum);
            }else{
                map.put(sum,  map.getOrDefault(sum, 0)+1);
            }
        }

        System.out.println(map);

        return count;

    }
}