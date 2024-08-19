import java.util.ArrayList;

public class SortArr {
    public static void main(String[] args) {
        // Example usage of the sort method
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(4);
        arr.add(2);

        SortArr sorter = new SortArr();
        sorter.sort(arr);
        
        // Output the sorted array
        System.out.println(arr); // Output: [1, 2, 3, 4]
    }

    /**
     * Sorts the given ArrayList in ascending order using recursion.
     * @param arr The ArrayList to be sorted.
     */
    void sort(ArrayList<Integer> arr) {
        // Base case: If the array has only one element, it is already sorted.
        if (arr.size() == 1) {
            return;
        }

        // Remove the last element from the array.
        int temp = arr.remove(arr.size() - 1);

        // Recursively sort the remaining array.
        sort(arr);

        // Insert the removed element back into the sorted array in its correct position.
        insert(arr, temp);
    }

    /**
     * Inserts an element into its correct position in a sorted ArrayList.
     * @param arr The sorted ArrayList.
     * @param element The element to be inserted.
     */
    void insert(ArrayList<Integer> arr, int element) {
        // Base case: If the array is empty or the last element in the array is less than or equal
        // to the element to be inserted, add the element to the end of the array.
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= element) {
            arr.add(element);
            return;
        }

        // Remove the last element from the array.
        int temp = arr.remove(arr.size() - 1);

        // Recursively insert the element into the array.
        insert(arr, element);

        // After the correct position is found, add the removed element back to the array.
        arr.add(temp);
    }
}
