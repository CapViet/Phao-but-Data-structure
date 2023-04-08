//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node11 {
    int data;
    Node11 left, right;

    public Node11(int d) {
        data = d;
        left = right = null;
    }
}

class Main5 {
    static Node11 buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals("N")) return null;
        String[] s = str.split(" ");

        Node11 root = new Node11(Integer.parseInt(s[0]));
        Queue<Node11> q = new LinkedList<Node11>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node11 currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node11(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node11(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine().trim();
            Node11 root = buildTree(s);
            int key = Integer.parseInt(br.readLine().trim());
            Solution7 T = new Solution7();
            root = T.insert(root, key);
            inorder(root);
            System.out.println();
            t--;
        }
    }

    static void inorder(Node11 root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution7 {
    // Function to insert a node in a BST.
    Node11 insert(Node11 root, int key) {
        // your code here
        //not data ? add a new node
        if(root == null){
            return (new Node11(key));
        }
        //equal to the data of the current node ? BST doesn't allow 2 of the same element, no change
        if(root.data == key){
            return root;
        }
        //data is bigger ? add to the left subtrees
        if(root.data > key){
            //recursively add to the left subtree if the condition allows it
            root.left = insert(root.left, key);
        }
        //data is smaller ? add to the right subtrees
        else{
            //recursively add to the right subtree if the condition allows it
            root.right = insert(root.right, key);
        }
        return root;
    }
}