public class SetMatrixZeros {
    public static void main(String[] args) {
        int matrix[][] = {
            { 1, 2, 3, 4 },
            { 5, 6, 0, 7 },
            { 8, 9, 4, 6 },
            { 8, 4, 5, 2 } };

            Solution obj = new Solution();
            obj.setZeroes(matrix);
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
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
              if(matrix[i][j]==0){
                zeroRows[i] = true;
                zeroCols[j]= true;
              }

            }

           
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(zeroCols[j] || zeroRows[i]){
                    matrix[i][j]=0;
                }
            }

          
        }
    }
    
}