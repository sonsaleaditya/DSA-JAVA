public class PrintSubset {
    public static void main(String[] args) {
        StringBuilder ip = new StringBuilder("abc"); // Input string
        StringBuilder op = new StringBuilder(); // Output string for storing subsets

        // Call the solve method to print all subsets
        solve(ip, op);
    }

    /**
     * Recursive method to generate and print all subsets of a given string.
     * @param ip - The input string (or the remaining part of it).
     * @param op - The output string that accumulates the characters for each subset.
     */
    static void solve(StringBuilder ip, StringBuilder op) {
        // Base case: If the input string is empty, print the accumulated output
        if (ip.length() == 0) {
            System.out.println(op.toString());
            return;
        }

        // Create two new output strings to explore both possibilities (including or excluding a character)
        StringBuilder op1 = new StringBuilder(op); // Option 1: Exclude the current character
        StringBuilder op2 = new StringBuilder(op); // Option 2: Include the current character

        // Include the first character of ip in op2
        op2.append(ip.charAt(0));

        // Remove the first character from ip to reduce the problem size
        ip.deleteCharAt(0);

        // Recursively solve for the remaining string with both options
        solve(ip, op1); // Exclude the current character
        solve(ip, op2); // Include the current character

        // Backtrack: Add the removed character back to ip (to restore the original state)
        ip.insert(0, op2.charAt(op2.length() - 1));
    }
}
