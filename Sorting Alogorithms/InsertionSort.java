public class InsertionSort {

    void insertionSort(int arr[]){
        int n = arr.length;
        for(int i = 1; i<n;i++){
            int  j = i, temp = arr[j];
            while(j>0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
    }

    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        int arr[]={4,2,5,6,3,1};
        System.out.println("element before sorting : ");
        for(int k : arr)
            System.out.print(k + " ");

        obj.insertionSort(arr);

        System.out.println("\nelement after sorting : ");
        for(int k : arr)
            System.out.print(k + " ");
    }
    
}
