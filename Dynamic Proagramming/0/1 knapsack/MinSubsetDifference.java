import java.util.ArrayList;

public class MinSubsetDifference {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        int range = 0;

        // Calculate the total sum of the array elements
        for (int k : arr)
            range += k;

        // Call the method to find the minimum subset difference and print the result
        System.out.println("Minimum difference is: " + minSubsetDiff(arr, range));
    }

    static int minSubsetDiff(int arr[], int range) {
        int n = arr.length;
        // Create a dp array to store subset sums up to the given range
        boolean dp[][] = new boolean[n + 1][range + 1];

        // Initialize the first row to false (except dp[0][0]) since no positive sum can be achieved with 0 elements
        for (int i = 1; i <= range; i++) 
            dp[0][i] = false;

        // Initialize the first column to true since a sum of 0 can always be achieved with any number of elements
        for (int i = 0; i <= n; i++) 
            dp[i][0] = true;

        // Populate the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if (arr[i - 1] <= j) {
                    // Include or exclude the current element
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    // Exclude the current element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the subset sums that can be achieved (stored in the last row of the dp array)
        ArrayList<Integer> lastRow = new ArrayList<>();
        for (int i = 0; i <= range; i++) {
            if (dp[n][i]) {
                lastRow.add(i);
            }
        }

        // Calculate the minimum difference
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= lastRow.size() / 2; i++) {
            // The difference between two subsets is given by range - 2 * subset sum
            min = Math.abs(Math.min(min, range - 2 * lastRow.get(i)));
        }

        return min;
    }
}
