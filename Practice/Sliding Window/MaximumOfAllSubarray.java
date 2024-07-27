import java.util.ArrayList;

public class MaximumOfAllSubarray {
    public static void main(String[] args) {
        // Sample array and subarray size k
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Find the maximum of all subarrays of size k
        ArrayList<Integer> result = findMax(arr, k);
        
        // Print the result
        System.out.println(result);
    }

    // Function to find the maximum of all subarrays of size k
    static ArrayList<Integer> findMax(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int s = 0, e = 0, max = arr[0], n = arr.length;

        // Iterate through the array
        while (e < n) {
            // Update max if the current element is greater
            if (max < arr[e]) {
                max = arr[e];
            }

            // Check if the window size is equal to k
            if (e - s + 1 == k) {
                // Add the maximum of the current window to the result list
                result.add(max);

                // If the maximum element is about to be excluded from the window
                if (max == arr[s]) {
                    // Recalculate the max for the new window
                    max = calculateMax(arr, s + 1, e);
                }
                // Move the start of the window forward
                s++;
            }
            // Move the end of the window forward
            e++;
        }
        return result;
    }

    // Helper function to calculate the maximum in a given subarray from s to e
    static int calculateMax(int arr[], int s, int e) {
        int max = Integer.MIN_VALUE;
        for (int i = s; i <= e; i++) {
            // Update max if the current element is greater
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
