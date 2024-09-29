public class EfficiencyOfEmployee {
    public static void main(String[] args) {
        int arr[]= {3,-2,-8,4,1};
        System.out.println("efficiency is : "+calculateEfficience(arr));
    }   

    static int calculateEfficience(int arr[]){
        int ans = 0;
        int k = 3, s= 0, e=0, n = arr.length;
        int sum = 1;
        while(e<n){
            sum *= arr[e];
            if(e-s+1==k){
                ans = Math.max(ans, sum);
                sum /= arr[s];
                s++;
            }
            e++;
        }
        return ans;
    }
}

