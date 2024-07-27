import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    
    Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }

    void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    void printGraph() {
        for (int i = 0; i < nodeList.size(); i++) {
            System.out.print(nodeList.get(i).name + " -> ");
            for (GraphNode g : nodeList.get(i).neighbours)
                System.out.print(g.name + " ");
            System.out.println();
        }

    }

    void bfsVisited(GraphNode node){
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            GraphNode curr = q.remove();
            System.out.print(curr.name + " ");
            curr.isVisited = true;
            for(GraphNode v : curr.neighbours){
                if(!v.isVisited){
                     v.isVisited = true;
                     q.add(v);
                }
                   
            }
        }

    }
    
    void bfs(){
        for(GraphNode k : nodeList){
            if(!k.isVisited)
                bfsVisited(k);
    }
        }
           

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode(0, "A"));
        nodeList.add(new GraphNode(1, "B"));
        nodeList.add(new GraphNode(2, "C"));
        nodeList.add(new GraphNode(3, "D"));
        nodeList.add(new GraphNode(4, "E"));

        Graph g = new Graph(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.bfs();
        // g.printGraph();

    }

}

class GraphNode {
    boolean isVisited = false;
    int index;
    String name;
    ArrayList<GraphNode> neighbours;
    GraphNode(int index, String name) {
        this.index = index;
        this.name = name;
        neighbours = new ArrayList<>();
    }
}