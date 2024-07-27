public class CountNumberOfSubsetWIthGivenDiff {
    public static void main(String[] args) {
        // Define the array and the desired difference
        int arr[] = {1, 5 ,3 ,4 ,2};
        int diff = 3;

        // Calculate the sum of all elements in the array
        int sumOfArr = 0;
        for (int i : arr) sumOfArr += i;

        // Calculate the sum of the subset1 using the derived formula
        int sumOfSubset1 = (sumOfArr + diff) / 2;

        // Print the result by calling countSubset method
        System.out.println("Subset count available with this diff is: " + countSubset(arr, sumOfSubset1));
    }

    // Method to count the number of subsets with a given sum
    static int countSubset(int arr[], int sum) {
        int n = arr.length;

        // Create a 2D array for dynamic programming table
        int dp[][] = new int[n + 1][sum + 1];

        // Initialize the first row of the DP table
        // If sum is non-zero and no elements are included, count is 0
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }

        // Initialize the first column of the DP table
        // If sum is zero, count is 1 (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table using the subset sum logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // If the current element can be included, include it
                    // and add the result of excluding it
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    // If the current element cannot be included, exclude it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the count of subsets with the given sum
        return dp[n][sum];
    }
}
