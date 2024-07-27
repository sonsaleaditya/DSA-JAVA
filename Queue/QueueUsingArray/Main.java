public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.display();
        q.dequeue();
        q.dequeue();
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(1);
        q.display();
    }
}
