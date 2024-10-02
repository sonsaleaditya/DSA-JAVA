public class BinarySearchApplication {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int target = 7;
        
        System.out.println(bs(arr, target));
        int arr1[] = {1,2,3,4,5,3,2,1};
        System.out.println(peakElement(arr1));
    }

    static int bs(int arr[], int target){
        int l = 0, r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==target) return mid;

            if(arr[mid]<target){
                l = mid+1;
            }else{
                r = mid-1;

            }
        }

        return -1;
    }

   static int peakElement(int arr[]){
        int l = 1, r = arr.length-2;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return arr[mid];
            }else if(arr[mid] > arr[mid-1]){
                // we need to move right because it is nin increasing order
                l = mid+1;
            }else{
                r = mid -1;
            }
        }

        return -1;
    }
}

