public class TrappedRainWater {

    /*
     * Problem Statement:
     * Given an array of non-negative integers representing the height of bars where the width of each bar is 1,
     * compute how much water it can trap after raining.
     *
     * Example:
     * Input: arr[] = {3, 0, 0, 2, 0, 4}
     * Output: 10 litre
     *
     * Explanation:
     * The structure of the bars looks like:
     *       |
     *   |   | 
     *   |   |       |
     * ------------
     * After raining, water is trapped in the valleys between the bars. 
     * The total water trapped is 10 litres.
     */

    public static void main(String[] args) {
        int arr[] = {3, 0, 0, 2, 0, 4};
        System.out.println("Trapped water: " + trappedWater(arr) + " litre");
    }

    static int trappedWater(int arr[]) {
        if (arr.length <= 2) return 0;

        int l = 0, r = arr.length - 1, leftMax = 0, rightMax = 0, water = 0;

        while (l <= r) {
            if (arr[l] < arr[r]) {
                if (arr[l] > leftMax) {
                    leftMax = arr[l];
                } else {
                    water += leftMax - arr[l];
                }
                l++;
            } else {
                if (arr[r] > rightMax) {
                    rightMax = arr[r];
                } else {
                    water += rightMax - arr[r];
                }
                r--;
            }
        }
        return water;
    }
}
