import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MatchNutBolt {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int n = 5;
        char nuts[] = {'@', '%', '$', '#', '^'};
        char bolts[] = {'%', '@', '#', '$', '^'};
        obj.matchPairs(n, nuts, bolts);
        for (int i = 0; i < nuts.length; i++) {
            System.out.print(nuts[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < bolts.length; i++) {
            System.out.print(bolts[i] + " ");
        }
    }
}

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
         Character[] predefinedOrder = {'!', '#', '$', '%', '&', '*', '?', '@', '^'};
       ArrayList<Character> ideal = new ArrayList<>(Arrays.asList(predefinedOrder));
        
        ArrayList<Character> nutList = new ArrayList<>();
        ArrayList<Character> boltList = new ArrayList<>();
        
        for (char nut : nuts) {
            nutList.add(nut);
        }
        
        for (char bolt : bolts) {
            boltList.add(bolt);
        }
        int indx = 0;
        for(int i = 0;i<ideal.size();i++){
            if(nutList.contains(ideal.get(i)) && boltList.contains(ideal.get(i))){
                bolts[indx] = ideal.get(i);
                nuts[indx] = ideal.get(i);
                indx++;
            }
        }
    }
}