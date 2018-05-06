package chapter_3;

import java.util.*;

public class Solution {
	
	public static class Stack {
		
		class StackItem {
			int min;
			int data;
			
			public StackItem(int data, int min) {
				this.min = min;
				this.data = data;
			}
		}
		
		LinkedList<StackItem> stack;
		
		public Stack() {
			stack = new LinkedList<StackItem>();
		}
		
		public void push(int x) {
			if(stack.size() == 0) {
				stack.add(new StackItem(x, x));
			} else {
				int min = stack.getLast().min;
				if(min > x) min = x;
				stack.add(new StackItem(x, min));
			}
		}
		
		public int pop() {
			return stack.removeLast().data;
		}
		
		public int min() {
			return stack.getLast().min;
		}
		
		public int size() {
			return stack.size();
		}
		
		public int peek() {
			return stack.getLast().data;
		}
		
	}
	
	public static class StackQueue {
		Stack in, out;
		
		public StackQueue() {
			in = new Stack();
			out = new Stack();
		}
		
		public void enqueue(int n) {
			in.push(n);
		}
		
		public int dequeue() {
			if(out.size() == 0) {
				while(in.size() > 0) {
					out.push(in.pop());
				}
				if(out.size() == 0) {
					return -1;
				}
			}
			return out.pop();
		}
	}
	
	public static void sort(Stack stack) {
		Stack buffer = new Stack();
		int temp;
		while(stack.size() > 0) {
			temp = stack.pop();
			while(buffer.size() > 0 && buffer.peek() > temp) {
				stack.push(buffer.pop());
			}
			buffer.push(temp);
			while(stack.size() > 0 && buffer.peek() <= stack.peek()) {
				buffer.push(stack.pop());
			}
		}
		
		while(buffer.size() > 0) {
			stack.push(buffer.pop());
		}
	}

}
