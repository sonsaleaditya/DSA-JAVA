public class Main {
    public static void main(String[] args) {
        LinearProbing obj = new LinearProbing(5);
        obj.insertKeys("ait");
        obj.insertKeys("adit");
        obj.insertKeys("aditya");
        obj.insertKeys("sonsale");
        obj.insertKeys("sggs");
        obj.insertKeys("iat");
        obj.deleteKeys("ait");
       // obj.displayKey();
    }
}
