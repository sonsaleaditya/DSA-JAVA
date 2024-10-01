import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraysWIthTargetSum {
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
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }

        return count;

    }

    // Helper method to convert the subarray into a string for printing
    static String subArrayToString(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]);
            if (i != end)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

/*
 * Let's break down the solution step by step and understand the approach used
 * to find and print subarrays with a target sum.
 * 
 * Problem Recap:
 * You have an array of integers, which may include both positive and negative
 * numbers. The task is to find all subarrays whose sum equals a given target
 * sum. Additionally, you want to print those subarrays.
 * 
 * Which Approach Works Best?
 * In this case, sliding window and two-pointer techniques don’t work well
 * because:
 * 
 * Sliding window works efficiently only when the array has positive numbers,
 * and negative numbers can break the logic since they reduce the sum
 * unpredictably.
 * Two-pointer technique is used mostly for problems with sorted arrays and
 * specific target conditions, but it doesn’t fit well with this problem as it's
 * not ordered.
 * The most efficient approach here is prefix sum with a hashmap, which is
 * somewhat related to the dynamic programming (DP) pattern because you use past
 * results (prefix sums) to make decisions about future steps.
 * 
 * The Prefix Sum Approach (DP-Like):
 * The core idea of this approach is to use a running sum (called prefix sum)
 * while traversing the array. Here's how it works:
 * 
 * Prefix Sum:
 * 
 * As you move through the array, you keep track of the cumulative sum of
 * elements from the start up to the current position. This is called the prefix
 * sum.
 * Key Insight:
 * 
 * Let's say you have the current prefix sum S at index i. To find a subarray
 * with sum equal to target, you need to check if there was any previous prefix
 * sum equal to S - target. Why? Because if you had seen a sum of S - target at
 * some earlier index j, then the subarray between j+1 and i has a sum equal to
 * target.
 * HashMap for Storing Prefix Sums:
 * 
 * The hashmap stores the prefix sum as the key and the index where that prefix
 * sum occurred as the value. This allows us to instantly check if a specific
 * prefix sum exists, which makes the approach efficient.
 * Counting and Printing Subarrays:
 * 
 * Every time you find a matching prefix sum, you know that the subarray
 * starting from the index after that sum up to the current index gives the
 * desired sum. You can then print it.
 * Example Walkthrough:
 * Let’s say the array is:
 * 
 * css
 * Copy code
 * arr[] = {3, 4, -7, 1, 3, 3, 1, -4}
 * target = 7
 * We traverse through the array while keeping track of the cumulative sum:
 * 
 * Start with sum = 0, and store sum = 0 at index -1 (before the start of the
 * array).
 * For each element, add it to sum and check if sum - target exists in the
 * hashmap.
 * If it exists, it means that the subarray from that earlier index to the
 * current index sums to the target.
 * Steps for the Example:
 * Start with sum = 0. Initialize the hashmap with {0: [-1]} (this handles
 * subarrays that start from index 0).
 * Traverse through the array:
 * Add 3 → sum = 3. Check if 3 - 7 = -4 exists in the hashmap (it doesn't). Add
 * 3 to the map.
 * Add 4 → sum = 7. Check if 7 - 7 = 0 exists in the hashmap (it does at index
 * -1), so subarray [0,1] (3,4) is valid.
 * Add -7 → sum = 0. Check if 0 - 7 = -7 exists (it doesn't). Add 0 to the map.
 * Add 1 → sum = 1. Check if 1 - 7 = -6 exists (it doesn't). Add 1 to the map.
 * Add 3 → sum = 4. Check if 4 - 7 = -3 exists (it doesn't). Add 4 to the map.
 * Add 3 → sum = 7. Check if 7 - 7 = 0 exists (it does at two previous indices,
 * so subarrays are [0, 5] and [2, 5]).
 * Continue similarly until the end.
 * Why Does This Work?
 * The prefix sum approach ensures that you're always checking if there's a
 * previous sum that can form the desired subarray. Since hashmap lookups are
 * fast, this method is efficient, and it handles negative numbers correctly
 * because it doesn't rely on fixed window sizes like sliding window techniques
 * do.
 * 
 * Final Answer:
 * Approach used: Prefix sum with a hashmap (Dynamic programming-like approach).
 * This approach is best suited because it works efficiently for arrays with
 * negative numbers and doesn't require sorting.
 * Time Complexity:
 * O(n), where n is the length of the array, because we traverse the array once
 * and each operation (sum calculation, hashmap lookup, update) takes constant
 * time.
 * I hope this explanation clarifies the logic behind the prefix sum approach!
 */