public class MergeSort {
    public static void main(String[] args) {
        // Input array
        int arr[] = {2, 5, 2, 1, 5, 6, 3, 7, 4};

        // Create an instance of MergeSort class
        MergeSort obj = new MergeSort();

        // Display original array before sorting
        System.out.print("Before sorting: ");
        obj.printArray(arr);
        System.out.println(); // Adding newline for clarity

        // Perform MergeSort
        System.out.println("After Sorting:");
        obj.divide(arr, 0, arr.length - 1); // Call divide method to sort the array
        obj.printArray(arr); // Display sorted array
    }

    // Method to divide the array into smaller subarrays
    public void divide(int arr[], int left, int right) {
       
        if (left < right) {
            // Calculate the middle index
            int mid = (left + right) / 2;
            // Recursively divide the left subarray
            divide(arr, left, mid);
            // Recursively divide the right subarray
            divide(arr, mid + 1, right);
            // Merge the divided subarrays
            merge(arr, left, mid, right);
        }
    }

    // Method to merge two sorted subarrays into one sorted array
    public void merge(int arr[], int left, int mid, int right) {
        System.out.println("left : " + left + " right : "+right);
        // Calculate sizes of two subarrays
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Create temporary arrays to hold the subarrays
        int leftArrays[] = new int[leftSize];
        int rightArrays[] = new int[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftArrays[i] = arr[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArrays[i] = arr[mid + 1 + i];
        }

        // Merge the temporary arrays back into arr[l..r]

        // Initial indexes of the merged subarray
        int i = 0, j = 0;
        int k = left;

        // Merge elements from leftArrays and rightArrays into arr[]
        while (i < leftSize && j < rightSize) {
            if (leftArrays[i] <= rightArrays[j]) {
                arr[k] = leftArrays[i];
                i++;
            } else {
                arr[k] = rightArrays[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArrays[] if any
        while (i < leftSize) {
            arr[k] = leftArrays[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArrays[] if any
        while (j < rightSize) {
            arr[k] = rightArrays[j];
            j++;
            k++;
        }
    }

    // Utility method to print an array
    public void printArray(int arr[]) {
        for (int k : arr)
            System.out.print(" " + k + " ");
    }
}
