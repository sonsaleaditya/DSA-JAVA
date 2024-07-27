public class MinCostReachLastCell {
    public static void main(String[] args) {
        // Define the 2D array with the given cost values
        int arr[][] = { 
            { 4, 7, 8, 6, 4 }, 
            { 6, 7, 3, 9, 2 }, 
            { 3, 8, 1, 2, 4 }, 
            { 7, 1, 7, 3, 7 }, 
            { 2, 9, 8, 9, 3 } 
        };
        
        // Get the number of rows and columns in the array
        int row = arr.length;
        int col = arr[0].length;
        
        // Find and print the minimum cost to reach the last cell from the first cell
        System.out.println(findMinCost(arr, row - 1, col - 1));
    }

    static int findMinCost(int arr[][], int r, int c) {
        // Base case: If we go out of bounds, return a very high cost
        if (r == -1 || c == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Base case: If we are at the top-left cell, return its value as it's the starting point
        if (r == 0 && c == 0) {
            return arr[0][0];
        }

        // Recursive call to find the minimum cost from the left cell
        int leftCost = findMinCost(arr, r, c - 1);
        
        // Recursive call to find the minimum cost from the top cell
        int upCost = findMinCost(arr, r - 1, c);
        
        // Return the minimum cost to reach this cell by adding the current cell's value
        // to the smaller of the two costs from the left and top cells
        return Math.min(leftCost, upCost) + arr[r][c];
    }
}
 