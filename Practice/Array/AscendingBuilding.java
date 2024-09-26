/**
 * AscendingBuilding
 */
public class AscendingBuilding {

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 2};
        Solution obj = new Solution();
        System.out.println(obj.maxStep(arr));
    }
}
class Solution {
    public int maxStep(int arr[]) {
        int e=0,count=0;
        int max = Integer.MIN_VALUE;
        
        while(e<arr.length-1){
            
                if(arr[e]<arr[e+1]){
                 //   System.out.println("i am here ");
                   count++;
                   max=Math.max(max,count); 
                }else{
                    
                    count=0;
                }
                
                e++;
        }
        
        return max;
    }
}