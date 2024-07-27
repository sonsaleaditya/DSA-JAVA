import java.util.*;

public class CountElements {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int n1 = 3;
        int a1[] = {4, 1, 2};
        int b1[] = {1, 7, 3};
        int q1 = 2;
        int query1[] = {0, 1};
        int[] result1 = obj.countElements(a1, b1, n1, query1, q1);
        for (int k : result1) {
            System.out.println(k);
        }

        // int n2 = 4;
        // int a2[] = {1, 1, 5, 5};
        // int b2[] = {0, 1, 2, 3};
        // int q2 = 4;
        // int query2[] = {0, 1, 2, 3};
        // int[] result2 = obj.countElements(a2, b2, n2, query2, q2);
        // for (int k : result2) {
        //     System.out.println(k);
        // }
    }
}

class Solution {
    public static int[] countElements(int a[], int b[], int n, int query[], int q) {
        // Sort array b
        Arrays.sort(b);

        // Array to store results
        int[] result = new int[q];

        // Process each query
        for (int i = 0; i < q; i++) {
            int x = query[i];
            int val = a[x];
            int count = binarySearch(b, val);
            result[i] = count;
        }

        return result;
    }

    // Binary search to find count of elements less than or equal to val
    // static int binarySearch(int[] arr, int val) {
    //     int low = 0;
    //     int high = arr.length - 1;
    //     int count = 0;

    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;

    //         if (arr[mid] <= val) {
    //             count = mid + 1;
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }

    //     return count;
    // }

    static int binarySearch(int arr[], int val){
        int low = 0;
        int high = arr.length-1;
        int count = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=val){
                // why count = mid+1 because we need all elements less than or equal to val
                count = mid+1;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return count;
    }


}
