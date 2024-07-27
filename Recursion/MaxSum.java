public class MaxSum {

    public int maxSum(int n) {
        if (n <= 0) {
            return 0;
        }

        int nb2 = maxSum(n / 2);
        int nb3 = maxSum(n / 3);
        int nb4 = maxSum(n / 4);

        int currentSum = nb2 + nb3 + nb4;

        return Math.max(n, currentSum);
    }

    public static void main(String[] args) {
        MaxSum m = new MaxSum();
        System.out.println(m.maxSum(1200));
    }
}
