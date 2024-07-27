public class BinarySearch {
    void binarySearch(int arr[], int k){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid]==k){
                System.out.println("found "+k+" at index : "+mid);
                return;
            }else if(k < arr[mid]){
                high = mid-1;
             
            }else {
                low = mid+1;
                
            }
        
        }
        System.out.println(k + " not found !!");
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        BinarySearch bs = new BinarySearch();
        bs.binarySearch(arr, 5);
    }
}
