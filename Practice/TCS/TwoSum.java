public class TwoSum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int target = 7;
        
        // Print the indices of the two numbers that sum up to the target
        for (int k : twoSum(arr, target))
            System.out.println(k);
    }

    // Method to find two numbers in the sorted array that sum up to the target
    static int[] twoSum(int arr[], int target) {
        // Initialize two pointers, one at the beginning and one at the end
        int start = 0;
        int end = arr.length - 1;
        int sum;

        // Loop until the sum of elements at start and end equals the target
        while (arr[start] + arr[end] != target) {
            // Calculate the current sum of elements at start and end
            sum = arr[start] + arr[end];

            // If the sum is greater than the target, move the end pointer to the left
            if (sum > target) end--;
            // If the sum is less than the target, move the start pointer to the right
            else start++;
        }

        // Return the 1-based indices (hence start + 1 and end + 1)
        return new int[] { start + 1, end + 1 };
    }
}
