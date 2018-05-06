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

}
