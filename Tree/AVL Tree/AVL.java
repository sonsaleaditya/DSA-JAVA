import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    Node root = null;

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    // rotation right
    private Node rotateRight(Node disbalanceNode) {
        Node newRoot = disbalanceNode.left;
        disbalanceNode.left = disbalanceNode.left.right;
        newRoot.right = disbalanceNode;
        disbalanceNode.height = 1 + Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // rotate left
    private Node rotateLeft(Node disbalanceNode) {
        Node newRoot = disbalanceNode.right;
        disbalanceNode.right = disbalanceNode.right.left;
        newRoot.left = disbalanceNode;
        disbalanceNode.height = 1 + Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // getBalance
    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        } else {
            return getHeight(node.left) - getHeight(node.right);
        }
    }

    private Node insertNode(Node node, int val) {
        if (node == null) {
            Node newNode = new Node();
            newNode.data = val;
            newNode.height = 1;
            return newNode;
        } else if (val < node.data) {
            node.left = insertNode(node.left, val);
        } else {
            node.right = insertNode(node.right, val);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        // ll
        if (balance > 1 && val < node.left.data) {
            return rotateRight(node);
        }
        // lr
        if (balance > 1 && val < node.left.right.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // rr
        if (balance < -1 && val > node.right.data) {

            return rotateLeft(node);
        }

        // rl
        if (balance < -1 && val < node.right.data) {
            node.right = rotateLeft(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void insert(int val) {
        root = insertNode(root, val);
    }

   

    private Node deleteNode(Node node, int val){
        // case 1 rotatation not required
        if(node == null){
            return node;
        }
        if(val < node.data){
            node.left = deleteNode(node.left, val);
            return node;
        }else if(val > node.data){
            node.right = deleteNode(node.right, val);
            return node;
        }else{
            // node.data = val
            //case 1 : no child
            if(node.left == null && node.right == null){
                return null;
            }
            //case 2 : both child
            if(node.left!=null && node.right!=null){
                int min = succesor(node.right);
                node.data = min;
                node.right = deleteNode(node.right, min);
                return node;
            }
            //case 3 : left child
            if(node.left!=null){
                return node.left;
            }
            //right child
            if(node.right!=null){
                return node.right;
            }
        }

        //case 2 : rotation required

        int balance = getBalance(node);
        //case 1 : L L 
        if(balance > 1 && getBalance(node.left)>=0){
            return rotateRight(node);
        }

         //case 2 : L R 
         if(balance > 1  && getBalance(node.left)<0){
            rotateLeft(node.left);
            return rotateRight(node);
        }

         //case 3 : R R 
         if(balance < -1  && getBalance(node.right)<=0){
             return rotateLeft(node);
        }

         //case 4 : R L 
         if(balance < -1  && getBalance(node.right)>0){
           node.right = rotateRight(node.right);
            return rotateLeft(node);
       }

       return node;

    }

    public void delete(int val){
        deleteNode(root, val);
    }
    private int succesor(Node node) {
        int min = node.data;
        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

     // traveral
     private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    void inorder() {
        inorder(root);
    }
    private void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void preOrder(){
        preOrder(root);
    }

    private void levels(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node curr = q.remove();
                System.out.print(curr.data + " ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            System.out.println();
           
        }
    }
    public void levels(){
        levels(root);
    }
    
}
