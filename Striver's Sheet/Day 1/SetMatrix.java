public class SetMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 0, 7 },
                { 8, 9, 4, 6 },
                { 8, 4, 5, 2 } };

        Solution obj = new Solution();
        obj.MakeZeros(matrix);
        printMat(matrix);
    }

    static void printMat(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }

            System.out.println();
        }
    }
}

class Solution {
    public void MakeZeros(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] copy = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (copy[i][j] == 0) {

                    int sum = 0;

                    if (i > 0) {
                        sum +=copy[i - 1][j];
                        matrix[i - 1][j] = 0;
                    }

                    if (i < rows - 1) {
                        sum +=copy[i + 1][j];
                        matrix[i + 1][j] = 0;
                    }

                    if (j > 0) {
                        sum +=copy[i][j - 1];
                        matrix[i][j - 1] = 0;

                    }
                    if (j < cols - 1) {
                        sum +=copy[i][j + 1];
                        matrix[i][j + 1] = 0;

                    }

                  matrix[i][j] = sum;

                }
            }

        }

       

    }
}