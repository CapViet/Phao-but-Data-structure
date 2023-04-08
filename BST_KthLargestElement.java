//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node4
{
    int data;
    Node9 left;
    Node9 right;
    Node4(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class gfg {

    static Node9 buildTree(String str)
    {
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node9 currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node9(Integer.parseInt(currVal));
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
                currNode.right = new Node9(Integer.parseInt(currVal));

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
            Node9 root = buildTree(s);

            int k=Integer.parseInt(br.readLine());

            Solution4 g = new Solution4();
            System.out.println (g.kthLargest(root,k));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution4
{
    // return the Kth the largest element in the given BST rooted at 'root'
    public int kthLargest(Node9 root, int K)
    {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        if (K > n){
            return - 1;
        }
        return list.get (n - K);
    }

    public static void inorder(Node9 root, List<Integer> list){
        if(root != null){
            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }
    }
}
