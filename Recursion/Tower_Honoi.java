/**
 * Problem Statement:
 * Tower of Hanoi is a classical problem in which we have three rods (source, destination, and helper) and n disks of different sizes.
 * The objective is to move all the disks from the source rod to the destination rod following these rules:
 * 1. Only one disk can be moved at a time.
 * 2. A disk can only be moved if it is the top disk on a rod.
 * 3. No disk may be placed on top of a smaller disk.
 *
 * Input:
 * - n: The number of disks.
 * - s: The source rod (usually represented as 1).
 * - d: The destination rod (usually represented as 3).
 * - h: The helper rod (usually represented as 2).
 *
 * Output:
 * - The sequence of moves required to move all disks from the source to the destination rod.
 *
 * Example:
 * Input: n = 3, s = 1, d = 3, h = 2
 * Output:
 * moving plate 1 from 1 to 3
 * moving plate 2 from 1 to 2
 * moving plate 1 from 3 to 2
 * moving plate 3 from 1 to 3
 * moving plate 1 from 2 to 1
 * moving plate 2 from 2 to 3
 * moving plate 1 from 1 to 3
 */

 public class Tower_Honoi {
    public static void main(String[] args) {
        int n = 3; // Number of disks
        int s = 1; // Source rod
        int d = 3; // Destination rod
        int h = 2; // Helper rod

        // Call the solve method to print the sequence of moves
        solve(s, d, h, n);
    }

    /**
     * Solves the Tower of Hanoi problem.
     * @param s - The source rod.
     * @param d - The destination rod.
     * @param h - The helper rod.
     * @param n - The number of disks.
     */
    static void solve(int s, int d, int h, int n) {
        // Base case: Only one disk to move
        if (n == 1) {
            System.out.println("moving plate " + n + " from " + s + " to " + d);
            return;
        }

        // Recursive case: Move n-1 disks from source to helper using destination as a helper
        solve(s, h, d, n - 1);

        // Move the nth disk from source to destination
        System.out.println("moving plate " + n + " from " + s + " to " + d);

        // Move the n-1 disks from helper to destination using source as a helper
        solve(h, d, s, n - 1);
    }
}
