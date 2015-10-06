/*
 *          File: ListStack.java
 *        Author: Daniel Wei-Hsuan. Chen <dnnl8017@uw.edu>
 * Last Modified: Jan 1, 2014
 *         Topic: Stack - List Implementation
 * ----------------------------------------------------------------
 * This code uses ListStack to implement the DStack interface 
 */ 


import java.util.EmptyStackException;

public class ListStack implements DStack {
	
	// Inner class that implements linked-list node
	public class ListStackNode {
		
		private ListStackNode link; // This is the link of the nodes
		private double info; // This stores the element inside of a nodes
		
		public ListStackNode(double info) {
			this.info = info;
		}
		
		public ListStackNode getLink() {
			return link;
		}
		public void setLink(ListStackNode link) {
			this.link = link;
		}
		public double getInfo() {
			return info;
		}
		public void setInfo(double info) {
			this.info = info;
		}
	}
	
	private ListStackNode top;
	
	public ListStack() {
		top = null; // Set the top of the stack to be null since it's empty initially
	}
	
	@Override
	// This method checks if the list is empty
	public boolean isEmpty() { 
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	// This method will creates a new node to store the element inserted and reset the link
	// to the new node 
	public void push(double d) {
		ListStackNode newNode = new ListStackNode(d); // Create a new node with the given element
		newNode.setLink(top); // Link the new node to the second node in the linked list
		top = newNode; // Set the top to be pointing at the new node
	}
	
	// This method will return the first element in the node
	@Override
	public double pop() {
		if (!isEmpty()) {
			double temp = top.getInfo(); // store the element in the first node to temp and later return it
			top = top.getLink(); // reset the link of the top node
			return temp;
		} else {
			throw new EmptyStackException(); //"Pop attempted on an empty stack");
		}
	}
	
	// This method will return the first element in the node without removing it 
	@Override
	public double peek() {
		if (!isEmpty()) {
			return top.getInfo(); 			
		} else {
			throw new EmptyStackException(); //"Pop attempted on an empty stack");
		}
	}

}
