//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node10 {
    int data;
    Node10 left;
    Node10 right;
    Node10(int d) {
        data = d;
        left = right = null;
    }
}

class Is_Node__Present_In_BST {
    void insert(Node10 root, int key) {

        if (key < root.data) {
            if (root.left != null)
                insert(root.left, key);
            else
                root.left = new Node10(key);
        } else if (key > root.data) {
            if (root.right != null)
                insert(root.right, key);
            else
                root.right = new Node10(key);
        }
    }
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Is_Node__Present_In_BST obj = new Is_Node__Present_In_BST();
            int a1 = sc.nextInt();
            Node10 root = new Node10(a1);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                obj.insert(root, a);
            }

            int s = sc.nextInt();
            BST g = new BST();
            if (g.search(root, s) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    }
}
// } Driver Code Ends


class BST {
    // Function to search a node in BST.
    boolean search(Node10 root, int x) {
        // Your code here
        if(root == null){
            return false;
        }
        //if the data of current node is already equal to x, return true
        if(root.data == x){
            return true;
        }
        //if x is smaller than the data, search the left subtree
        if(x < root.data){
            //recursively search the left subtrees
            return search(root.left, x);
        }
        //else, search the right subtree
        else{
            //recursively search the right subtrees
            return search(root.right, x);
        }
    }
}
