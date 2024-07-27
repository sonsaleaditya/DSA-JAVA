/*A Toeplitz (or diagonal-constant) matrix is a matrix in which each descending diagonal from left to right is constant, i.e., all elements in a diagonal are the same. Given a rectangular matrix mat, your task is to complete the function isToepliz which returns true if the matrix is Toeplitz otherwise, it returns false.

Examples:

Input:
mat = [[6, 7, 8],
       [4, 6, 7],
       [1, 4, 6]]
Output: true
Explanation: The test case represents a 3x3 matrix
 6 7 8 
 4 6 7 
 1 4 6
Output:true, as values in all downward diagonals from left to right contain the same elements.

Input: 
mat = [[1,2,3],
       [4,5,6]]
Output: false
Explanation: Matrix of order 2x3 will be 1 2 3 4 5 6 Output: false as values in all diagonals are not the same.


*/

public class DiagonalMatrix {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] mat1 = {
            {6, 7, 8},
            {4, 6, 7},
            {1, 4, 6}
        };
        int[][] mat = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(obj.isToepliz(mat1)); // Output should be false
    }
}

class Solution {
    /* You are required to complete this method */
    boolean isToepliz(int mat[][]) {
        int row = mat.length;
        int col = mat[0].length;
        
        // Check all diagonals starting from the first row
        for (int j = 0; j < col; j++) {
            if (!checkDiagonal(mat, 0, j)) {
                return false;
            }
        }
        
        // Check all diagonals starting from the first column
        for (int i = 1; i < row; i++) {
            if (!checkDiagonal(mat, i, 0)) {
                return false;
            }
        }
        
        return true;
    }

    boolean checkDiagonal(int[][] mat, int row, int col) {
        int value = mat[row][col];
        int rows = mat.length;
        int cols = mat[0].length;
        
        while (row < rows && col < cols) {
            if (mat[row][col] != value) {
                return false;
            }
            row++;
            col++;
        }
        
        return true;
    }
}
