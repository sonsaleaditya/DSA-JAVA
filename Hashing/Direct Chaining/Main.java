public class Main {
    public static void main(String[] args) {
        DirectChaining obj = new DirectChaining(10);
        obj.insertKey("apple");
        obj.insertKey("banana");
        obj.insertKey("cat");
        obj.insertKey("dog");
        obj.insertKey("elephant");
        obj.insertKey("fish");
        obj.insertKey("gorilla");
        obj.insertKey("hippo");
        obj.insertKey("iguana");
        obj.insertKey("jaguar");
        obj.insertKey("adit");
        obj.insertKey("aditya");
        obj.insertKey("babarao");
        obj.insertKey("sonsale");
        obj.deleteKey("adit");
        obj.displayKeys();
        obj.search("aditya");
    }
}
