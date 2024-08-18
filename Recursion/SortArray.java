import java.util.ArrayList;

public class SortArray {
    public static void main(String[] args) {
        // Create an ArrayList with some unsorted integers
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(4);
        arr.add(2);

        // Call the sort function to sort the array
        sort(arr);

        // Print the sorted array
        System.out.println(arr);  // Output: [1, 2, 3, 4]
    }

    /**
     * Problem Statement:
     * Given an unsorted ArrayList of integers, write a recursive function 
     * to sort the ArrayList in non-decreasing order. The function should 
     * not use any built-in sorting functions, and the list should be sorted 
     * in place without creating additional lists.
     *
     * Example:
     * Input: [3, 1, 4, 2]
     * Output: [1, 2, 3, 4]
     */

    /**
     * Recursive function to sort an ArrayList in non-decreasing order.
     *
     * @param arr The ArrayList of integers to be sorted.
     */
    static void sort(ArrayList<Integer> arr) {
        // Base case: If the list has 0 or 1 element, it is already sorted
        if (arr.size() <= 1) return;

        // Remove the last element from the list
        int temp = arr.remove(arr.size() - 1);
        
        // Sort the remaining list recursively
        sort(arr);

        // Insert the removed element back into the sorted list at the correct position
        solve(arr, temp);
    }

    /**
     * Recursive function to insert an element into its correct position
     * in a sorted ArrayList.
     *
     * @param arr The sorted ArrayList of integers.
     * @param element The integer to be inserted.
     */
    static void solve(ArrayList<Integer> arr, int element) {
        // Base case: If the list is empty or the last element is less than or equal
        // to the element to be inserted, add the element to the end of the list
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= element) {
            arr.add(element);
            return;
        }

        // Otherwise, remove the last element and recursively call solve to find
        // the correct position for the element
        int temp = arr.remove(arr.size() - 1);
        solve(arr, element);

        // After inserting the element, add the removed element back to the list
        arr.add(temp);
    }
}
