import java.util.ArrayList;

public class PascalTriangle {

    public static void main(String[] args) {

        // Problem Statement:
        // Pascal's Triangle is a triangular array of numbers where the numbers at the nth row and rth column represent the combination nCr.
        // Each element in Pascal's Triangle is the sum of the two elements directly above it.
        //
        // The first row is [1], the second row is [1, 1], and so on.
        //
        // The task is to generate specific rows, elements, or the entire triangle.

        // Example Usage:
        // 1. Find the 6th row and 2nd column element in Pascal's Triangle (0-based index).
        // This is equivalent to 5C1 (5 Combination 1).
        System.out.println("6th row, 2nd column element: " + combination(6, 2));

        // 2. Print the 4th row of Pascal's Triangle
        System.out.print("4th row: ");
        int n = 4;
        ArrayList<Integer> row = generateRow(n);
        for (int num : row) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 3. Generate the entire Pascal's Triangle up to the nth row (example for N=5)
        System.out.println("Pascal's Triangle up to 5 rows:");
        ArrayList<ArrayList<Integer>> triangle = pascal(5);
        for (ArrayList<Integer> r : triangle) {
            System.out.println(r);
        }
    }

    // Method to calculate the combination nCr
    static int combination(int n, int r) {
        int result = 1;

        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1); // Changed division to (i + 1) to avoid integer division issues
        }

        return result;
    }

    // Method to generate a specific row of Pascal's Triangle
    static ArrayList<Integer> generateRow(int row) {
        ArrayList<Integer> arr = new ArrayList<>();
        int ans = 1;
        arr.add(ans); // The first element of each row is always 1
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            arr.add(ans);
        }

        return arr;
    }

    // Method to generate Pascal's Triangle up to N rows
    static ArrayList<ArrayList<Integer>> pascal(int N) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(generateRow(i)); // Corrected to directly add the generated row
        }

        return arr;
    }
}
