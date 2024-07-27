import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

 class BFS {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode(0, "A"));
        nodeList.add(new GraphNode(1, "B"));
        nodeList.add(new GraphNode(2, "C"));
        nodeList.add(new GraphNode(3, "D"));
        nodeList.add(new GraphNode(4, "E"));
        nodeList.add(new GraphNode(5, "F"));
        nodeList.add(new GraphNode(6, "G"));

        Graph g = new Graph(nodeList);
        //A-B , A-C
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);

        //B-D , B-G
        g.addUndirectedEdge(1, 3);
        g.addUndirectedEdge(1, 6);

        //C-D , C-E
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(2, 4);

        //D-F 
        g.addUndirectedEdge(3, 5);

        //E-F

        g.addUndirectedEdge(4, 5);

        //F-G
        g.addUndirectedEdge(5, 6);

        g.bfs(nodeList.get(0));
        // g.printGraph();

    }
}

class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public static void pathPrint(GraphNode node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }


    public void bfs(GraphNode node){
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            GraphNode currNode = q.remove();
            currNode.isVisited = true;
            System.out.print("printing path for node "+ currNode.name + " : ");
            pathPrint(currNode);
            System.out.println();
             for(GraphNode neighbor : currNode.neighbours){
                if(!neighbor.isVisited){
                    neighbor.parent = currNode;
                    q.add(neighbor);
                    neighbor.isVisited = true;
                }
             }
        }



    }

}


class GraphNode {
    boolean isVisited = false;
    int index;
    String name;
    GraphNode parent;
    ArrayList<GraphNode> neighbours;

    GraphNode(int index, String name) {
        this.index = index;
        this.name = name;
        neighbours = new ArrayList<>();
    }
}
