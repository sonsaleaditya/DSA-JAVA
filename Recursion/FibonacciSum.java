public class FibonacciSum {
   public static void main(String[] args) {
    long n = 777;
       //System.out.println(fibSum(n));
      System.out.println("sum : " + fibo(n));
   } 

   static long result = 1;

   static long fibSum(long N){
    int k = 1000000007;
    for(long i=1;i<=N;i++){
       // System.out.println(fib(i));
       result+=fib(i);
    }
        return result % k;
   }

   static long fib(Long N){
    if(N==1 || N==0){
        return N;
    }
    result = fib(N-2) + fib(N-1);
      return result;
   }

   static long fibo(long N){
    
        if (N == 0) {
            return 0;
        }

        long a = 0;
        long b = 1;
        long result = 1;

        for (long i = 2; i <= N; i++) {
            long sum = (a + b) % 1000000007;
            a = b;
            b = sum;
            result = (result + sum) % 1000000007;
        }

        return result;
    }

}

