public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int n = arr.length;
        for (int k : reverse(arr, n)) {
            System.out.print(k + " ");
        }
    }
    
    static int[] reverse(int arr[], int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }
        return arr;
    }

}
