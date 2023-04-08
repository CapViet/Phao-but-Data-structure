//{ Driver Code Starts
import java.util.*;

class Node7
{
    int data;
    Node7 left, right;

    Node7(int item)
    {
        data = item;
        left = right = null;
    }
}

class Res
{
    Node7 pre = null;
    Node7 succ = null;
}
class PreSucc
{

    public static void insert(Node7 root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node7(a1);
                    break;
                case 'R':root.right=new Node7(a1);
                    break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }

    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            if(n==0)
            {
                System.out.println(0);
                continue;
            }
            Node7 root = null;
            Res p = new Res();
            Res s = new Res();
            for(int i=0;i<n;i++){

                int a=sc.nextInt();
                int a1=sc.nextInt();

                char lr=sc.next().charAt(0);

                if(i==0){

                    root=new Node7(a);

                    switch(lr)
                    {

                        case 'L':root.left=new Node7(a1);
                            break;
                        case 'R':root.right=new Node7(a1);
                            break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }

            int key = sc.nextInt();
            Solution6.findPreSuc(root, p, s, key);

            if(p.pre != null)
                System.out.print(p.pre.data + " ");
            else
                System.out.print("-1" + " ");

            if(s.succ != null)
                System.out.println(s.succ.data);
            else
                System.out.println("-1");


        }
    }
}
// } Driver Code Ends


/* BST Node
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class Solution6
{
    public static void findPreSuc(Node7 root, Res p, Res s, int key)
    {
        // add your code here
        p.pre = inorderPredecessor(root, key);
        s.succ = inorderSuccessor(root, key);
    }
    static Node7 inorderSuccessor(Node7 root, int key)
    {
        //add code here.
        Node7 successor = null;
        while (root !=  null){
            if (root.data <= key){
                root = root.right;
            }
            else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
    static Node7 inorderPredecessor(Node7 root,int key)
    {
        //add code here.
        Node7 predecessor = null;
        while (root !=  null){
            if (root.data >= key) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }
}