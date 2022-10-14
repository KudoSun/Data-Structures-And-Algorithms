package BinaryTree;
import java.util.*;

public class perfect {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node root = null;
    static int ans=0;

    public static void insertNode(Node temp, int data) {
        if (temp == null) {
            root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
        while (!q.isEmpty()) {
            temp = q.remove();
            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else
                q.add(temp.right);
        }
    }
    static int findDepth(Node node)
    {
        int d = 0;
        while(node!=null)
        {
            d++;
            node = node.left;
        }
        return d;
    }

    static boolean isPerfectRec(Node root, int d, int level)
    {
        if(root == null)
        return true;
                
        if(root.left==null && root.right==null)
        {
            return (d == level+1);
        }
        

        if(root.left==null || root.right==null)
        return false;

        return (isPerfectRec(root.left,d,level+1) && isPerfectRec(root.right,d,level+1));
    }

    static boolean isPerfect(Node root)
    {
        int d = findDepth(root);
        return isPerfectRec(root,d,0);
    }
    public static void main(String[] args) {
        insertNode(root, 10);
        insertNode(root, 11);
        insertNode(root, 12);
        System.out.println(isPerfect(root));;
    }
}
