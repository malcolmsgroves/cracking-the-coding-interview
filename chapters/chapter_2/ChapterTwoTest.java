package chapter_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChapterTwoTest {

	@Test
	void deleteDuplicates() {
		Solution.LinkedList list = new Solution.LinkedList();
		
		for(int i = 0; i < 25; ++i) {
			for(int j = 0; j <= i; ++j) {
				list.insertLast(j);
			}
		}
		
		Solution.removeDuplicates(list.head);
		
		int count = 0;
		Solution.Node curr = list.head;
		
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
			
			++count;
		}
		
		assertEquals(25, count, "The linked list with 25 different numbers has " + String.valueOf(count) + " nodes");
	}
	
	@Test
	void hasLoop() {
		Solution.Node head = new Solution.Node(0);
		Solution.Node tail = head;
		for(int i = 1; i < 5; ++i) {
			tail.next = new Solution.Node(i);
			tail = tail.next;
		}
		assertFalse(Solution.hasLoop(head));
		
		Solution.Node start = tail;
		for(int i = 5; i < 10; ++i) {
			tail.next = new Solution.Node(i);
			tail = tail.next;
		}
		assertFalse(Solution.hasLoop(head));
		tail.next = start;
		assertTrue(Solution.hasLoop(head));
	}
	
	@Test
	void sumList() {
		int[] nums = new int[] {9, 1, 2};
		Solution.Node head = new Solution.Node(0);
		Solution.Node tail = head;
		for(int i = 0; i < nums.length; ++i) {
			tail.next = new Solution.Node(nums[i]);
			tail = tail.next;
		}
		assertEquals(2190, Solution.sumList(head));
	}

}
