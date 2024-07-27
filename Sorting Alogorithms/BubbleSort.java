public class BubbleSort {
    void bubbleSort(int arr[]){
        int n = arr.length;
        boolean flag = false;
        for(int i = 0 ; i<n; i++){
            flag = false;
            for(int j=0; j<n-1; j++){
                if(arr[j]>arr[i]){
                    flag = true;
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }

            if(flag==false){
                return;
            }
            
        }
    }

    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();
        int arr[]={4,2,5,6,3,1};
        System.out.println("element before sorting : ");
        for(int k : arr)
            System.out.print(k + " ");

        obj.bubbleSort(arr);

        System.out.println("\nelement after sorting : ");
        for(int k : arr)
            System.out.print(k + " ");
    }
}
