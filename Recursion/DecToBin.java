public class DecToBin {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("bin of "+n+" is : "+calDecTOBin(n));
    }

   static int calDecTOBin(int n){
        if(n==0){
            return 0;
        }
        return n % 2 + 10*(calDecTOBin(n/2));
    }
}
