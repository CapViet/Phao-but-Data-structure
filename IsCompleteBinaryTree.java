//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

class Node2 {
    int data;
    Node2 left;
    Node2 right;
    Node2(int data){
        this.data = data;
        left=null;
        right=null;
    }
}



class CompleteBT{

    static Node2 buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node2 root = new Node2(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node2> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node2 currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node2(Integer.parseInt(currVal));
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
                currNode.right = new Node2(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node2 root){
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String s = br.readLine();
            Node2 root = buildTree(s);
            Main g=new Main();
            boolean a=g.isCompleteBT(root);
            if(a==true)
                System.out.println("Complete Binary Tree");
            else
                System.out.println("Not Complete Binary Tree");
        }
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
class Main
{
    boolean isCompleteBT(Node2 root)
    {
        //add code here.
        // Base Case: An empty tree is complete Binary Tree
        if(root == null)
            return true;

        // Create an empty queue
        Queue<Node2> queue =new LinkedList<>();

        // Create a flag variable which will be set true
        // when a non full node is seen
        boolean flag = false;

        // Do level order traversal using queue.
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node2 temp_node = queue.remove();

            /* Check if left child is present*/
            if(temp_node.left != null)
            {
                // If we have seen a non full node, and we see a node
                // with non-empty left child, then the given tree is not
                // a complete Binary Tree
                if(flag == true)
                    return false;

                // Enqueue Left Child
                queue.add(temp_node.left);
            }
            // If this a non-full node, set the flag as true
            else
                flag = true;

            /* Check if right child is present*/
            if(temp_node.right != null)
            {
                // If we have seen a non full node, and we see a node
                // with non-empty right child, then the given tree is not
                // a complete Binary Tree
                if(flag == true)
                    return false;

                // Enqueue Right Child
                queue.add(temp_node.right);

            }
            // If this a non-full node, set the flag as true
            else
                flag = true;
        }
        // If we reach here, then the tree is complete Binary Tree
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
*/