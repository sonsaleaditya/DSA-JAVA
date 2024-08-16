/*
Problem Statement:
Given a boolean expression consisting of symbols 'T' (True), 'F' (False), '&' (AND), '|' (OR), and '^' (XOR), count the number of ways to parenthesize the expression such that it evaluates to true.

Input:
str = "T|T&F^T"

Output:
Number of ways to evaluate to true: 4

Explanation:
The expression can be evaluated to true in the following ways:
1. (T|(T&(F^T))) = T
2. ((T|T)&(F^T)) = T
3. ((T|(T&F))^T) = T
4. (T|((T&F)^T)) = T
*/

public class Evaluate_Expression_To_True {
    public static void main(String[] args) {
        String expression = "T^F|F";
        int ways = solve(expression, 0, expression.length() - 1, true);
        System.out.println("Number of ways to evaluate to true: " + ways);
    }

    static int solve(String str, int i, int j, boolean isTrue) {
        // Base case: if the substring is invalid
        if (i > j) {
            return 0;
        }

        // Base case: if the substring is a single character
        if (i == j) {
            if (isTrue) {
                return str.charAt(i) == 'T' ? 1 : 0;
            } else {
                return str.charAt(i) == 'F' ? 1 : 0;
            }
        }

        int ans = 0;

        // Iterate over the expression
        for (int k = i + 1; k < j; k += 2) {
            char operator = str.charAt(k);

            // Recur for left and right subexpressions
            int lT = solve(str, i, k - 1, true);
            int lF = solve(str, i, k - 1, false);
            int rT = solve(str, k + 1, j, true);
            int rF = solve(str, k + 1, j, false);

            // Combine the results based on the operator
            if (operator == '&') {
                if (isTrue) {
                    ans += lT * rT; // Both subexpressions must be true for AND
                } else {
                    ans += lF * rT + rF * lT + lF * rF; // Any one or both subexpressions must be false for AND
                }
            } else if (operator == '|') {
                if (isTrue) {
                    ans += lT * rT + lT * rF + rT * lF; // Any one or both subexpressions must be true for OR
                } else {
                    ans += lF * rF; // Both subexpressions must be false for OR
                }
            } else if (operator == '^') {
                if (isTrue) {
                    ans += lT * rF + lF * rT; // One subexpression must be true and the other must be false for XOR
                } else {
                    ans += lT * rT + lF * rF; // Both subexpressions must be the same for XOR
                }
            }
        }

        return ans;
    }
}
