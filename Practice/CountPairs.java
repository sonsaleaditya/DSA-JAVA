/*0*8 = 0
1*4 = 4
2*2 = 4
3*1 = 3
So, the array after these operations becomes: [0, 4, 4, 3].

Pairs which hold the condition i*arr[i] > j*arr[j] are:

(4, 1) -> 4 > 3
(2, 1) -> 4 > 3
So, in total, there are 2 pairs that satisfy the condition.

*/
public class CountPairs {
    public static void main(String[] args) {
        Solution obj = new Solution();
       
            int[] arr1 = {8, 4, 2, 1};
            int n1 = 4;
            System.out.println("Output for Example 1: " + obj.countPairs(arr1, n1)); // Output: 2
    
            int[] arr2 = {5, 0, 10, 2, 4, 1, 6};
            int n2 = 7;
            System.out.println("Output for Example 2: " + obj.countPairs(arr2, n2)); // Output: 5
        
    }
}

class Solution {

    // Function to count pairs that satisfy the condition i*arr[i] > j*arr[j]
    static int countPairs(int arr[], int n) {
        // Array to store values of i*arr[i]
        int[] a = new int[n];
        // Variable to store the count of pairs that satisfy the condition
        int ans = 0;

        // Calculate i*arr[i] for each element and store in array a
        for (int i = 0; i < n; i++)
            a[i] = i * arr[i];

        // Iterate over the array from right to left to find pairs
        for (int i = n - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                // If i*arr[i] is greater than j*arr[j], increment the count of pairs
                if (a[j] > a[i])
                    ans++;
            }
        }

        return ans;
    }

    // Main method to demonstrate the function
   
}

