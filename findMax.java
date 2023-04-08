//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node8{
    int key;
    Node8 left;
    Node8 right;

    Node8(int x){
        this.key = x;
        left=null;
        right=null;
    }
}

class Main3 {

    static Node8 buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node8 root = new Node8(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node8> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node8 currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node8(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node8(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }


    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            int N=Integer.parseInt(br.readLine());
            Node8 root = buildTree(s);
            System.out.println(Tree2.findMaxForN(root,N));
            t--;

        }
    }

}


// } Driver Code Ends


//User function Template for Java

/*class Node
{
    int key;
    Node left, right;

    Node(int x)
    {
        key = x;
        left = right = null;
    }

}*/
class Tree2
{
    public static int findMaxForN(Node8 node, int val)
    {
        //Add your code here.
        if(node==null){
            return -1;
        }

        // If the value of the node is equal to val, return the value of the node
        if (node.key == val){
            return node.key;
        } else if (val > node.key){
            //Recursively search the right subtree
            int check = findMaxForN(node.right, val);
            if (check != -1){
                //return key >= val
                return check;
            } else {
                //return the key of the current node
                return node.key;
            }
        } else {
            //recursively search the left subtree
            return findMaxForN(node.left, val);
        }

    }
}
