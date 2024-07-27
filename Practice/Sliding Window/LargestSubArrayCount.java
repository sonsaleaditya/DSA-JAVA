public class LargestSubArrayCount {
    public static void main(String[] args) {
        int arr[] = { 2, 2, 5, 6, 1, 1, 1, 1,1};
        int k = 5;
        System.out.println("Max count is " + maxSubArray(arr, k));
    }

    // Function to find the length of the longest subarray with sum equal to k
    static int maxSubArray(int arr[], int k) {
        int s = 0, e = 0, maxCount = 0, n = arr.length, sum = 0;

        // Iterate through the array with end pointer e
        while (e < n) {
            // Add the current element to the sum
            sum += arr[e];

            // If the sum exceeds k, move the start pointer s to the right
          while(sum>k && s<=e){
            sum-=arr[s];
            s++;
          }
            // If the sum equals k, update the maximum length found
            if (sum == k) {
                maxCount = Math.max(maxCount, e - s + 1);
            }

            // Move the end pointer e to the right
            e++;
        }
        return maxCount;
    }
}
