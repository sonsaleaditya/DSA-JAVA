import java.util.*;

public class IsCircle {
    public static void main(String[] args) {
        String arr[] = {"abc", "bcd", "cdf"};
        String arr1[] = {"for", "geek", "rig", "kaf"};
        String arr2[] = {"abc", "cba", "klm", "mlk"};
        Solution obj = new Solution();
        System.out.println(obj.isCircle(arr));  // Output: 0
        System.out.println(obj.isCircle(arr1)); // Output: 1
        System.out.println(obj.isCircle(arr2)); // Output: 1
    }
}

class Solution {
    public int isCircle(String arr[]) {
        int n = arr.length;

        // Step 1: Create graph (adjacency list) and arrays to store in-degrees and out-degrees
        Map<Character, List<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];
        
        // Step 2: Populate the graph and degrees
        for (String s : arr) {
            char firstChar = s.charAt(0);
            char lastChar = s.charAt(s.length() - 1);
            outDegree[firstChar - 'a']++;
            inDegree[lastChar - 'a']++;
            
            // Add the directed edge from firstChar to lastChar
            graph.putIfAbsent(firstChar, new ArrayList<>());
            graph.get(firstChar).add(lastChar);
        }

        // Step 3: Check if in-degrees and out-degrees match for each character
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0; // If any character has mismatched in/out degree, it's not possible to form a circle
            }
        }

        // Step 4: Check if all characters form a single connected component (can reach each other)
        boolean[] visited = new boolean[26];
        char start = arr[0].charAt(0); // Start from the first character of the first string
        dfs(start, graph, visited);

        // Ensure all characters that have non-zero in/out degree are visited
        for (int i = 0; i < 26; i++) {
            if ((inDegree[i] > 0 || outDegree[i] > 0) && !visited[i]) {
                return 0; // If any character with a degree is not visited, the graph is disconnected
            }
        }

        return 1; // All checks passed, the strings can form a circle
    }

    private void dfs(char node, Map<Character, List<Character>> graph, boolean[] visited) {
        visited[node - 'a'] = true;
        if (graph.containsKey(node)) {
            for (char neighbor : graph.get(node)) {
                if (!visited[neighbor - 'a']) {
                    dfs(neighbor, graph, visited);
                }
            }
        }
    }
}
//// provide me code for , which takes decimal dotted ip address and give its network address 