public class SelectionSort {
    void selectionSort(int arr[]){
        int n = arr.length;
        
         boolean flag = false;
        for(int i = 0 ; i<n-1; i++){
           int minIndex = i;
            for(int j = i+1; j < n; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;            
        }
    }

    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        int arr[]={4,2,5,6,3,1};
        System.out.println("element before sorting : ");
        for(int k : arr)
            System.out.print(k + " ");

        obj.selectionSort(arr);

        System.out.println("\nelement after sorting : ");
        for(int k : arr)
            System.out.print(k + " ");
    }
}
