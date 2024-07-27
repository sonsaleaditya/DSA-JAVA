public class ReverseBit {
    public static void main(String[] args) {
       Solution obj = new Solution();
    System.out.println( obj.reversedBits(1L));
      
    }
}

class Solution {
    static Long reversedBits(Long x) {
        // Reverse the bits
        long reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed = (reversed << 1) | (x& 1); // Shift the reversed number left and add the last bit of num
            x = x >> 1; // Shift num to the right
        }
        
        // Output the result
       //// System.out.println("Reversed bits: " + Long.toBinaryString(reversed));
        ////System.out.println("Decimal value of reversed bits: " + reversed);
        return reversed;
    }
};