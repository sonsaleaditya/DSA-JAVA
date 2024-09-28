import java.util.*;

public class PairShoes {
    public static void main(String[] args) {
        String[] arr = { "7L", "7R", "7L", "8L", "6R", "7R", "8R", "6R" };
        String[] arr2 = { "7L", "7R", "8R", "6R","10R","10L" };

        int totalPairs = 0;

        Map<String, Integer> leftShoes = new HashMap<>();

        Map<String, Integer> rightShoes = new HashMap<>();

        for(String s : arr2){
            String size = s.substring(0,s.length()-1);
            if(s.charAt(s.length()-1)=='L'){
                leftShoes.put(size,leftShoes.getOrDefault(size,0)+1);
            }else{
                rightShoes.put(size,rightShoes.getOrDefault(size,0)+1);
            }
        }
        System.out.println(leftShoes.keySet());
        System.out.println(rightShoes.keySet());

      for(String s : leftShoes.keySet()){
        if(rightShoes.containsKey(s)){
            totalPairs += Math.min(rightShoes.get(s),leftShoes.get(s));
        }
      }

        System.out.println("Total Pairs: " + totalPairs);
    }
}
