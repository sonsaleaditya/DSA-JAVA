public class Gcd {
    public static void main(String[] args) {
       int a = 8, b = 3;
        System.out.println("gcd of "+a +" and " +b+ " is "+calGcd(a, b) );
    }

    static int calGcd(int a, int b){
        if(b==0){
            return a;
        }
        return calGcd(b, a%b);
    }
}
