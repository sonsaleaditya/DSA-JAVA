import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class First_Neg_ElementIn_K_Window {
    public static void main(String[] args) {
        Compute obj = new Compute();

        long A1[] = {-8, 2, 3, -6, 10};
        long[] result1 = obj.printFirstNegativeInteger(A1, A1.length, 2);
        for (long i : result1)
            System.out.print(i + " ");
        System.out.println();

        long A2[] = {12, -1, -7, 8, -15, 30, 16, 28};
        long[] result2 = obj.printFirstNegativeInteger(A2, A2.length, 3);
        for (long i : result2)
            System.out.print(i + " ");
        System.out.println();
    }
}

class Compute {

    /**
     * Finds the first negative integer in every window of size 'K' in the array.
     * 
     * @param A The input array
     * @param N The length of the array
     * @param K The size of the window
     * @return An array containing the first negative integer in each window
     */
    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        long[] arr = new long[N - K + 1];
        Queue<Integer> negativeIndices = new LinkedList<>();

        int s = 0, e = 0, indx = 0;
        
        // Iterate through the array
        while (e < N) {
            // If the current element is negative, add its index to the queue
            if (A[e] < 0) {
                negativeIndices.add(e);
            }

            // When the window size is reached
            if (e - s + 1 == K) {
                // Check if there's any negative integer in the current window
                if (!negativeIndices.isEmpty() && negativeIndices.peek() >= s) {
                    arr[indx] = A[negativeIndices.peek()];
                } else {
                    arr[indx] = 0;
                }

                // Slide the window
                if (!negativeIndices.isEmpty() && negativeIndices.peek() == s) {
                    negativeIndices.poll();
                }
                
                s++;
                indx++;
            }
            e++;
        }
        
        return arr;
    }
}
