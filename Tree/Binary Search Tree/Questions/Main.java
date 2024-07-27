public class Main {
    public static void main(String[] args) {
        LowestCommanAncestor lca = new LowestCommanAncestor();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.right.right = new Node(6);
        Node temp = lca.lca(root,4,6);
        System.out.println(temp.data);
}


}

