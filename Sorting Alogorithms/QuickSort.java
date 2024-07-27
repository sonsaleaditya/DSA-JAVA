public class QuickSort {
    
    // Partition the array into two parts based on a pivot element
    // Elements less than or equal to the pivot are placed to the left of it,
    // and elements greater than the pivot are placed to the right of it.
    // Returns the index of the pivot element after partitioning.
    public int partition(int arr[], int start, int end) {
        int pivot = end; // Selecting the pivot element (usually the last element)
        int i = start - 1; // Index of smaller element
        
        // Iterate through the array
        for(int j = start; j < end; j++) {
            // If current element is less than or equal to the pivot
            if(arr[j] <= arr[pivot]) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // Swap arr[i+1] and arr[pivot] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[pivot];
        arr[pivot] = temp;

        // Return the index of the pivot element after partitioning
        return i + 1;
    }

    // Recursive function to perform quick sort on the array
    public void quickSort(int arr[], int start, int end) {
        // Base case: if the start index is less than the end index
        if(start < end) {
            // Partition the array and get the pivot index
            int pivot = partition(arr, start, end);
            
            // Recursively sort elements before partition and after partition
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    // Utility method to print an array
    public void printArray(int arr[]) {
        for (int k : arr)
            System.out.print(" " + k + " ");
    }
    public static void main(String[] args) {
       int arr[] = {1,3,6,3,2,5,4,7,9,10};
        QuickSort obj = new QuickSort();
        System.out.println(" before sorting : ");
        obj.printArray(arr);

        obj.quickSort(arr, 0, arr.length-1);
        System.out.println();
        System.out.println(" after sorting : ");
        obj.printArray(arr);
       
    }
}
