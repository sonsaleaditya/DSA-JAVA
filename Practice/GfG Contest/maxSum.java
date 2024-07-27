

import java.util.ArrayList;
import java.util.Collections;

public class maxSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSum(10, 2));  // Expected output: 10
        System.out.println(solution.maximumSum(5, 2));   // Expected output: -1
        System.out.println(solution.maximumSum(15, 3));  // Additional test case
    }
}


class Solution {
    public static long maximumSum(int n, int k) {
        ArrayList<Integer> oddNonPrimes = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (isOddNonPrime(i)) {
                oddNonPrimes.add(i);
            }
        }
        
        if (oddNonPrimes.size() < k) {
            return -1;
        }
        
        Collections.sort(oddNonPrimes, Collections.reverseOrder());
        long sum = 0;
        
        for (int i = 0; i < k; i++) {
            sum += oddNonPrimes.get(i);
        }
        
        return sum;
    }

    private static boolean isOddNonPrime(int num) {
        if (num % 2 == 0) return false;  // Not odd
        if (num == 1) return true;       // 1 is not prime
        if (num == 3) return false;      // 3 is prime
        return !isPrime(num);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    
}
