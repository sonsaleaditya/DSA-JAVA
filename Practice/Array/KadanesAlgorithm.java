// Problem Statement:
// Given an integer array `arr`, find the contiguous subarray (containing at least one number) 
// which has the largest sum and return its sum. The subarray must consist of consecutive elements.

// Example 1:
// Input: arr = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

// Example 2:
// Input: arr = [1]
// Output: 1
// Explanation: The array contains only one element with sum = 1.

// Constraints:
// - 1 <= arr.length <= 10^6
// - -10^7 <= arr[i] <= 10^7

// Kadane's Algorithm is used to solve this problem in O(n) time complexity.

class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        // Calling Kadane's Algorithm to find the maximum subarray sum
        return kadanesAlgo(arr);  
    }
    
    // Function implementing Kadane's Algorithm
    int kadanesAlgo(int[] arr) {
        // Input: arr = [-2,1,-3,4,-1,2,1,-5,4]
        // Initialize the sum with the first element of the array
        int sum = arr[0];
        // Initialize maxEnding with the first element of the array
        int maxEnding = arr[0];
        
        // Traverse the array from the second element
        for(int k = 1; k < arr.length; k++) {
            // Update maxEnding to be either the current element or the sum of maxEnding and current element
            maxEnding = Math.max(maxEnding + arr[k], arr[k]);
            // Update sum if maxEnding is greater than the current sum
            if(maxEnding > sum) {
                sum = maxEnding;
            }
        }
        
        // Return the maximum sum
        return sum;
    }
}

class KadanesAlgorithm {
    // Test the solution with input arrays
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum for arr1: " + solution.maxSubarraySum(arr1)); // Output: 6
        
        // Example 2
        int[] arr2 = {1};
        System.out.println("Maximum subarray sum for arr2: " + solution.maxSubarraySum(arr2)); // Output: 1
    }
}
