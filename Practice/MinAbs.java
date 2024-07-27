import java.util.*;
public class MinAbs {
    public static void main(String[] args) {
        int n = 4;
        int arr[] = {1, 3, 6, 7,4};
        int k = 4;
       int x =  findClosest(n, k, arr);
       System.out.println("\n"+x);
    }

    public static int findClosest(int n, int k, int[] arr) {
        // Initialize the result with the first element of the array
        int closestElement = arr[0];
        // Calculate the absolute difference between the first element and k
        int minDifference = Math.abs(arr[0] - k);
        
        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Calculate the absolute difference between the current element and k
            int currentDifference = Math.abs(arr[i] - k);
            
            // If the current difference is smaller than the minimum difference,
            // or if the current difference is equal to the minimum difference and
            // the current element is greater than the closest element found so far,
            // update the closest element and the minimum difference
            if ((currentDifference < minDifference) || 
                (currentDifference == minDifference && arr[i] > closestElement)) {
                minDifference = currentDifference;
                closestElement = arr[i];
            }
        }
        
        // Return the closest element found
        return closestElement;
    }
}
