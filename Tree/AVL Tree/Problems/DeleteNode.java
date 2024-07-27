class Sol
{
    public static Node deleteNode(Node root, int key)
    {
        //case rotatin not req
        // searchin for node
        if(root == null){
            return null;
        }
        if(key < root.data){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if(key > root.data){
            root.right = deleteNode(root.right, key);
            return root;
        }else{
            // root.data == key
            //1 no child
            if(root.left == null && root.right == null){
                return null;
            }
            //both child
            if(root.left!=null && root.right!=null){
                int min = successor(root.right);
                root.data = min;
                root.right = deleteNode(root.right,min);
                return root;
            }
            // left child
            if(root.left != null){
                return root.left;
            }
            // right child
            if(root.right != null){
                return root.right;
            }
            
        }
        
        // case 2 : rotation required
        int balance = getBalance(root);
        
        // LL
        if(balance > 1 && getBalance(root.left) >= 0){
            return rightRotation(root);
        }
        
        // LR
        if(balance > 1 && getBalance(root.left) < 0){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        
        // RR
        if(balance < -1 && getBalance(root.right) <= 0){
           return leftRotation(root);
        }
        
        // RL
        if(balance < -1 && getBalance(root.left) > 0){
          root.right = rightRotation(root.right);
           return leftRotation(root);
        }
        
        return root;
        
    }
    private static int successor(Node root){
        int min = root.data;
        while(root.left != null){
            root = root.left;
            min = root.data;
        }
        return min;
    }
    private static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return (getHeight(root.left) - getHeight(root.right));
    }
    private static int getHeight(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }
    
    private static Node leftRotation(Node root){
        if(root == null){
            return null;
        }
        
        Node newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }
    
     private static Node rightRotation(Node root){
        if(root == null){
            return null;
        }
        
        Node newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
         return newRoot;
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

public class Node {
    int height,data;
    Node left ,right;

    Node(){
        this.height = 0;
        left = null;
        right = null;
    }
}

class deleteNode{
    public static void main(String[] args){
        Sol s = new Sol();
    }
}
