public class CountOfSubset {
    public static void main(String[] args) {
        // Define the array and the target sum
        int arr[] = {2, 3, 5, 6, 8, 10};
        int sum = 10;

        // Call the countOfSubset method and print the result
        System.out.println("Count of Subsets is: " + countOfSubset(arr, sum));
    }

    static int countOfSubset(int arr[], int sum) {
        int n = arr.length;
        
        // Create a 2D dp array to store the count of subsets for each sum and array size
        int dp[][] = new int[n + 1][sum + 1];

        // Initialize the first row to 0, as there are no subsets possible with a positive sum and zero elements
        for (int i = 1; i <= sum; i++) dp[0][i] = 0;

        // Initialize the first column to 1, as there is exactly one subset (the empty subset) with sum 0 for any number of elements
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // If the current element can be included in the subset, the count is the sum of the subsets including this element and excluding this element
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    // If the current element cannot be included, the count is the same as the count without this element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printDPMat(dp);
        System.out.println("\n");
        // Return the count of subsets with the given sum
        return dp[n][sum];
    }

    static void printDPMat(int arr[][]){
        int r = arr.length;
        int c= arr[0].length;
        System.out.print(" ");
        for(int i=0;i<c;i++) System.out.print(" "+i);
        System.out.println();
        for(int i=0;i<r;i++){
            System.out.print(i+" ");
            for(int j=0;j<c;j++){
                
                
                    System.out.print(arr[i][j] +" ");
               
            }
            System.out.println();
        }

    }
}
