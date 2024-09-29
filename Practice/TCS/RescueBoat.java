/*
 * Problem Statement:
 * 
 * You are given an array `weights[]` where each element represents the weight of a person, and a limit `limit` representing the maximum capacity of a boat. Each boat can carry at most two people at the same time, provided their combined weight does not exceed the boat's limit.
 * 
 * Your task is to determine the minimum number of boats required to rescue all the people.
 * 
 * Example:
 * 
 * Input:
 * weights[] = { 1, 2, 3, 4, 5, 6, 7 }
 * limit = 3
 * 
 * Output:
 * 5
 * 
 * Explanation:
 * The optimal way is to pair people with weights 1 & 2, 3 & 4, 5 & 6 in separate boats.
 * The person with weight 7 will need a separate boat.
 * Therefore, the total number of boats required is 5.
 * 
 */

 import java.util.Arrays;

 public class RescueBoat {
     public static void main(String[] args) {
         int weights[] = { 1, 2, 3, 4, 5, 6, 7 };
         int limit = 3;
 
         // Weights of people and limit is the capacity that the boat can load
         System.out.println(rescue(weights, limit)); // Expected output: 5
     }
 
     static int rescue(int arr[], int limit) {
         // Sort the array to pair the lightest and heaviest person
         Arrays.sort(arr);
 
         int s = 0, e = arr.length - 1, count = 0;
 
         // Use two pointers: one at the start (lightest) and one at the end (heaviest)
         while (s <= e) {
             // If the lightest and heaviest person can share a boat
             if (arr[s] + arr[e] <= limit) {
                 count++; // One boat used
                 s++; // Move the pointer to the next lightest person
                 e--; // Move the pointer to the next heaviest person
             } else {
                 // If the heaviest person can't share the boat, they need a separate one
                 e--; // Heaviest person goes alone
                 count++; // One boat used
             }
         }
 
         return count; // Return the total number of boats required
     }
 }
 