public class SumOfDigit {
    public static void main(String[] args) {
        SumOfDigit s = new SumOfDigit();
        System.out.println(s.sumOfDigit(18));
    }
    int sumOfDigit(int n){
        if(n<10){
            return n;
        }
        return sumOfDigit(n/10)+n%10;
    }
}
