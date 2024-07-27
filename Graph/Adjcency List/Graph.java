import java.util.ArrayList;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<>();

    Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;

    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    void printGraph(){
        for(int i = 0;i<nodeList.size();i++){
            System.out.print(nodeList.get(i).name + " -> ");
            for(GraphNode g : nodeList.get(i).neighbours)
                System.out.print(g.name + " ");
            System.out.println();
        }
            
    }

    
}
