import java.util.ArrayList;
import java.util.Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        // Define the size of the array N and the size of the subarray K
        int N = 4, K = 4;
        
        // Initialize the array with given values
        int[] Arr = {100, 200, 300, 400};
        
        // Convert the array into an ArrayList
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int k : Arr) {
            arrList.add(k);
        }
        
        // Create an instance of the Solution class
        Solution obj = new Solution();
        
        // Call the maximumSumSubarray method and store the result
        long result = obj.maximumSumSubarray(K, arrList, N);
        
        // Print the result
        System.out.println(result);
    }
}

class Solution {
    /**
     * This method finds the maximum sum of a subarray of size K.
     * 
     * @param K   Size of the subarray
     * @param Arr ArrayList of integers
     * @param N   Size of the array
     * @return    The maximum sum of the subarray of size K
     */
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        // Initialize the start pointer and current sum
        int start = 0;
        long currSum = 0, maxSum = Long.MIN_VALUE;
        
        // Traverse the array
        for (int end = 0; end < N; end++) {
            // Add the current element to the current sum
            currSum += Arr.get(end);
            
            // If the window size is less than K, continue expanding the window
            if (end - start + 1 < K) {
                continue;
            }
            // When the window size is exactly K
            else if (end - start + 1 == K) {
                // Update maxSum if the current sum is greater
                maxSum = Math.max(currSum, maxSum);
                
                // Subtract the element at the start pointer from the current sum
                currSum -= Arr.get(start);
                
                // Move the start pointer to the right to shrink the window
                start++;
            }
        }
        
        // Return the maximum sum found
        return maxSum;
    }
}
