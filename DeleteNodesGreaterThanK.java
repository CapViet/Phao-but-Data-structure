//{ Driver Code Starts
//Code By: saksham raj Seth

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

class Node13
{
    int data;
    Node13 left;
    Node13 right;
    Node13(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class DeleteNodes{
    static Node13 buildTree(String str)
    {
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node13 root = new Node13(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node13> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node13 currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node13(Integer.parseInt(currVal));
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
                currNode.right = new Node13(Integer.parseInt(currVal));

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
            Node13 root = buildTree(s);

            int k=Integer.parseInt(br.readLine());
            Solution11 g=new Solution11();
            root=g.deleteNode(root,k);
            inorder(root);
            System.out.println();
            t--;
        }
    }



    public static void inorder(Node13 root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
}

// } Driver Code Ends


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
class Solution11
{
    public Node13 deleteNode(Node13 root, int k)
    {
        //add code here.
        if (root == null) return null;
        if (root.data > k) {
            return deleteNode(root.left, k);
        } else if (root.data < k) {
            root.right = deleteNode(root.right, k);
        } else {
            return root.left;
        }
        return root;
    }
}
