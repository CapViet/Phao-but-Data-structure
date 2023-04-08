//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node3 {
    int data;
    Node9 left, right;

    public Node3(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node9 buildTree(String str) {
        // Corner Case
        if (str.length() == 0) return null;
        String[] s = str.split(" ");

        Node9 root = new Node9(Integer.parseInt(s[0]));
        Queue<Node9> q = new LinkedList<Node9>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node9 currrNode = q.remove();

            // Get the currrent node's value from the string
            String currrVal = s[i];

            // If the left child is not null
            if (!currrVal.equals("N")) {

                // Create the left child for the currrent node
                currrNode.left = new Node9(Integer.parseInt(currrVal));

                // Push it to the queue
                q.add(currrNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currrVal = s[i];

            // If the right child is not null
            if (!currrVal.equals("N")) {

                // Create the right child for the currrent node
                currrNode.right = new Node9(Integer.parseInt(currrVal));

                // Push it to the queue
                q.add(currrNode.right);
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
            String s = br.readLine();
            Node9 root = buildTree(s);

            int k = Integer.parseInt(br.readLine().trim());

            Solution3 T = new Solution3();
            System.out.println(T.KthSmallestElement(root, k));
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//           public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution3 {
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node9 root, int K) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        if (K > n){
            return - 1;
        }
        return list.get(K -1);
    }

    public static void inorder(Node9 root, List<Integer> list){
        if(root != null){
            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }
    }
}

