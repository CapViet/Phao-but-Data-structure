//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

class Node9 {
    int data;
    Node9 left;
    Node9 right;
    Node9(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main4 {

    static Node9 buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node9 root = new Node9(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node9> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node9 currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node9(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node9(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node9 root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Node9 root = buildTree(s);
            Tree3 g = new Tree3();
            System.out.println(g.findCeil(root, n));
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Tree3 {
    // Function to return the ceil of given number in BST.
    int findCeil(Node9 root, int key) {
        if (root == null) return -1;
        // Code here
        // If the value of the node is equal to val, return the value of the node
        if (root.data == key){
            return root.data;
        }
        else if (key < root.data){
            //Recursively search the left subtree
            int check = findCeil(root.left , key);
            if (check != -1){
                //return key >= val of node
                return check;
            }
            else{
                //return the data of the current node
                return root.data;
            }
        }
        else{
            //recursively search the right subtree
            return findCeil(root.right, key);
        }
    }
}
