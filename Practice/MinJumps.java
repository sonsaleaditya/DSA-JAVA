/**
 * MinJumps
 */
public class MinJumps {

    public static void main(String[] args) {
        Solution obj = new Solution();
        int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 }, n = 11;
        int k = obj.minJumps(arr, n);
        System.out.println("ans is " + k);
    }
}

class Solution {
    static int minJumps(int[] arr, int n) {
       
        
        // If the array has only one element, no jump is needed
        if (n == 1) {
            return 0;
        }
        
        // If the first element is 0, we cannot move anywhere
        if (arr[0] == 0) {
            return -1;
        }

         // Number of jumps needed to reach the end
         int jumps = 0;
        
         // Current maximum reach
         int maxReach = 0;
         
         // Current end of the range we can reach with the current number of jumps
         int currentEnd = 0;
        
        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Update the maximum reach
            maxReach = Math.max(maxReach, i + arr[i]);
            
            // If we have reached the end of the range for the current number of jumps
            System.out.println("currentEnd : "+currentEnd + ", i : "+i);
            if (i == currentEnd) {
                // Update the end of the range to the maximum reach
                currentEnd = maxReach;
                
                // Increase the jump count
                jumps++;
                
                // If the maximum reach is beyond or at the last index, return the jump count
                if (maxReach >= n - 1) {
                    return jumps;
                }
            }
        }
        
        // If we cannot reach the end, return -1
        return -1;
    }
}
