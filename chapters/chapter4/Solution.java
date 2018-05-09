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
	
	public static boolean isBalanced(Node root) {
		if(root == null) return true;
		if(root.left == null && root.right == null ||
		   root.left == null && root.right.right == null && root.right.left == null ||
		   root.right == null && root.left.left == null && root.left.right == null) {
			return true;
		}
		if(root.left == null || root.right == null) {
			return false;
		}
		
		return isBalanced(root.left) && isBalanced(root.right); 
	}
	
	public static boolean isBSTHelper(Node root, Integer min, Integer max) {
		if(root == null) return true;
		if (min != null && root.data < min ||
			max != null && root.data > max) {
			return false;
		}
		return isBSTHelper(root.left, min, root.data) && isBSTHelper(root.right, root.data, max);
	}
	
	public static boolean isBST(Node root) {
		if(root == null) return true;
		return isBSTHelper(root.left, null, root.data) && isBSTHelper(root.right, root.data, null); 
	}
	
	public static int countSumsHelper(Node root, int n, int sum) {
		if(root == null) return 0;
		int isSum = root.data + sum == n ? 1 : 0;
		return  isSum + 
				countSumsHelper(root.left, n, sum + root.data) +
				countSumsHelper(root.right, n, sum + root.data);
	}
	
	public static int countSums(Node root, int n) {
		if(root == null) return 0;
		return countSums(root.left, n) +
				countSumsHelper(root, n, 0) +
				countSums(root.right, n);
	}

}
