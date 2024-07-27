import java.util.ArrayList;

public class GraphNode {
    String name;
    int index;
    boolean isVisited = false;
    ArrayList<GraphNode> neighbours = new ArrayList<>();
    GraphNode(int index, String name){
        this.index = index; this.name = name; 
    }
}
