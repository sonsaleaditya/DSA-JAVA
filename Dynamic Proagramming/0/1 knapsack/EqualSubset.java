public class EqualSubset {
    public static void main(String[] args) {
        int arr[] = {1,5,5,11};
        
        // Check if the array can be partitioned into two subsets with equal sum
        if (isEqualSubset(arr)) {
            System.out.println("It has two equal subsets!!");
        } else {
            System.out.println("It does not have two equal subsets!!");
        }
    }

    /**
     * Method to check if the array can be partitioned into two subsets with equal sum
     */
    static boolean isEqualSubset(int arr[]) {
        int sum = 0;
        
        // Calculate the total sum of the array elements
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        // If the total sum is odd, it's not possible to split it into two equal subsets
        if (sum % 2 != 0)
            return false;

        // Check if there exists a subset with sum equal to half of the total sum
        return isSubsetSum(arr, sum / 2, arr.length);
    }

    /**
     * Method to check if there exists a subset with a given sum using dynamic programming
     */
    static boolean isSubsetSum(int arr[], int sum, int n) {
        boolean dp[][] = new boolean[n + 1][sum + 1];
        
        // Initialize first column of dp array as true since a sum of 0 can always be achieved with an empty subset
        for (int i = 0; i <= n; i++)  
            dp[i][0] = true;

        // Initialize first row of dp array (except dp[0][0]) as false since no sum > 0 can be achieved with 0 elements
        for (int i = 1; i <= sum; i++)  
            dp[0][i] = false;

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If the current element is less than or equal to the current sum, 
                // check if the sum can be achieved by including or excluding the current element
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    // If the current element is greater than the current sum, 
                    // exclude the current element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printDPMat(dp);
        
        // Return the value of dp[n][sum] which indicates whether the subset sum is possible or not
        return dp[n][sum];
    }

    static void printDPMat(boolean arr[][]){
        int r = arr.length;
        int c= arr[0].length;
        System.out.print(" ");
        for(int i=0;i<c;i++) System.out.print(" "+i);
        System.out.println();
        for(int i=0;i<r;i++){
            System.out.print(i+" ");
            for(int j=0;j<c;j++){
                
                if(arr[i][j])
                    System.out.print("T ");
                else System.out.print("F ");
            }
            System.out.println();
        }

    }
}
