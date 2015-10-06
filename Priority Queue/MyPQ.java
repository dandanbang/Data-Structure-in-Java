/*
 *          File: MyPQ.java
 *        Author: Daniel Wei-Hsuan. Chen <dnnl8017@uw.edu>
 * Last Modified: Febuary 6th, 2014
 *         Topic: Sorted LinkedList - Priority Queue Implementation
 * ----------------------------------------------------------------
 * This code uses Sorted LinkedList to implement the Priority Queue interface 
 */ 

public class MyPQ implements PriorityQueue {
	
	// Inner class that implements linked-list node
	public class SortedLinkedListNode {
		
		private SortedLinkedListNode next;
		private double data; // This stores the element inside of a nodes
		
		public SortedLinkedListNode() {
			this(0.0, null);
		}
		
		public SortedLinkedListNode(double data) {
			this(data, null);
		}

		public SortedLinkedListNode(double data, SortedLinkedListNode next){
			this.data = data;
			this.next = next;
		}
		
		public SortedLinkedListNode getNext() {
			return next;
		}

		public double getData() {
			return data;
		}
		
		public void setData(double data) {
			this.data = data;
		}
	}
	
	private SortedLinkedListNode top;
	private int size;
	
	// Constructor initializes the variables
	public MyPQ() {
		top = null; // Set the top of the sorted list to be null since it's empty initially
		size = 0; // Set the initial size to be 0 since it's empty initially
	}
	
	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public double findMin() {
		if (!isEmpty()) 
			return top.getData(); //return the first node in the sorted linked list
		else
			throw new EmptyPQException();
	}

	@Override
	public void insert(double x) {
		size++;
		if (top == null || x <= top.data){ //If top is null then insert into the first node
			top = new SortedLinkedListNode(x, top); 
		} else {
			SortedLinkedListNode current = top;
			while(current.next != null && current.next.data < x) // Iterate through the list to find the place to insert
				current = current.next;
			current.next = new SortedLinkedListNode(x, current.next);
			}
	}

	@Override
	public double deleteMin() {
		if (!isEmpty()) {
			double ans = top.getData(); // Store thr first value in the node and relink the top's link
			top = top.getNext();
			size--;
			return ans;
		} else {
			throw new EmptyPQException();	
		}
	}

	@Override
	public void makeEmpty() {
		top = null;
		size = 0;
	}

}
