import java.util.*;
public class Main {
    public static void main(String[] args) {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();
        // ArrayList<WeightedNode> nodeList = new ArrayList<>();
                nodeList.add(new WeightedNode(0, "A"));
                nodeList.add(new WeightedNode(1, "B"));
                nodeList.add(new WeightedNode(2, "C"));
                nodeList.add(new WeightedNode(3, "D"));
                nodeList.add(new WeightedNode(4, "E"));
                nodeList.add(new WeightedNode(5, "F"));
                nodeList.add(new WeightedNode(6, "G"));
        
               WeightedGraph g = new WeightedGraph(nodeList);
                //A-B , A-C
                g.addWeightedEdge(0, 1,2);
                g.addWeightedEdge(0, 2,5);
              
                //B-C , B-D , B-E
                g.addWeightedEdge(1,2,6);
                g.addWeightedEdge(1, 3,1);
                g.addWeightedEdge(1, 4,3);
        
                //C-F
                g.addWeightedEdge(2, 5,8);
               
        
                //D-E
                g.addWeightedEdge(3, 4,4);
        
                //E-G
        
                g.addWeightedEdge(4, 6,9);
        
                //F-G
                g.addWeightedEdge(5, 6,7);
        
              //  g.bfs(nodeList.get(0));
                // g.printGraph();
                System.out.println("printing Dijkasta's From Source A : ");
                g.dijkstra(nodeList.get(0));
    }
}
