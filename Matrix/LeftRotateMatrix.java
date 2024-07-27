public class LeftRotateMatrix {
    public static void main(String[] args) {
        // Example of a square matrix
        int k1 = 2;
        int mat1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        
        // Example of a non-square matrix
        int k2 = 2;
        int mat2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        Solution obj = new Solution();
        
        System.out.println("Square matrix:");
        int result1[][] = obj.rotateMatrix(k1, mat1);
        printMatrix(result1);

        System.out.println("Non-square matrix:");
        int result2[][] = obj.rotateMatrix(k2, mat2);
        printMatrix(result2);
    }

    // Method to print the matrix
    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    // Rotates each row of the matrix to the left by k positions
    int[][] rotateMatrix(int k, int mat[][]) {
        int n = mat.length;
        int m = mat[0].length; // Number of columns in the matrix

        for (int i = 0; i < n; i++) {
            int temp = k % m; // To handle cases where k > m
            while (temp-- > 0) {
                int prev = mat[i][0];
                shiftLeft(mat[i], m);
                mat[i][m - 1] = prev;
            }
        }
        return mat;
    }

    // Shifts elements of the row to the left by one position
    static void shiftLeft(int row[], int length) {
        for (int i = 0; i < length - 1; i++) {
            row[i] = row[i + 1];
        }
    }

    // Method to print the matrix for debugging purposes
    static void printMat(int mat[][], int r) {
        System.out.println("\nFor row " + r);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
