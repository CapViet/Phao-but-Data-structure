import java.util.LinkedList;
        import java.util.Queue;
        import java.io.*;
        import java.util.*;

class Node{
    int data;
    Node13 left;
    Node13 right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {

    static Node13 buildTree(String str){

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
            Node13 root = buildTree(s);

            Tree g = new Tree();
            float answer = Tree.findMedian(root);
            if(answer-(int)answer == 0)
                System.out.println((int)answer);
            else
                System.out.println(answer);


        }
    }
}


class Tree
{
    public static void inorder(Node13 root, List<Integer> list){
        if(root != null){
            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }
    }
    public static float findMedian(Node13 root)
    {
        // code here.
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        if(n % 2 == 0){
            return (float)(list.get(n/2) + list.get(n/2 - 1))/2;
        }else{
            return (float)list.get(n/2);
        }
    }

}