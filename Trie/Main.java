public class Main {
    public static void main(String[] args) {
        Trie t = new Trie(); 
        t.insert("adit");
        t.insert("aditya");
        System.out.println(t.search("adit"));
        t.delete("adit");
    
    }
}
