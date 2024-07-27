import java.util.*;
public class HeapSort {

    void heapify(int arr[], int N , int i ){
        int largest = i;
        int l = i*2+1;
        int r = i*2+2;
        System.out.println("L : " + l + " R : "+r + " Largest : "+largest);
        if(l<N && arr[l] > arr[largest]){
            largest = l;
        }
        if(r<N && arr[r]>arr[largest]){
            largest = r;
        }

        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i]=temp;
            System.out.println("Hapified Array Is : "+ Arrays.toString(arr));
            heapify(arr, N, largest);
        }
    }

    public void heapSort(int arr[]){
        int N = arr.length;

        for(int i = N/2-1 ; i>=0; i--){
            System.out.println("i : "+ i );
            heapify(arr, N, i);
        }
        System.out.println("Hapified Array Is : "+ Arrays.toString(arr));

        //storing root on first pos and swapping
        for(int i = N-1; i>0; i--){
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        int arr[] = {15,20,10,5,25};
        // 12,11,13,5,6,7
        // obj.heapSort(arr);
        // System.out.println("sorted Array Is : "+ Arrays.toString(arr));
        int N = arr.length;
        for(int i = N/2-1 ; i>=0; i--){
            System.out.println("i : "+ i );
            obj.heapify(arr, N, i);
        }
        System.out.println("Hapified Array Is : "+ Arrays.toString(arr));

    }
     
}