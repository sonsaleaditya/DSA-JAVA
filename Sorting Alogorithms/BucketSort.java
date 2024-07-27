import java.util.ArrayList;

public class BucketSort {
    int arr[];

    // Constructor
    BucketSort(int arr[]) {
        this.arr = arr;
    }

    // Utility method to print an array
    void printArray(int arr[]) {
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println(); // Adding a newline after printing the array
    }

    // Utility method to print buckets
    void printBuckets(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("\nBucket #" + i + " : ");
            for (Integer k : buckets[i]) {
                System.out.print(k + " ");
            }
        }
        System.out.println(); // Adding a newline after printing the buckets
    }

    // Bucket sort algorithm
    void bucketSort() {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets]; // Using ArrayList instead of Array
        int max = findMax();

        // Initialize buckets
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets
        for (int k : arr) {
            int findBucketNumber = (int) Math.ceil((double) k * numberOfBuckets / max);
            buckets[findBucketNumber - 1].add(k); // -1 to adjust for zero-based indexing
        }

        // Sort individual buckets and merge
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            bucket.sort(null); // Using built-in sorting for simplicity
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    // Utility method to find the maximum element in the array
    int findMax() {
        int maxElement = arr[0];
        for (int max : arr) {
            if (maxElement < max) {
                maxElement = max;
            }
        }
        return maxElement;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        int[] array = {29, 25, 33, 15, 88, 45, 60};
        BucketSort sorter = new BucketSort(array);

        System.out.println("Original Array:");
        sorter.printArray(array);

        // Sorting
        sorter.bucketSort();

        System.out.println("Sorted Array:");
        sorter.printArray(array);
    }
}
