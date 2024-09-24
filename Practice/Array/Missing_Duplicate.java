/*
Problem Statement:
Given an array of size `n`, where elements are in the range from 1 to `n`. 
One element in the array is missing and one element is repeated. 
The task is to find the missing number and the duplicate number.

Example:
Input: arr[] = {1, 3, 3}
Output: Duplicate = 3, Missing = 2

Explanation:
In the array, 3 is repeated and 2 is missing.

Input/Output:

Input:
arr[] = {1, 3, 3}

Output:
[3, 2]  // Duplicate = 3, Missing = 2
*/

public class Missing_Duplicate {
    public static void main(String[] args) {
        int arr[] = {1, 3, 3};  // Test case: input array
        int result[] = findTwoElement(arr);  // Call function to find duplicate and missing
        System.out.println("Duplicate = " + result[0] + ", Missing = " + result[1]);  // Print the result
    }

    // Function to find the duplicate and missing numbers
    static int[] findTwoElement(int arr[]) {
        int n  = arr.length;  // Get the length of the array
        int result[] = new int[2];  // Array to store the duplicate and missing values
        
        // First pass: Find the duplicate element
        for(int i = 0; i < n; i++) {
            int indx = Math.abs(arr[i]);  // Get the absolute value of the current element
            if(arr[indx - 1] < 0) {  // If the value at this index is already negative, it means this is the duplicate
               result[0] = indx;  // Store the duplicate element
            } else {
               arr[indx - 1] *= -1;  // Otherwise, mark the element by making it negative
            }
        }
        
        // Second pass: Find the missing element
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {  // If the element is positive, this index + 1 is the missing number
                result[1] = i + 1;  // Store the missing element
                break;
            }
        }
        
        return result;  // Return the result array containing the duplicate and missing elements
    }
}
