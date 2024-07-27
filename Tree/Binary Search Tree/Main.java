public class Main {

    public static void main(String[] args) {
         BinarySearchTree bst = new BinarySearchTree();
         BinaryNode root = new BinaryNode(4);
         bst.insert(root,2);
         bst.insert(root,9);
        //  bst.insert(root,11);
        //  bst.insert(root,8);
        //  bst.insert(root,9);
        //  bst.insert(root,2);
        
        //  bst.preOrder(root);
        //  System.out.println(bst.searchNode(root,10));
        //  bst.deleteNode(root,10);
       //  bst.preOrder(root);
      // System.out.println(bst.);
         System.out.println(bst.kthLargest(root,2));
    }
   
}
