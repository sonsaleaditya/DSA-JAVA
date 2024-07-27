import java.util.*;

public class Graph {
    public static void main(String[] args) {
        ArrayList<GraphNode> arr = new ArrayList<>();
        arr.add(new GraphNode(0, "A"));
        arr.add(new GraphNode(1, "B"));
        arr.add(new GraphNode(2, "C"));
        arr.add(new GraphNode(3, "D"));
        arr.add(new GraphNode(4, "E"));

        AdjacencyMatrix g = new AdjacencyMatrix(arr);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);

        //g.printGraph();

        g.bfs();
        
    }
}

class GraphNode {
    int index;
    String name;
    boolean isVisited;

    GraphNode(int index, String name) {
        this.index = index;
        this.name = name;
        isVisited = false;
    }
}

class AdjacencyMatrix {
    int adjacencyMatrix[][];
    ArrayList<GraphNode> nodeList;

    AdjacencyMatrix(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    void printGraph() {
        System.out.print("  ");
        for (GraphNode g : nodeList) {
            System.out.print(g.name + " ");
        }
        System.out.println();

        for (int i = 0; i < nodeList.size(); i++) {
            System.out.print(nodeList.get(i).name + " ");
            for (int j = 0; j < nodeList.size(); j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<GraphNode> getNeighbours(GraphNode node)
    {
        ArrayList<GraphNode> neighbours = new ArrayList<>();
        int nodeIndex = node.index;
        int size = adjacencyMatrix.length;

        for(int i = 0;i<size;i++){
            if(adjacencyMatrix[nodeIndex][i]==1){
                neighbours.add(nodeList.get(i));
            }
        }
    
    return neighbours;
    
    }

    void BfsVisit(GraphNode node){
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            GraphNode curr =  q.remove();
            System.out.print(curr.name + " ");
            curr.isVisited = true;
            ArrayList<GraphNode> neighbours = getNeighbours(curr);
            for(GraphNode v : neighbours){
                if(!v.isVisited){
                    v.isVisited = true;
                    q.add(v);

                }
            }
        }
    }

    void bfs(){

        for(GraphNode v : nodeList)
        {
            if(!v.isVisited){
                BfsVisit(v);
            }
        }
    }
}
