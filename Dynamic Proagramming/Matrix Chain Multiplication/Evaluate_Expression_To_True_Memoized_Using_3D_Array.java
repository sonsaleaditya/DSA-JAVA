// Problem Statement:
// You are given a boolean expression containing 'T' (true), 'F' (false), and operators '&' (AND), '|' (OR), and '^' (XOR).
// Your task is to count the number of ways to parenthesize the expression such that it evaluates to true.
// Implement this using a memoized approach with a 3D array to optimize the solution.

public class Evaluate_Expression_To_True_Memoized_Using_3D_Array {
    
    // Function to count the number of ways to evaluate the expression to true
    public static int countWays(int n, String s) {
        // Initialize a 3D DP array for memoization
        // dp[i][j][0] will store the number of ways to evaluate the subexpression s[i...j] to false
        // dp[i][j][1] will store the number of ways to evaluate the subexpression s[i...j] to true
        int[][][] dp = new int[n + 1][n + 1][2];
        
        // Initialize the DP array with -1 indicating that no subproblem has been solved yet
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        
        // Call the recursive function to solve the problem
        return solve(s, 0, n - 1, true, dp);
    }

    // Recursive function to evaluate the subexpression from index i to j
    // isTrue is a boolean indicating whether we want the subexpression to evaluate to true or false
    private static int solve(String str, int i, int j, boolean isTrue, int[][][] dp) {
        int mod = 1003;  // Modulo to prevent overflow

        // Base case: If the indices cross each other, return 0 (no way to parenthesize)
        if (i > j) return 0;

        // Base case: If there's only one character left (either 'T' or 'F')
        if (i == j) {
            if (isTrue) {
                return str.charAt(i) == 'T' ? 1 : 0;  // Return 1 if it's 'T' and we want true, else 0
            } else {
                return str.charAt(i) == 'F' ? 1 : 0;  // Return 1 if it's 'F' and we want false, else 0
            }
        }

        // Convert boolean isTrue to integer (0 for false, 1 for true)
        int isTrueInt = isTrue ? 1 : 0;

        // If the subproblem has already been solved, return the stored result
        if (dp[i][j][isTrueInt] != -1) return dp[i][j][isTrueInt];

        int ans = 0;  // Variable to store the number of ways

        // Iterate over the operators in the expression (only at odd indices)
        for (int k = i + 1; k < j; k += 2) {
            char operator = str.charAt(k);  // Current operator

            // Recursively solve the left and right subexpressions
            int lT = solve(str, i, k - 1, true, dp) % mod;   // Left subexpression evaluates to true
            int lF = solve(str, i, k - 1, false, dp) % mod;  // Left subexpression evaluates to false
            int rT = solve(str, k + 1, j, true, dp) % mod;   // Right subexpression evaluates to true
            int rF = solve(str, k + 1, j, false, dp) % mod;  // Right subexpression evaluates to false

            // Calculate the number of ways based on the operator and the desired outcome (isTrue)
            if (operator == '&') {
                if (isTrue) {
                    ans = (ans + (lT * rT) % mod) % mod;  // Both sides must be true for AND
                } else {
                    ans = (ans + (lF * rT) % mod + (rF * lT) % mod + (lF * rF) % mod) % mod;  // Any side false means false
                }
            } else if (operator == '|') {
                if (isTrue) {
                    ans = (ans + (lT * rT) % mod + (lT * rF) % mod + (rT * lF) % mod) % mod;  // Any side true means true
                } else {
                    ans = (ans + (lF * rF) % mod) % mod;  // Both sides must be false for OR
                }
            } else if (operator == '^') {
                if (isTrue) {
                    ans = (ans + (lT * rF) % mod + (lF * rT) % mod) % mod;  // One true, one false for XOR to be true
                } else {
                    ans = (ans + (lT * rT) % mod + (lF * rF) % mod) % mod;  // Both same for XOR to be false
                }
            }
        }

        // Store the result in the DP array and return
        dp[i][j][isTrueInt] = ans;
        return dp[i][j][isTrueInt];
    }

    // Example usage
    public static void main(String[] args) {
        String expression = "T|T&F^T";
        int n = expression.length();
        System.out.println("Number of ways to evaluate the expression to true: " + countWays(n, expression));
    }
}
