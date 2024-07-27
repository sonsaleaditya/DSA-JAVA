import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int [][] neighbours;
    TopologicalSort(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        neighbours = new int[nodeList.size()][nodeList.size()];
    }


    void addDirectedEdge(int i, int j) {
        neighbours[i][j]=1;
    }

    ArrayList<GraphNode> getNeghbours(GraphNode node){
        ArrayList<GraphNode> arr = new ArrayList<>();
        int i = node.index;
        for(int j = 0;j<nodeList.size();j++){
            if(neighbours[i][j]==1)
                arr.add(nodeList.get(j));
        }
        return arr;
    }

     void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        int i = node.index;
        ArrayList<GraphNode> neighbors = getNeghbours(node);
        for(GraphNode n : neighbors){
            if(!n.isVisited)
                topologicalVisit(n,stack);
        }
       node.isVisited = true;
       stack.push(node);
    }

void topologicalSort(){
    Stack<GraphNode> stack = new Stack<>();
    for(GraphNode node : nodeList)
    {
            if(!node.isVisited)
            {
                topologicalVisit(node,stack);
            }
    }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().name + " " );
        }

}

    public static void main(String[] args) {

        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode(0, "A"));
        nodeList.add(new GraphNode(1, "B"));
        nodeList.add(new GraphNode(2, "C"));
        nodeList.add(new GraphNode(3, "D"));
        nodeList.add(new GraphNode(4, "E"));
        nodeList.add(new GraphNode(5, "H"));
        nodeList.add(new GraphNode(6, "F"));
        nodeList.add(new GraphNode(7, "G"));
       


        TopologicalSort g = new TopologicalSort(nodeList);
        //A ->C
        g.addDirectedEdge(0, 2);

        //B->C , B->D
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(1, 3);

        //C->E
        g.addDirectedEdge(2, 4);

        //D->F
        g.addDirectedEdge(3, 6);

        //E->H, E->F
        g.addDirectedEdge(4, 5);
        g.addDirectedEdge(4, 6);

        //F->G
        g.addDirectedEdge(6, 7);

       

       
        g.topologicalSort();
        // g.printGraph();

    }

}

class GraphNode {
    boolean isVisited = false;
    int index;
    String name;
    GraphNode(int index, String name) {
        this.index = index;
        this.name = name;
    }
}