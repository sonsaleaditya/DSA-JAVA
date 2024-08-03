public class Matrix_Chain_Recurse {
    public static void main(String[] args) {
        int arr[] = {20,35,46,22};
        System.out.println(solve(arr, 1, arr.length-1));
    }

    static int solve(int arr[],int i,int j){
        int min = Integer.MAX_VALUE, temp = 0
        ;
        if(i>=j){
            return 0;
        }

        for(int k =i;k<j;k++){
            temp = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min,temp);

        }

        return min;
    }
}
