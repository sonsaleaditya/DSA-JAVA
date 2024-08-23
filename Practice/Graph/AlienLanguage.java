import java.util.*;

/*
Problem Statement:
Given a sorted dictionary (array of words) of an alien language, find the order of characters in the alien language. The order of characters is determined based on the sorted order of words in the dictionary.

Input:
- dict: An array of strings representing words in the alien language.
- N: The number of words in the dictionary.
- K: The number of distinct characters in the alien language.

Output:
A string representing the order of characters in the alien language.

Explanation:
Given the sorted dictionary, the task is to derive the topological order of the characters. This order will represent the precedence of characters in the alien language.

Example:
Input: dict = ["baa", "abcd", "abca", "cab", "cad"], N = 5, K = 4
Output: "bdac"
Explanation: Based on the given dictionary:
- From "baa" and "abcd", we can infer that 'b' comes before 'a'.
- From "abcd" and "abca", we can infer that 'd' comes before 'c'.
- From "abca" and "cab", we can infer that 'a' comes before 'c'.
Thus, the correct character order is "bdac".
*/

class Solution {
    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> graph = new ArrayList<>(K);
        
        // Initialize graph with empty adjacency lists
        for (int i = 0; i < K; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph based on the order of characters in adjacent words
        for (int i = 0; i < N - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            
            int len = Math.min(word1.length(), word2.length());
            
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int from = word1.charAt(j) - 'a'; // Calculate index for character in word1
                    int to = word2.charAt(j) - 'a';   // Calculate index for character in word2
                    graph.get(from).add(to);          // Add directed edge from 'from' to 'to'
                    break;
                }
            }
        }
        
        // Arrays to track visited nodes and recursion stack
        boolean[] visited = new boolean[K];
        boolean[] recStack = new boolean[K];
        Stack<Integer> stack = new Stack<>();
        
        // Perform topological sort on each node
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                if (topologicalSort(i, graph, visited, recStack, stack)) {
                    return ""; // Return an empty string if a cycle is detected
                }
            }
        }
        
        // Build the order string from the topological sort stack
        StringBuilder order = new StringBuilder();
        while (!stack.isEmpty()) {
            order.append((char) (stack.pop() + 'a'));
        }
        
        return order.toString();
    }
    
    // Helper function to perform topological sort
    private boolean topologicalSort(int v, List<List<Integer>> graph, boolean[] visited, boolean[] recStack, Stack<Integer> stack) {
        visited[v] = true;
        recStack[v] = true;
        
        // Visit all adjacent vertices
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                if (topologicalSort(neighbor, graph, visited, recStack, stack)) {
                    return true; // Cycle detected
                }
            } else if (recStack[neighbor]) {
                return true; // Cycle detected
            }
        }
        
        recStack[v] = false; // Remove from recursion stack
        stack.push(v);       // Push current vertex to stack
        return false;
    }
}

public class AlienLanguage {
    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int N = dict.length;
        int K = 4; // Number of distinct characters in the alien language
        
        Solution sol = new Solution();
        String order = sol.findOrder(dict, N, K);
        
        System.out.println("The order of characters in the alien language is: " + order);
    }
}
