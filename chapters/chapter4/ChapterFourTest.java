package chapter4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChapterFourTest {

	@Test
	void equalBST() {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		Solution.Node root = Solution.buildBST(arr);
		assertEquals(Solution.height(root), 3);
	}
	
	@Test
	void isBalanced() {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		Solution.Node root = Solution.buildBST(arr);
		assertTrue(Solution.isBalanced(root));
		root.left = null;
		assertFalse(Solution.isBalanced(root));
	}

	@Test
	void isBST() {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		Solution.Node root = Solution.buildBST(arr);
		assertTrue(Solution.isBST(root));
		root.left.data = -1;
		assertFalse(Solution.isBST(root));
	}
	
	@Test 
	void countSums() {
		Solution.Node root = new Solution.Node(4);
		root.left = new Solution.Node(7);
		root.right = new Solution.Node(-2);
		root.left.left = new Solution.Node(-9);
		root.left.right = new Solution.Node(0);
		assertEquals(2, Solution.countSums(root, 2));
	}
}
