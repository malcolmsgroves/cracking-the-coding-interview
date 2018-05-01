package chapter_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChapterTwoTest {

	@Test
	void test() {
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

}
