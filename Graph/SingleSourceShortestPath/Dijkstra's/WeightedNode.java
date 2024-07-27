import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode>{
        public ArrayList<WeightedNode> neighbors = new ArrayList<>();
        public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
        public boolean isVisited = false;
        public WeightedNode parent;
        public int distance;
        public int  index;
        public String name;

        public WeightedNode(String name, int index){
            this.name = name;
            this.index = index;
            distance = Integer.MAX_VALUE;
        }
        
        
        @Override
        public String toString(){
            return name;
        }

        @Override 
        public int CompareTo(WeightedNode o){
            return this.distance - o.distance;
        }

}