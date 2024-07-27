import java.util.*;
public class Prims {
    public static void main(String[] args) {
        // Sample input
        int n = 5; // Number of vertices
        int m = 6; // Number of edges
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        g.add(new ArrayList<>(Arrays.asList(1, 2, 2)));
        g.add(new ArrayList<>(Arrays.asList(1, 3, 3)));
        g.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        g.add(new ArrayList<>(Arrays.asList(2, 4, 4)));
        g.add(new ArrayList<>(Arrays.asList(3, 4, 5)));
        g.add(new ArrayList<>(Arrays.asList(4, 5, 7)));

        // Calculate MST
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> mst = s.calculatePrimsMST(n, m, g);

        // Print the result
        System.out.println("The edges in the MST are:");
        for (ArrayList<Integer> edge : mst) {
            System.out.println(edge.get(0) + " - " + edge.get(1) + " with weight " + edge.get(2));
        }
}
}



// Custom Pair class to hold node and weight
class Pair {
    int node, weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

- class Solution {
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        // Create adjacency list
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i + 1, new ArrayList<>());
        }
        
        // Fill the adjacency list with edges
        for (ArrayList<Integer> edge : g) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int[] key = new int[n + 1];        // Array to store the minimum weight to add each vertex to the MST
        boolean[] mst = new boolean[n + 1]; // Array to keep track of vertices included in MST
        int[] parent = new int[n + 1];      // Array to store the MST structure

        // Initialize arrays
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mst, false);
        Arrays.fill(parent, -1);

        key[1] = 0; // Start with the first vertex
        parent[1] = -1;

        // Prim's Algorithm
        for (int i = 1; i < n; i++) {
            int mini = Integer.MAX_VALUE;
            int u = -1;

            // Pick the minimum key vertex from the set of vertices not yet included in MST
            for (int v = 1; v <= n; v++) {
                if (!mst[v] && key[v] < mini) {
                    mini = key[v];
                    u = v;
                }
            }

            mst[u] = true; // Add the picked vertex to the MST set

            // Update key value and parent index of the adjacent vertices of the picked vertex
            for (Pair it : adj.get(u)) {
                int v = it.node;
                int w = it.weight;
                if (!mst[v] && w < key[v]) {
                    parent[v] = u;
                    key[v] = w;
                }
            }
        }

        // Construct the result as an ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(parent[i]);
            edge.add(i);
            edge.add(key[i]);
            result.add(edge);
        }
        return result;
    }

    
}

