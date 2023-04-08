import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
@SuppressWarnings("unchecked")
public class SimpleBST<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key> {

	class Node{
		Key data;
		Node left, right;
		public Node(Key key)
		{
			this.data =  key;
		}
	}
	
	private Node root = null;
	int n = 0;
	public Node insert(Node currentNode, Key k){
		if(currentNode== null){
			currentNode= new Node(k);
			return currentNode;
		}
		else{
			int c = currentNode.data.compareTo(k);
			if(c >  0){
				currentNode.left = insert(currentNode.left,k );
			}
			else if (c <= 0){
				currentNode.right = insert(currentNode.right, k);
			}
		}
		return currentNode;
	}
	@Override
	public void insert(Key k) {
		// TODO Auto-generated method stub
		root = insert(root, k);
		n++;
	}

	public Node search(Node currentNode, Key k){
		if (currentNode == null){
			return null;
		}
		else{
			int c = currentNode.data.compareTo(k);
			if( c > 0){
				search(currentNode.left, k);
			}
			else if (c == 0) {
				return currentNode;
			}
			else {
				search(currentNode.right, k);
			}
		}
		return null;
	}
	@Override
	public Key search(Key k) {
		// TODO Auto-generated method stub
		Node cur = root;
		int c;
		while (cur != null) {
			c = cur.data.compareTo(k);
			if (c == 0) {
				return cur.data;
			} else if (c > 0) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub

		List<Key> keys = new ArrayList<Key>();
		traverse(root, keys);
		return keys.iterator();
	}
	public void traverse(Node node, List<Key> keys) {
		if (node != null) {
			traverse(node.left, keys);
			keys.add(node.data);
			traverse(node.right, keys);
		}
	}


	//duyệt cây theo thứ tự trước (tiền thứ tự)
	public void preTraverse()
	{
		preTraverse(root);
	}

	public void preTraverse(Node cur) {
		if (cur != null) {
			System.out.println(cur.data);
			preTraverse(cur.left);
			preTraverse(cur.right);
		}
	}

	// duyệt cây theo thứ tự sau (hậu thứ tự)
	public void postTraverse() {
		postTraverse(root);
	}

	public void postTraverse(Node cur) {
		if (cur != null) {
			postTraverse(cur.left);
			postTraverse(cur.right);
			System.out.println(cur.data);
		}
	}
	// duyệt cây theo thứ tự giữa (trung thứ tự)
	public void inTraverse() {
		inTraverse(root);
	}

	public void inTraverse(Node cur) {
		if (cur != null) {
			inTraverse(cur.left);
			System.out.print(cur.data + " ");
			inTraverse(cur.right);
		}
	}
	
	public int height(Node currentNode){
		if(root == null){
			return 0;
		}
		else {
			int leftHeight = 0, rightHeight = 0;
			if (currentNode.left != null)
				leftHeight = height(currentNode.left);

			if (currentNode.right != null)
				rightHeight = height(currentNode.right);

			int max = Math.max(leftHeight, rightHeight);

			return (max + 1);
		}
	}
	public int isRepresentingBST(int arr[], int N)
	{
		for(int i = 0; i + 1< N; i ++){
			if(arr[i] > arr[i+1]){
				return 0;
			}
		}
		return 1;
	}
	//due to how inorder traversal works/how binary tree is structured, the inorder traverse gives us a non-decreasing list.
	

	public static void main(String[] args) {
		SimpleBST<Integer> bst =  new SimpleBST<>();
		
		int[] data = {5,6,7,1,2,3,8,6,9,0};
		for(int i = 0 ; i < data.length ; i++)
			bst.insert(data[i]);
		
		System.out.println("All element in tree:");
		int[] t = new int[data.length];
		int id = 0;
		for(int d:bst)
		{
			t[id] = d;
			id++;
		}
		
		Arrays.sort(t);
		for(int d:t)
		{
			System.out.print(d+" ");
		}
		
		System.out.println("");
		System.out.println("Size of tree = "+bst.size());
		
		System.out.println("Search key = 4> "+ bst.search(4));
		System.out.println("Search key = 6> "+bst.search(6));
		
		System.out.println("Pre-order tree traversal");
		bst.preTraverse();
		System.out.println("Post-order tree traversal");
		bst.postTraverse();
		System.out.println("In-order tree traversal");
		bst.inTraverse();
		System.out.println("height of the tree: " + bst.height(bst.root));
		System.out.println(bst.isRepresentingBST(t, t.length));
	}
	
	
	
}