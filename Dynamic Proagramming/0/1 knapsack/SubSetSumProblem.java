public class SubSetSumProblem {
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 30;

        if (isSumPresent(arr, sum, arr.length)) {
            System.out.println("sum is Present");
        } else {
            System.out.println("sum is not present");
        }

    }

   static boolean  isSumPresent(int arr[],int sum,int n){
    boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0] = true;
        for(int i=1;i<=sum;i++) dp[0][i] = false; 

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j]= dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
