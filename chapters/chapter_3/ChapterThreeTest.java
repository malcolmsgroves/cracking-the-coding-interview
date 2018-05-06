package chapter_3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChapterThreeTest {

	@Test
	void minStack() {
		int[] items = new int[] {8, 5, 3, 4, 9, 2, 4, 6, 5, 1, 8, 10, -1};
		int min = items[0];
		Solution.Stack stack = new Solution.Stack();
		for(int i = 0; i < items.length; ++i) {
			stack.push(items[i]);
			if(items[i] < min) {
				min = items[i];
			}
			assertEquals(min, stack.min());
		}
		
		for(int i = 0; i < 5; ++i) {
			stack.pop();
		}
		
		assertEquals(stack.min(), 2);
	}
	
	@Test
	void stackQueue() {
		Solution.StackQueue queue = new Solution.StackQueue();
		int[] items = new int[] {5, 3, 7, 3, 5, 3, 2, 1, 8, 7, 9, 4, 7, 6, 0};
		for(int i = 0; i < items.length; ++i) {
			queue.enqueue(items[i]);
		}
		for(int i = 0; i < items.length; ++i) {
			assertEquals(items[i], queue.dequeue());
		}
	}
	
	@Test
	void sortStack() {
		Solution.Stack stack = new Solution.Stack();
		int[] items = new int[] {5, 3, 7, 3, 5, 3, 2, 1, 8, 7, 9, 4, 7, 6, 0};
		int[] sortedItems = new int[] {0, 1, 2, 3, 3, 3, 4, 5, 5, 6, 7, 7, 7, 8, 9};
		for(int i = 0; i < items.length; ++i) {
			stack.push(items[i]);
		}
		
		Solution.sort(stack);
		
		for(int i = 0; i < items.length; ++i) {
			System.out.println(String.valueOf(stack.peek()) + ", " + String.valueOf(sortedItems[i]));
			assertEquals(stack.pop(), sortedItems[i]);
		}
	}

}
