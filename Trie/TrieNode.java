import java.util.HashMap;
import java.util.Map;
public class TrieNode {
    Map<Character, TrieNode> child;

    boolean endOfString;
    TrieNode(){
        child = new HashMap<>();
        endOfString = false;
    }
}
