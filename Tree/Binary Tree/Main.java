public class Main {
    public static void main(String[] args) {
         //BinaryNode root = new BinaryNode(0);
        // root.left = new BinaryNode(1);
        // root.right = new BinaryNode(2);
        // root.left.left = new BinaryNode(3);
        // root.left.right = new BinaryNode(4);
        // root.left.right.left = new BinaryNode(5);
        // root.left.right.right = new BinaryNode(6);
        
        BinaryNode root = new BinaryNode(0);
        BinaryNode n1 = new BinaryNode(1);
        BinaryNode n2= new BinaryNode(2);
        BinaryNode n3 = new BinaryNode(3);
        BinaryNode n4 = new BinaryNode(4);
        BinaryNode n5 = new BinaryNode(5);
        root.left = n1;
         n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;
        BinaryTreeLl tree = new BinaryTreeLl();
       // tree.preOrder(root);
       // tree.levelOrder(root);
       // tree.search(root,5);
        // tree.insertionInTree(root,6);
        //tree.levelOrder(root);
         {

            // tree.insertionInTree(root,1);
            // tree.insertionInTree(root,2);
            // tree.insertionInTree(root,3);
            // tree.insertionInTree(root,4);
            // tree.insertionInTree(root,5);
            // tree.insertionInTree(root,6);
            // tree.insertionInTree(root,7);
            

        }
        // tree.levelOrder(root);
        // System.out.println("deepest is " + tree.deepestNode(root).data);
        // tree.delete(root,3);
        // tree.levelOrder(root);
        System.out.println("Height of the tree is : " + tree.heightOfTree(root));
    }
}
