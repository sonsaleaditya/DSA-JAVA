public class LowestCommanAncestor {
 public  Node lca(Node root, int x , int y){
        if(root == null){
            return null;
        }
        if(x < root.data && y < root.data){
          return  lca(root.left, x , y);
        }
        if(x > root.data && y > root.data){
           return lca(root.right, x , y);
        }
        // else condition
        // if(x < root.data && y > root.data || x>root.data && y<root.data){
        //     return root;
        // }
        return root;
   }
}
