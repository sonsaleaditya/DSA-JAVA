import java.util.*;
/*n = 6, m = 5
a[] = {1, 2, 3, 4, 5, 10}
b[] = {2, 3, 1, 0, 5}

Output: 
4 10
Explanation: 
4 and 10 are present in first array, but not in second array.

int n  = 5, m = 5;
int a[] = {4, 3, 5, 9, 11};
int b[] = {4, 9, 3, 11, 10};

int n = 6, m= 8;
int a[] = {-9, -8, 4, -2, -9, -9};
int b[] = {-9 ,-4 ,-6, 5 ,-6 ,-6 ,1 ,4};

int n =7 , m= 6;
int a[] = {1 ,1 ,1 ,-6 ,7 ,6 ,-7};
int b[] = {-3 ,2, -8 ,9 ,-3, -9};
*/

public class FindMissing {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int n = 7, m = 6;
        int a[] = { 1, 1, 1, -6, 7, 6, -7 };
        int b[] = { -3, 2, -8, 9, -3, -9 };
        // obj.findMissing(a, b, n, m);
        ArrayList<Integer> arr = obj.findMissing(a, b, n, m);
        System.out.println(arr);
    }
}

class Solution {
    ArrayList<Integer> findMissing(int a[], int b[], int n, int m) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Fill array b into ArrayList
        ArrayList<Integer> bList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            bList.add(b[i]);
        }
        
        // Add elements from array a to result if they are not present in array b
        for (int i = 0; i < n; i++) {
            if (!bList.contains(a[i])) {
                result.add(a[i]);
            }
        }
        
        return result;
    }
}