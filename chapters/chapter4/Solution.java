package chapter4;

public class Solution {
	
	public static class Node {
		public Node left, right;
		public int data;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	// 4.2 minimal tree
	public static Node buildBSTHelper(int[] arr, int lo, int hi) {
		if(lo > hi) {
			return null;
		}
		int mid = (hi - lo) / 2 + lo;
		Node node = new Node(arr[mid]);
		node.left = buildBSTHelper(arr, lo, mid - 1);
		node.right = buildBSTHelper(arr, mid + 1, hi);
		return node;
	}
	
	public static Node buildBST(int[] arr) {
		return buildBSTHelper(arr, 0, arr.length - 1);
	}
	
	public static int height(Node root) {
		if(root == null) {
			return -1;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return 1 + (leftHeight < rightHeight ? rightHeight : leftHeight);
	}
	
	

}
