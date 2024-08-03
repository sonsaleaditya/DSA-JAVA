import java.util.ArrayList;

/**
 * Problem Statement:
 * Given a 2D matrix, the task is to return all the elements of the matrix in a spiral order.
 * 
 * A matrix is represented as a 2D array, and the spiral order involves traversing the matrix in a 
 * clockwise direction starting from the top-left corner. The traversal continues in the following
 * order: left to right, top to bottom, right to left, and bottom to top, repeating the process
 * by moving the boundaries inward.
 * 
 * Example:
 * Input: matrix = [
 *   [1, 2, 3],
 *   [4, 5, 6],
 *   [7, 8, 9]
 * ]
 * Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */

public class SpiralMatrix {

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        Solution sol = new Solution();
        ArrayList<Integer> result = sol.spirallyTraverse(matrix);
        System.out.println(result);
    }
}

class Solution {

    /**
     * Function to traverse the matrix in a spiral order and return the elements in an ArrayList.
     * 
     * @param matrix The 2D matrix to be traversed
     * @return An ArrayList containing the elements of the matrix in spiral order
     */
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        ArrayList<Integer> arr = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;      // left boundary
        int r = cols - 1; // right boundary
        int top = 0;    // top boundary
        int bot = rows - 1; // bottom boundary

        // Traverse the matrix in spiral order
        while (l <= r && top <= bot) {
            // Traverse from left to right
            for (int i = l; i <= r; i++) {
                arr.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bot; i++) {
                arr.add(matrix[i][r]);
            }
            r--;

            // Traverse from right to left, if there are remaining rows
            if (top <= bot) {
                for (int i = r; i >= l; i--) {
                    arr.add(matrix[bot][i]);
                }
                bot--;
            }

            // Traverse from bottom to top, if there are remaining columns
            if (l <= r) {
                for (int i = bot; i >= top; i--) {
                    arr.add(matrix[i][l]);
                }
                l++;
            }
        }

        return arr;
    }
}
