import java.util.Scanner;

public class UniqueBooks {
    public static void main(String[] args) {
        System.out.println("Enter the number of books: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Number of books that won't repeat: " + factorialDerangements(n));
    }

    // Factorial-based approximation of derangements
    static int factorialDerangements(int n) {
        if (n == 1) return 0;  // Base case: 1 item can't be deranged.
        if (n == 2) return 1;  // Base case: Only 1 way to derange 2 items.

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        // Derangements formula: D(n) = n!/e (approximated)
        return (int)(Math.round(fact / Math.E));
    }
}


// import java.util.Scanner;

// public class UniqueBooks {
//     public static void main(String[] args) {
//         System.out.println("enter number of books : ");
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Number of books which wont repeat :  " + solve(sc.nextInt()));
//     }

//     static int solve(int n){
//         int dp[] = new int[n+1];
//         dp[0]=1;
//         dp[1]=0;

//         for(int i=2;i<=n;i++){
//             dp[i] = (i-1)*(dp[i-2]+dp[i-1]);
//         }

//         return dp[n];
//     }
// }
