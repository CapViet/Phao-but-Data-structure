//{ Driver Code Starts
import java.util.*;

class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
    {
        this.first = first;
        this.second = second;
    }
}
class Node
{
    int data, height;
    Node left, right;

    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
class GfG
{
    public static boolean isBST(Node n, int lower, int upper)
    {
        if(n==null) return true;
        if( n.data <= lower || n.data >= upper ) return false;
        return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }

    public static pair isBalanced(Node n)
    {
        if(n==null)
        {
            return new pair(0,true);
        }

        pair l = isBalanced(n.left);
        pair r = isBalanced(n.right);

        if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);

        return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }

    public static boolean isBalancedBST(Node root)
    {
        if(!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            System.out.print("BST voilated, inorder traversal : ");

        else if (!isBalanced(root).second)
            System.out.print("Unbalanced BST, inorder traversal : ");

        else return true;
        return false;
    }

    public static void printInorder(Node n)
    {
        if(n==null) return;
        printInorder(n.left);
        System.out.print(n.data + " ");
        printInorder(n.right);
    }


    public static void main(String[] args)
    {
        int[] data = {5,6,7,1,2,3,8,6,9,0};
        Node root = null;
        for (int datum : data) {
            root = Solution.insertToAVL(root, datum);
            if (!isBalancedBST(root)) {
                break;
            }
        }


        printInorder(root);
        System.out.println();

        Solution.deleteNode(root, 0);
        Solution.deleteNode(root, 9);
        System.out.println("After deletion: ");
        printInorder(root);
        isBalancedBST(root);

    }
}

class Solution
{
    public static Node insertToAVL(Node node, int data)
    {
        //code here
        //if the code the null, add a new one
        if(node == null)
            return (new Node(data));

        //compare the data to the current node's data, see which subtree we need to dive into
        if(data < node.data){
            node.left = insertToAVL(node.left, data);
        }
        else if (data > node.data){
            node.right = insertToAVL(node.right, data);
        }
        //if the data is equal the node's data, do nothing
        else
            return node;

        //update the height when inserting a new node, or not just to be sure
        updateHeight(node);

        //get the balance of the tree
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && data < node.left.data)
            return rotateRight(node);

        // Right Right Case
        if (balance < -1 && data > node.right.data)
            return rotateLeft(node);

        // Left Right Case
        if (balance > 1 && data > node.left.data)
        {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.right.data)
        {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public static Node deleteNode(Node root, int key)
    {
        if (root == null)
            return root;

        //compare the key to the root's data, see which subtree we need to go down to
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);

        //if the key is equal to the node's data, this is the one we need to delete, proceed
        else
        {
            //node with only one or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                //if the left child is null, copy the right child
                if (temp == root.left)
                    temp = root.right;
                //and vice-versa
                else
                    temp = root.left;

                //no child case
                if (temp == null) //null, even after copying the right and left child to the temp node
                {
                    root = null;//delete the current node
                }
                //one child case
                else
                    root = temp; //copy the contents of the non-empty child
            }

            //node with 2 children
            else
            {
                //get the inorder successor(smallest in the right subtree)
                Node temp = minValueNode(root.right);

                //copy the inorder successor's data to this node
                root.data = temp.data;

                //delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // if the tree had only 1 node, then return
        if (root == null)
            return root;

        //update the height of the tree
        updateHeight(root);

        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rotateRight(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return rotateLeft(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    //given a non-empty binary tree, find the minimum key value found in that tree
    static Node minValueNode(Node node)
    {
        Node current = node;
        //loop down to find the left-most leaf
        while (current.left != null)
            current = current.left;

        return current;
    }
    public static int height(Node n){
        return (n == null) ? 0 : n.height;
    }
    static int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }
    public static void updateHeight(Node n) {
        n.height = 1 + max(height(n.left), height(n.right));
    }
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    public static Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;

        //perform rotation
        x.right = y;
        y.left = z;

        //update the heights
        updateHeight(y);
        updateHeight(x);

        //return the new root
        return x;
    }

    public static Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;

        //perform rotation
        x.left = y;
        y.right = z;

        //update the heights
        updateHeight(y);
        updateHeight(x);

        //return the new root
        return x;
    }
}
