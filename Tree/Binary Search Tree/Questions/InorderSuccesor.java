public class InorderSuccesor {
    
}


class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
         {
            int xdata = x.data;
            ArrayList<Integer> arr = new ArrayList<>();
            inorder(root,arr);
            int index =  arr.indexOf(x.data);
            if(index != -1 && index < arr.size() -1){
                    int succesorValue = arr.get(index+1);
                    return search(root, succesorValue);
            }
            
            return null;
         }
         
         
         static void inorder(Node root, ArrayList<Integer> arr){
             if(root == null){
                 return ;
             }
             inorder(root.left, arr);
             arr.add(root.data);
             inorder(root.right,arr);
             
         }
         
         static Node search(Node root, int succesorValue){
             if(root == null || root.data == succesorValue){
                 return root;
             }
             if(succesorValue < root.data){
                return  search(root.left, succesorValue);
             }
            //   if(succesorValue > root.data){
                return search(root.right, succesorValue);
        //     }
            //  return root;
         }
}