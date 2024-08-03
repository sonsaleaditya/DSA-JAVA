/**
 * Problem Statement:
 * Given an array of integers and a number 'k', find the count of distinct elements in every window of size 'k' in the array.
 * 
 * Example:
 * Input: A = [1, 2, 1, 3, 4, 2, 3], n = 7, k = 4
 * Output: [3, 4, 4, 3]
 * 
 * Explanation:
 * The first window is [1, 2, 1, 3] - Distinct elements are {1, 2, 3} - Count is 3
 * The second window is [2, 1, 3, 4] - Distinct elements are {1, 2, 3, 4} - Count is 4
 * The third window is [1, 3, 4, 2] - Distinct elements are {1, 2, 3, 4} - Count is 4
 * The fourth window is [3, 4, 2, 3] - Distinct elements are {2, 3, 4} - Count is 3
 */

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Map;
 
 public class DistinctElementInEveryWindow {
     public static void main(String[] args) {
         int[] A = {1, 2, 1, 3, 4, 2, 3};
         int n = A.length;
         int k = 4;
 
         Solution solution = new Solution();
         ArrayList<Integer> result = solution.countDistinct(A, n, k);
 
         System.out.println(result);  // Output: [3, 4, 4, 3]
     }
 }
 
 class Solution {
     /**
      * Finds the count of distinct elements in every window of size 'k' in the array.
      * 
      * @param A The input array
      * @param n The length of the array
      * @param k The size of the window
      * @return An ArrayList containing the count of distinct elements for each window
      */
     ArrayList<Integer> countDistinct(int A[], int n, int k) {
         ArrayList<Integer> arr = new ArrayList<>();
         Map<Integer, Integer> countMap = new HashMap<>();
         
         int s = 0, e = 0;
         
         // Iterate through the array
         while (e < n) {
             // Add the current element to the map or increment its count
             countMap.put(A[e], countMap.getOrDefault(A[e], 0) + 1);
             
             // When the window size is reached
             if (e - s + 1 == k) {
                 // Add the number of distinct elements to the result list
                 arr.add(countMap.size());
                 
                 // Remove the start element of the window from the map or decrement its count
                 countMap.put(A[s], countMap.getOrDefault(A[s], 0) - 1);
                 if (countMap.get(A[s]) == 0) {
                     countMap.remove(A[s]);
                 }
                 
                 // Slide the window
                 s++;
             }
             e++;
         }
         
         return arr;
     }
 }
 