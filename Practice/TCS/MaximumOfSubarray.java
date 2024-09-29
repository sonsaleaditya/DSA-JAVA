import java.util.ArrayList;

public class MaximumOfSubarray {
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};

        System.out.println(max_of_subarrays(3, arr));

    }

     static ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
       ArrayList<Integer> ans = new ArrayList<>();
       
       int s =0, e=0, n=arr.length;
       int max= Integer.MIN_VALUE;
       while(e<n){
            max = Math.max(max,arr[e]);
            if(e-s+1 == k){
                ans.add(max);
                s++;
            }
          
           e++;
       }
       
       return ans;
    }
}
