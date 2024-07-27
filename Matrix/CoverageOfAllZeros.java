public class CoverageOfAllZeros {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 0},
            {0, 1, 1},
            {0, 0, 0}
        };
        Solution obj = new Solution();
        int coverage = obj.findCoverage(matrix);
        System.out.println("Coverage is: " + coverage);
    }
}

class Solution {
    // Method to find the total coverage of all zeros in the matrix
    public int findCoverage(int[][] matrix) {
        int count = 0; // Initialize count of total coverage
        int rows = matrix.length; // Get the number of rows
        int cols = matrix[0].length; // Get the number of columns
        // Iterate through each element of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current element is 0, find its coverage
                if (matrix[i][j] == 0)
                    count += traverse(matrix, i, j, rows, cols);
            }
        }
        return count; // Return the total coverage
    }

    // Helper method to calculate the coverage of a zero at position (i, j)
    static int traverse(int[][] matrix, int i, int j, int rows, int cols) {
        int[] dRows = {0, 0, -1, 1}; // Direction vectors for row changes (left, right, up, down)
        int[] dCols = {-1, 1, 0, 0}; // Direction vectors for column changes (left, right, up, down)
        int count = 0; // Initialize count of ones around the zero

        // Check all four directions
        for (int d = 0; d < 4; d++) {
            int newI = i + dRows[d]; // Calculate new row index
            int newJ = j + dCols[d]; // Calculate new column index
            // Check if the new indices are within bounds and the neighboring element is 1
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && matrix[newI][newJ] == 1) {
                count++; // Increment count if the neighboring element is 1
            }
        }
        return count; // Return the count of ones around the zero
    }
}
