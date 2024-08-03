import java.util.ArrayList;

/**
 * Problem Statement:
 * Given an array of integers and a number 'K', find the maximum sum of a subarray of size 'K'.
 * 
 * Example:
 * Input: Arr = [100, 200, 300, 400], N = 4, K = 2
 * Output: 700
 * 
 * Explanation:
 * The subarrays of size 2 are [100, 200], [200, 300], [300, 400]. 
 * The sums of these subarrays are 300, 500, 700 respectively. 
 * The maximum sum is 700.
 */

public class Max_SumOf_K_Window {
    public static void main(String[] args) {
        ArrayList<Integer> Arr = new ArrayList<>();
        Arr.add(100);
        Arr.add(200);
        Arr.add(300);
        Arr.add(400);
        int N = Arr.size();
        int K = 2;

        Solution solution = new Solution();
        long result = solution.maximumSumSubarray(K, Arr, N);

        System.out.println(result);  // Output: 700
    }
}

class Solution {
    /**
     * Finds the maximum sum of any subarray of size 'K' in the given array.
     * 
     * @param K The size of the subarray
     * @param Arr The input array
     * @param N The length of the array
     * @return The maximum sum of any subarray of size 'K'
     */
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        int s = 0, e = 0;
        long max = Long.MIN_VALUE, sum = 0;
        
        // Iterate through the array
        while (e < N) {
            // Add the current element to the sum
            sum += (long) Arr.get(e);
            
            // When the window size is reached
            if (e - s + 1 == K) {
                // Update the maximum sum
                max = Math.max(max, sum);
                // Remove the start element of the window from the sum
                sum -= (long) Arr.get(s);
                // Slide the window
                s++;
            }
            e++;
        }
        
        return max;
    }
}
