public class GrayToBin {
    public static void main(String[] args) {
        System.out.print("left shift 10<<1 is : ");
        System.out.println(10<<1);
        System.out.print("right shift 10>>1 is : " );
        System.out.println(10>>1);
        Solution obj = new Solution();
        System.out.println(obj.grayToBinary(15));
     
    }
}

class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        int mask = n;
        while ((mask >>= 1) != 0) {
            // right shift is , inserting 0 from left and remove last bit
            // left shift is inserting 0 from right and dont remove last bit 
            n ^= mask;
        }
        return n;
    }
       
}