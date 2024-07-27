public class Main {
    public static void main(String[] args) {
        AVL newAVL = new AVL();
        newAVL.insert(70);
        newAVL.insert(50);
        newAVL.insert(30);
        newAVL.insert(60);   
        newAVL.insert(20);
        newAVL.insert(40);
        newAVL.insert(90);
        newAVL.insert(80);
        newAVL.insert(100);
        System.out.println("\n before deletion : ");
        newAVL.levels();
        newAVL.delete(40);
        System.out.println("\n after deletion : ");
        newAVL.levels();
}
}
