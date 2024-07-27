import java.util.Arrays;
public class MaximizeDotProduct {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = {9,3,9,2,3,5,4,1,8,8};
        int b[] = {10, 4, 3, 8};
        int result = s.maxDotProduct(a.length, b.length,a,b);
        System.out.println("Dot Product is : "+result);
    }
}

class Solution
{
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
		int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) 
        {
            for (int j = i; j <= n; j++) 
            {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + a[j - 1] * b[i - 1], dp[i][j - 1]);
            }
        }
        
        return dp[m][n];
	} 
}

