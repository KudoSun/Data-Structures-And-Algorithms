class Node {
    int data;                    //value of node
    Node left, right;          //left and right node 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 
class levelOrderBT {
    // Root of the Binary Tree
    Node root;
 
    public levelOrderBT() { root = null; }    //constructor
 
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }
 
    //calculate height of tree
    int height(Node root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
 
    /* Print nodes at the current level */
    void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        levelOrderBT tree = new levelOrderBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Level order traversal of"
                           + "binary tree is ");
        tree.printLevelOrder();
    }
}