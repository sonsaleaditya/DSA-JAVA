public class DeleteNode {
    
}


class Tree {
    // Function to delete a node from BST.
    public static Node deleteNode(Node root, int X) {
        if(root == null)    
            return null;
            
            /// searching of node
        if(X < root.data){
            root.left = deleteNode(root.left , X);
            return root;
        }
           else if(X  > root.data){
            root.right = deleteNode(root.right, X);
            return root;
           } else{
               // root.data == X got node
               //case 1 : no child
               if(root.left == null && root.right == null)
               {
                   return null;
               }
               
               //case 2 : both child
               if(root.left != null && root.right != null)
               {
                   int min = succesor(root.right);
                  root.data = min;
                  root.right = deleteNode(root.right, min);
                  return root;
               }
               // left child
               if(root.left != null)
                      return root.left;
                     
                // right child 
                    if(root.right != null)
                        return root.right;
                    
           }
           return root;
    }
    
    static int succesor(Node root){
        int min = root.data;
        while(root.left!=null)
        {
            root = root.left;
            min = root.data;
        }
        return min;
        
    }
    
    
}
    // Function to delete a node from BST.
    public static Node deleteNode(Node root, int X) {
       if(root == null){
        return root;
       }
       if(X < root.data){
        root.left = deleteNode(root.left, X);
        return root;
       }
       else if(X > root.data){
        root.right = deleteNode(root.right, X);
        return root;
       }else{
        // root.data == X
        if(root.left == null && root.right == null){
            return null;
        }
        if(root.left != null && root.right != null){
            int min = succesor(root.right);
            root.data = min;
           root.right =  deleteNode(root.right, X);
        }
        if(root.left != null){
          
            return root.left;
        }
        if(root.right != null){
            
            return root.right;
        }
       }
       return root;
    }
    
    static int minValue(Node root){
        int minV = root.data;
        while(root.left!=null){
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }
    
}