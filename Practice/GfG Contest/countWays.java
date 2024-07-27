public class countWays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countWays(1000000000));  // Expected output: 368079378
        // Additional test cases to validate
        System.out.println(solution.countWays(1));           // Expected output: 1
        System.out.println(solution.countWays(2));           // Expected output: 18
        System.out.println(solution.countWays(10));          // Test with a moderate n value
    }
}
class Solution {
    public static int countWays(int n) {
        final int MOD = 1000000007;

        // Total number of n-digit numbers
        long total = (9 * modPow(10, n - 1, MOD)) % MOD;

        // Total number of n-digit numbers without '7'
        long without7 = (8 * modPow(9, n - 1, MOD)) % MOD;

        // Number of n-digit numbers with at least one '7'
        long result = (total - without7 + MOD) % MOD;

        return (int) result;
    }

    // Function to perform modular exponentiation
    private static long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    
}

