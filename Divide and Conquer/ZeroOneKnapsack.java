public class ZeroOneKnapsack {
    public static void main(String[] args) {
        // Define the profits and weights arrays
        int profits[] = {31, 26, 17, 72};
        int weights[] = {3, 1, 2, 5};
        int capacity = 7;

        // Call the zeroOneKnapsack function and print the maximum profit
        System.out.println("Maximum profit is: " + zeroOneKnapsack(weights, profits, capacity, 0));
    }

    /**
     * A recursive function to solve the 0/1 Knapsack problem.
     * 
     * @param weights       Array of weights of the items
     * @param profits       Array of profits of the items
     * @param capacity      Capacity of the knapsack
     * @param currentIndex  Current index in the arrays
     * @return              Maximum profit that can be obtained
     */
    static int zeroOneKnapsack(int weights[], int profits[], int capacity, int currentIndex) {
        // Base case: if capacity is 0 or we have considered all items
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }

        // Initialize profit1
        int profit1 = 0;

        // If the current item can be included in the knapsack
        if (weights[currentIndex] <= capacity) {
            // Calculate the profit including the current item
            profit1 = profits[currentIndex] + zeroOneKnapsack(weights, profits, capacity - weights[currentIndex], currentIndex + 1);
        }

        // Calculate the profit excluding the current item
        int profit2 = zeroOneKnapsack(weights, profits, capacity, currentIndex + 1);

        // Return the maximum of the two profits
        return Math.max(profit1, profit2);
    }
}
