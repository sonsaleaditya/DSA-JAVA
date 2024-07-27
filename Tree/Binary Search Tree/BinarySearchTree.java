import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class BinarySearchTree {
    BinaryNode root;
    BinarySearchTree(){
       this.root = null;
    }
    BinaryNode insert(BinaryNode currentNode, int value){
        if(currentNode == null){
            currentNode = new BinaryNode(value);
            return currentNode;
        }
        else if(value <= currentNode.data){
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        }
        else{
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }


    void insert(int value){
        insert(root,value);
    }

    void preOrder(BinaryNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    boolean search(BinaryNode node, int val){
        if(node==null){
            return false;
        }
        else if(val==node.data){
            return true;
        }
        else if(val<node.data){
            return search(node.left, val);
        }
        else if(val>node.data){
           return search(node.right, val);
        }

        return false;
    }


    BinaryNode searchNode(BinaryNode node, int val){
        if(node==null){
            return null;
        }
        else if(val==node.data){
           System.out.println("found it");
           return node;
        }
        else if(val<node.data){
            return searchNode(node.left, val);
        }
        else {
           return searchNode(node.right, val);
        
        }
        
    }

    public static BinaryNode minimumNode(BinaryNode root){
        if(root.left==null){
              return root;
        }else{
            return minimumNode(root.left);
        }
          
    }

    BinaryNode deleteNode(BinaryNode root, int val){
        if(root==null){
            System.out.println("value not found for deletion");
            return null;
        }
        else if(val<root.data){
           root.left = deleteNode(root.left, val);
        }else if(val>root.data){
            root.right = deleteNode(root, val);
        }else{
            if(root.left!=null && root.right!=null){
                BinaryNode temp = root;
                BinaryNode minForRight = minimumNode(root);
                root.data = minForRight.data;
                root.right = deleteNode(root.right, val);



            }else if(root.left!=null && root.right==null){
                root=root.left;
            }else if(root.right!=null && root.left==null){
                root=root.right;
            }else{
                root = null;
            }

        }
        return root;

    }

    public int kthLargest(BinaryNode root,int K)
    {
       ArrayList<Integer> arr = new ArrayList<>();
       inorder(root,arr);
       for(int k : arr)
            System.out.print(k + " ");
        System.out.println();
       int result = arr.get(arr.size() - K);
       return result;
    }
    
    static void inorder(BinaryNode root, ArrayList<Integer> arr) {
        if(root ==  null){
            return;
        }
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
}
