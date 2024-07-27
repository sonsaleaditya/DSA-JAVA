public class CountNumberWith4 {
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.countNumberswith4(61));
    }
}

//15

class Solution {
    public static int countNumberswith4(int n) {
        int count = 0;
        for(int i = 4 ; i<=n;i++){
            if(helper(i))
            {
                count++;
            }
        }
        return count;
    }

    static boolean helper(int n ){
        while(n>0){
            int rem = n%10;
            n = n/10;
            if(rem == 4){
                return true;
            }
        }
        return false;
    }
}
