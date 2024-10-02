public class Main {
    public static void main(String[] args) {
        int arr[] = { 20, 35, 46, 22 };
        int n = arr.length;
        int dp[][] = new int[n ][n ];
        int i = 1, j=n-1;
        System.out.println(matrixChainMultiplication(arr, i, j, dp));
    }

    static int matrixChainMultiplication(int arr[], int i, int j, int dp[][]) {
        if(i>=j) return 0;
        if(dp[i][j]!=0) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k =i; k<j; k++){
            int temp = matrixChainMultiplication(arr, i, k, dp)
            + matrixChainMultiplication(arr, k+1, j, dp)
            + arr[i-1]*arr[k]*arr[j];

            min = Math.min(temp, min);
        }

        dp[i][j] = min;

        return min;
    }
}
