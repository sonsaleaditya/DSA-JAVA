import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
public class Kruskal {

    // Function to find the parent of a node with path compression
    static int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }

    // Function to perform union of two sets
    static void unionSet(int u, int v, int[] parent, int[] rank) {
        u = findParent(parent, u);
        v = findParent(parent, v);

        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    // Function to initialize the sets
    static void makeSet(int[] parent, int[] rank, int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Function to find the weight of the minimum spanning tree
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        // Sort the edges based on their weight using a lambda expression
        Collections.sort(edges, (edge1, edge2) -> edge1.get(2) - edge2.get(2));

        // Initialize the parent and rank arrays
        int[] parent = new int[n];
        int[] rank = new int[n];
        makeSet(parent, rank, n);

        int minWeight = 0;

        // Iterate over the edges and add them to the MST if they don't form a cycle
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            int parentU = findParent(parent, u);
            int parentV = findParent(parent, v);

            if (parentU != parentV) {
                minWeight += wt;
                unionSet(parentU, parentV, parent, rank);
            }
        }

        return minWeight;
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        
        // Add edges (u, v, weight)
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 10)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2, 6)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 15)));
        edges.add(new ArrayList<>(Arrays.asList(2, 3, 4)));

        int n = 4; // Number of vertices

        // Find and print the weight of the minimum spanning tree
        int mstWeight = minimumSpanningTree(edges, n);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }
}
