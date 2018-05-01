package chapter_2;
import java.util.*;

public class Solution {
	
	public static class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		public void removeNext() {
			if(this.next != null) {
				this.next = this.next.next;
			}
		}
	}
	
	public static class LinkedList {
		public Node head;
		public Node tail;
		
		public LinkedList() {
			head = null;
			tail = null;
		}
		
		public void insertLast(int data) {
			Node node = new Node(data);
			if(head == null) {
				head = node;
				tail = node;
			} else {
				tail.next = node;
				tail = tail.next;
			}
		}
		
		public void insertFirst(int data) {
			Node node = new Node(data);
			if(head == null) {
				head = node;
				tail = node;
			} else {
				node.next = head;
				head = node;
			}
			
		}
	}
	
	public static void removeDuplicates(Node head) {
		if(head == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node curr = head;
		set.add(curr.data);
		
		while(curr.next != null) {
			if(set.contains(curr.next.data)) {
				curr.removeNext();
			} else {
				set.add(curr.next.data);
				curr = curr.next;
			}
		}
	}

	
}
