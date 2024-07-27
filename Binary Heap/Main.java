public class Main {
    public static void main(String[] args) {
        //BinaryHeap bh = new BinaryHeap(5);
        // bh.peek();
        // System.out.println(bh.size());
        // bh.insert(50);
        // bh.insert(52);
        // bh.insert(54);
        // bh.insert(56);
        // bh.insert(57);
        // bh.levelOrder();
        // bh.delete();
        int arr[] = {-1, 54, 53, 55, 52, 50};
        BinaryHeap bh = new BinaryHeap(arr);
        bh.heapify(1);
        bh.levelOrder();
    }
}
