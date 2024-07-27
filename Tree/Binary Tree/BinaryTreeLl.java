import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLl {
    public void preOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " -> ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.data + " -> ");

        preOrder(root.right);
    }

    public void postOrder(BinaryNode root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data + " -> ");
    }

    public void levelOrder(BinaryNode root) {
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while (!(q.isEmpty())) {
            BinaryNode presentNode = q.remove();
            System.out.print(" " + presentNode.data + " -> ");
            if (presentNode.left != null) {
                q.add(presentNode.left);
            }
            if (presentNode.right != null) {
                q.add(presentNode.right);
            }
        }
    }

    void search(BinaryNode root, int k) {
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        System.out.println();
        while (!q.isEmpty()) {
            BinaryNode presentNode = q.poll();
            if (presentNode.data == k) {
                System.out.println("data found !!");
                return;
            }
            if (presentNode.left != null) {
                q.add(presentNode.left);
            }
            if (presentNode.right != null) {
                q.add(presentNode.right);
            }
        }
    }

    void insertionInTree(BinaryNode root, int k) {
        // k is the element where we want to insert
        // its insertion where we found first vacant place according to level order

        Queue<BinaryNode> q = new LinkedList<>();

        BinaryNode n = new BinaryNode(k);
        if (root == null) {
            root = n;
            System.out.println("inserted as root");
            return;
        }
        q.add(root);
        while (!(q.isEmpty())) {
            BinaryNode presentNode = q.remove();
            if (presentNode.left == null) {
                presentNode.left = n;
                System.out.println("inserted at left");
                break;
            } else if (presentNode.right == null) {
                presentNode.right = n;
                System.out.println("inserted at right");
                break;
            } else {
                q.add(presentNode.left);
                q.add(presentNode.right);
            }

        }
    }

    BinaryNode deepestNode(BinaryNode root) {
        // deepest node also known as very last node of tree
        // we will replace the node which is to be deleted with deepest node or last
        // node
        // by level order we will get at last deepest node in presentNode variable
        BinaryNode presentNode = null;
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            presentNode = q.remove();
            if (presentNode.left != null) {
                q.add(presentNode.left);
            }
            if (presentNode.right != null) {
                q.add(presentNode.right);
            }
        }
        return presentNode;
    }

    void deleteDeepestNode(BinaryNode root) {
        Queue<BinaryNode> q = new LinkedList<>();

        BinaryNode previousNode = null;
        BinaryNode presentNode = null;
        q.add(root);
        // Perform level order traversal to find the deepest node and its parent
        while (!q.isEmpty()) {
            previousNode = presentNode;
            presentNode = q.remove();
            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            }
            if (presentNode.right != null) {
                presentNode.left = null;
                return;
            }
            q.add(presentNode.left);
            q.add(presentNode.right);

        }

    }

    void delete(BinaryNode root, int k) {
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryNode presentNode = q.remove();
            if (presentNode.data == k) {
                presentNode.data = deepestNode(root).data;
                deleteDeepestNode(root);
                System.out.println(k + " deleted succesfully !!");
                return;
            } else {
                if (presentNode.left != null)
                    q.add(presentNode.left);
                if (presentNode.right != null)
                    q.add(presentNode.right);
            }
        }
        System.out.println(k + " is not exist in tree !!");
    }

    int heightOfTree(BinaryNode root) {
        int height = 0;
        if (root == null) {
            return -1;
        }

        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            height++;
            for (int i = 0; i < q.size(); i++) {
                BinaryNode presentNode = q.remove();
                if (presentNode.left != null) {
                    q.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    q.add(presentNode.right);
                }
            }

        }
        return height;
    }

    

}
