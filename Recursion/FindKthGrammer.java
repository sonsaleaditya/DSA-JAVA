/**
 * Problem Statement:
 * The K-th Grammar problem is defined as follows:
 * 
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace
 * each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * 
 * Given two integers n and k, where n represents the row number and k represents the index (1-based) in that row,
 * return the K-th indexed symbol in the N-th row of the grammar sequence.
 * 
 * Example 1:
 * Input: n = 1, k = 1
 * Output: 0
 * Explanation: row 1: 0
 * 
 * Example 2:
 * Input: n = 2, k = 1
 * Output: 0
 * Explanation: row 1: 0
 *              row 2: 01
 * 
 * Example 3:
 * Input: n = 2, k = 2
 * Output: 1
 * Explanation: row 1: 0
 *              row 2: 01
 * 
 * Example 4:
 * Input: n = 4, k = 5
 * Output: 1
 * Explanation: row 1: 0
 *              row 2: 01
 *              row 3: 0110
 *              row 4: 01101001 (k=5 is '1')
 */

 public class FindKthGrammer {
    public static void main(String[] args) {
        FindKthGrammer solution = new FindKthGrammer();

        // Example usage
        int n1 = 1, k1 = 1;
        System.out.println("Output: " + solution.solve(n1, k1)); // Expected output: 0

        int n2 = 2, k2 = 1;
        System.out.println("Output: " + solution.solve(n2, k2)); // Expected output: 0

        int n3 = 2, k3 = 2;
        System.out.println("Output: " + solution.solve(n3, k3)); // Expected output: 1

        int n4 = 4, k4 = 5;
        System.out.println("Output: " + solution.solve(n4, k4)); // Expected output: 1
    }

    // Recursive method to find the K-th indexed symbol in the N-th row
    int solve(int n, int k) {
        // Base case: the first row has only one element which is 0
        if (n == 1 && k == 1) {
            return 0;
        }

        // Calculate the midpoint of the current row
        int mid = (int) Math.pow(2, n - 1) / 2;

        // If k is in the first half of the row, it has the same value as the corresponding position in the previous row
        if (k <= mid) {
            return solve(n - 1, k);
        } else {
            // If k is in the second half, it is the complement of the corresponding position in the previous row
            return solve(n - 1, k - mid) == 0 ? 1 : 0;
        }
    }
}
