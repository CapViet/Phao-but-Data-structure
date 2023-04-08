class Node1
{
    int data;
    Node1 left, right;

    Node1(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node1 root;

    /* this function checks if a binary tree is full or not */
    boolean isFullTree(Node1 node)
    {
        // if empty tree
        if(node == null)
            return true;

        // if leaf node
        if(node.left == null && node.right == null )
            return true;

        // if both left and right subtrees are not null
        // they are full
        if((node.left!=null) && (node.right!=null))
            return (isFullTree(node.left) && isFullTree(node.right));

        // if none work
        return false;
    }


    // Driver program
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node1(10);
        tree.root.left = new Node1(20);
        tree.root.right = new Node1(30);
        tree.root.left.right = new Node1(40);
        tree.root.left.left = new Node1(50);
        tree.root.right.left = new Node1(60);
        tree.root.left.left.left = new Node1(80);
        tree.root.right.right = new Node1(70);
        tree.root.left.left.right = new Node1(90);
        tree.root.left.right.left = new Node1(80);
        tree.root.left.right.right = new Node1(90);
        tree.root.right.left.left = new Node1(80);
        tree.root.right.left.right = new Node1(90);
        tree.root.right.right.left = new Node1(80);
        tree.root.right.right.right = new Node1(90);

        if(tree.isFullTree(tree.root))
            System.out.print("The binary tree is full");
        else
            System.out.print("The binary tree is not full");
    }
}
