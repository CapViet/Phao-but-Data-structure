//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node2{
    int data;
    Node9 left;
    Node9 right;
    Node2(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class gfG {

    static Node9 buildTree(String str){

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
    static void printInorder(Node9 root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            Node9 root = buildTree(s);
            Solution1 g = new Solution1();
            System.out.println(g.getCount(root,a,b));
            t--;

        }
    }

}


// } Driver Code Ends


// A Binary Search Tree node


class Solution1
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node9 root, int l, int h)
    {
        //Your code here
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        int count = 0;
        for (int i = 0; i < n; i ++){
            if (list.get(i) >= l && list.get(i) <= h){
                count ++;
            }
        }
        return count;
    }
    public static void inorder(Node9 root, List<Integer> list){
        if(root != null){
            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }
    }
}


