class MatrixTraversal{
    public static void main(String[] args) {
       int[][] matrix = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
       };

       // get the rows and columns
       int rows = matrix.length;
       int cols = matrix[0].length;

      
       for(int i =0; i<rows; i++){
        for(int j =0; j<cols; j++){
            traverse(matrix, i, j, rows,cols);
        }
       }
    }
    static void traverse(int matrix[][],int i, int j, int rows, int cols){
        System.out.println("Element at (" + i + ", " + j + ") = " + matrix[i][j]);
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        for(int d = 0; d<4; d++ ){
            int newI =i+dRow[d];
            int newJ = j+dCol[d];
            if(newI>=0 && newI<rows && newJ>=0 && newJ<cols){
                System.out.println("  Neighbor element at (" + newI + ", " + newJ + ") = " + matrix[newI][newJ]);
            }else {
                System.out.println("  Neighbor element at (" + newI + ", " + newJ + ") is out of bounds");
            }
            
        }
    }
}