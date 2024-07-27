import java.util.ArrayList;

public class AdjacencyMatrix {
    ArrayList<GraphNode> nodeList;
    int [][] adjacencyMatrix;

    public AdjacencyMatrix(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j){
       adjacencyMatrix[i][j] = 1;
       adjacencyMatrix[j][i] = 1;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("  ");

        for(int i = 0; i<nodeList.size(); i++)
            s.append(nodeList.get(i).name + " ");
        
        s.append("\n");

        for(int i = 0; i<nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
            for(int j = 0; j<nodeList.size(); j++) {
                s.append(adjacencyMatrix[i][j] + " ");
            }
            s.append("\n");
        }

        return s.toString();
    }
}
