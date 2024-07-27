/*Given an array arr[] denoting heights of N towers and a positive integer K.

For each tower, you must perform exactly one of the following operations exactly once.

Increase the height of the tower by K
Decrease the height of the tower by K
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.
Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

Example 1:

Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5 
*/
public class MaxMinDif {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int k = 1;
        int n = 4;
        int arr[] = { 7, 7, 3, 5 };
        obj.getMinDiff(arr, n, k);
    }
}

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - k < 0) {
                arr[i] += k;
            } else {
                arr[i] -= k;
            }

            if (min > arr[i]) {
                min = arr[i];
            }

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        return (max - min);
    }
}
