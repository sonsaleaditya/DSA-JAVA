/*
Problem Statement:
The Egg Dropping Problem is a classic optimization problem. 
You are given `e` eggs and `f` floors. The goal is to find the minimum number of attempts 
needed in the worst-case scenario to determine the highest floor from which an egg can be 
dropped without breaking.

Rules:
1. If an egg is dropped and it doesn't break, then it can be reused.
2. If an egg is dropped and it breaks, it cannot be reused.
3. You need to minimize the number of attempts to find the critical floor.

For example:
- With 3 eggs and 5 floors, the minimum number of attempts needed in the worst case is 3.
*/

public class Egg_Dropping {
    public static void main(String[] args) {
        int eggs = 3; 
        int floors = 5;
        
        // Initializing an array to represent the floors
        int arr[] = new int[floors];
        for(int i = 0; i < floors; i++) {
            arr[i] = i + 1;
        }

        // Initializing a 2D DP array to store the intermediate results
        int dp[][] = new int[floors + 1][floors + 1];
        
        // Calling the solve function and printing the result
        System.out.println(solve(eggs, floors, dp));
    }

    // Function to solve the egg dropping problem using dynamic programming
    static int solve(int e, int f, int dp[][]) {
        // Base cases
        if(e == 0) return f; // If no eggs are left, we need f attempts (linear search)
        if(f == 0 || f == 1) return f; // If 0 or 1 floor, the number of attempts equals the number of floors

        // If already computed, return the stored value
        if(dp[e][f] != 0) return dp[e][f];
        
        int min = Integer.MAX_VALUE;
        
        // Trying to drop an egg from each floor (1 to f) and calculating the worst case
        for(int k = 1; k <= f; k++) {
            int low = 0, high = 0;
            
            // If egg breaks, check the lower floors (1 to k-1)
            if(dp[e-1][k-1] != 0) {
                low = dp[e-1][k-1];
            } else {
                low = solve(e-1, k-1, dp);
            }

            // If egg doesn't break, check the higher floors (k+1 to f)
            if(dp[e][f-k] != 0) {
                high = dp[e][f-k];
            } else {
                high = solve(e, f-k, dp);
            }

            // Worst-case attempts needed
            int temp = 1 + Math.max(low, high);
            
            // Finding the minimum attempts among all floors
            min = Math.min(min, temp);
        }

        // Store the result in dp array and return
        dp[e][f] = min;

        return min;
    }
}
