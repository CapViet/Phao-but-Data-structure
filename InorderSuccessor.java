//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node6
{
    int data;
    Node6 left;
    Node6 right;
    Node6(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class Main2 {

    static Node6 buildTree(String str)
    {
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node6 root = new Node6(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node6> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node6 currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node6(Integer.parseInt(currVal));
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
                currNode.right = new Node6(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node6 search(Node6 root,int x){
        if(root==null||root.data==x)
            return root;
        if(root.data>x)
            return search(root.left,x);
        return search(root.right,x);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node6 root = buildTree(s);

            int k=Integer.parseInt(br.readLine());
            Node6 kNode = search(root,k);

            Solution5 g = new Solution5();
            Node6 x = g.inorderSuccessor(root,kNode);

            if(x==null) System.out.println("-1");
            else System.out.println(x.data);
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class Solution5
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public Node6 inorderSuccessor(Node6 root,Node6 x)
    {
        //add code here.
        Node6 successor = null;
        while (root !=  null){
            if (root.data <= x.data){
                root = root.right;
            }
            else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}