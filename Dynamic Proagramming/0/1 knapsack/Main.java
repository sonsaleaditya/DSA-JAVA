import java.util.*;
public class Main {
    public static void main(String[] args) {
        //  Sample weights and values of items
        int[] wt = {10,8,6};
        int[] val = {1, 7,9};
        
        // Maximum weight capacity of the knapsack
        int w = 7;
        
        // Number of items
        int n = wt.length;
        
  
        // Print the maximum value that can be achieved
        System.out.println("Maximum value in Knapsack = " + knapsack( wt, val , w));

        int[] coins = {1, 2, 3}; int target = 3;
        System.out.println("max coin changes are : "+maxCoinChange(coins,target));

        int arr[] = {2, 3, 5, 6, 8, 10};
      
        int sum = 7;
        System.out.println("subset of sum  : "+countOfSubsetWithTargetSum(arr,sum));
        int arr1[] = {1,2,7};
        System.out.println("min diff is   : "+ subsetDifference(arr1));


    }

    static int knapsack(int arr[], int profit[], int capacity){
        int n=arr.length;
        int dp[][] =  new int[n+1][capacity+1];

        for(int i=1;i<=n;i++){
            for(int j=1; j<=capacity;j++){
                if(arr[i-1]<=j){
                    dp[i][j]= Math.max(dp[i-1][j-arr[i-1]]+profit[i-1] , dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    

    return dp[n][capacity];
    }

    static int maxCoinChange(int coins[], int target){
        int n = coins.length;
        int dp[][] = new int[n+1][target+1];

        for(int i=1;i<=target;i++){
            dp[0][i] = 0;
        }

        for(int i=0;i<=target;i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=target; j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i][j-1];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }

    static int countOfSubsetWithTargetSum(int arr[], int targetSum){
        int n = arr.length;
        int dp[][] = new int[n+1][targetSum+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=targetSum;i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1;j<=targetSum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][targetSum];

    }

    static int subsetDifference(int arr[]){
        int range = 0, n = arr.length;
        for(int k: arr) range+=k;

        //check whether subset sum exist or not

        boolean dp[][] = new boolean[n+1][range+1];
        for(int i=0;i<=n;i++) dp[i][0] = true;
        for(int i=1;i<=range;i++) dp[0][i] = false;

        for(int i=1; i<=n;i++){
            for(int j=1; j<=range; j++)
            {
                if(arr[i-1]<=j){
                    dp[i][j]= dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // check last row of dp to check which sum available index referes to sum 
        ArrayList<Integer> lastRow = new ArrayList<>();

        for(int i=0;i<=range; i++){
            if(dp[n][i]){
                lastRow.add(i);
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i=0;i<range/2;i++){
            min = Math.min(min,Math.abs(range - 2*lastRow.get(i)));
        }

        return min;
    }   
}
