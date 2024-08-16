import java.util.HashMap;
import java.util.Map;

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

public class Evaluate_Expression_To_True_Memoized {
    public static void main(String[] args) {
        String expression = "T|T&F^T";
        Map<String, Integer> map = new HashMap<>();
        int ways = mcm(expression, 0, expression.length() - 1, true, map);
        System.out.println("Number of ways to evaluate to true: " + ways);
    }

    static int mcm(String str, int i, int j, boolean isTrue, Map<String, Integer> map) {
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

        // Create a unique key for memoization
        String key = i + "" + j + "" + isTrue;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int ans = 0;

        // Iterate over the expression
        for (int k = i + 1; k < j; k += 2) {
            char operator = str.charAt(k);

            // Recur for left and right subexpressions
            int lT = mcm(str, i, k - 1, true, map);
            int lF = mcm(str, i, k - 1, false, map);
            int rT = mcm(str, k + 1, j, true, map);
            int rF = mcm(str, k + 1, j, false, map);

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

        // Memoize the result for the current substring and truth value
        map.put(key, ans);
        return ans;
    }
}
