package BinaryTree;

import java.util.*;

public class Fullbinary {
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
    public static boolean checkFull(Node root)
    {
        
        if(root == null)
        return true;
        if(root.left==null && root.right == null)
        return true;
        if(root.left!=null && root.right!=null)
        {
            return(checkFull(root.left)&& checkFull(root.right));
        } 
        return false;
        
    }
    public static void main(String[] args) {
        insertNode(root, 10);
        insertNode(root, 20);
        insertNode(root, 30);
        insertNode(root, 40);
        System.out.println(checkFull(root));
    }
}
