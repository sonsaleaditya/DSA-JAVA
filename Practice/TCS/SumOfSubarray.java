import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
 * Given an array of integers and a target sum, find all the subarrays whose sum equals the target.
 * 
 * Example:
 * Input: arr = {3, 4, -7, 1, 3, 3, 1, -4}, target = 7
 * Output:
 * [ 3, 4 ]
 * [ 3, 4, -7, 1, 3, 3 ]
 * [ 1, 3, 3 ]
 * 
 * Explanation:
 * The subarrays that sum up to 7 are printed.
 */

public class SumOfSubarray {
    public static void main(String[] args) {
        // Sample input array
        int arr[] = { 3, 4, -7, 1, 3, 3, 1, -4 };
        int target = 7;  // The target sum

        // Creating an object of SumOfSubarray and solving the problem
        SumOfSubarray obj = new SumOfSubarray();
        obj.solve(arr, target);
    }

    /**
     * Solves the problem of finding all subarrays whose sum equals the target.
     * 
     * @param arr    The input array
     * @param target The target sum to find
     */
    void solve(int arr[], int target) {
        // HashMap to store cumulative sums and their corresponding indices as a string
        Map<Integer, String> map = new HashMap<>();
        int sum = 0;

        // Initialize map with sum 0 at index -1 to handle subarrays starting from index 0
        map.put(0, ";-1");

        // Iterate through the array and keep track of cumulative sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // Add current element to cumulative sum

            // Calculate the required sum that would complete the target
            int rsum = sum - target;

            // Check if there's a cumulative sum earlier that equals (current sum - target)
            if (map.containsKey(rsum)) {
                // Get all previous indices that sum up to rsum
                String str[] = map.get(rsum).split(";");
                // For each index where we can form a valid subarray
                for (String k : str) {
                    if (!k.isEmpty()) {  // Ensure the index is valid
                        int initialIndex = Integer.parseInt(k) + 1;  // Get the starting index of the subarray
                        printSubarr(arr, initialIndex, i);  // Print the subarray
                    }
                }
            }

            // Update the map with the current sum and the index
            map.put(sum, map.getOrDefault(sum, "") + ";" + i);
        }

        // Output the final state of the map for debugging purposes
        System.out.println(map);
    }

    /**
     * Prints a subarray from index 's' to 'e' inclusively.
     * 
     * @param arr The input array
     * @param s   The starting index of the subarray
     * @param e   The ending index of the subarray
     */
    void printSubarr(int arr[], int s, int e) {
        // Iterate through the subarray and print it
        for (int i = s; i <= e; i++) {
            if (i == s) System.out.print("[ ");  // Start the subarray with '['
            System.out.print(arr[i] + ", ");     // Print the element with a comma
            if (i == e) System.out.print(" ]");  // End the subarray with ']'
        }
        System.out.println();  // Print a newline after the subarray
    }
}
