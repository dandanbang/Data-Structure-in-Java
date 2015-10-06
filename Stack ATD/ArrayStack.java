/*
 *          File: ArrayStack.java
 *        Author: Daniel Wei-Hsuan. Chen <dnnl8017@uw.edu>
 * Last Modified: Jan 1, 2014
 *         Topic: Stack - Array Implementation
 * ----------------------------------------------------------------
 * This code uses array to implement the DStack interface 
 */ 


import java.util.EmptyStackException;
	
public class ArrayStack implements DStack {
		
	private int DECAP;  //This is the size of the array
	private double[] stack; 
	private int topIndex; //Indicates the index of the top of the array
	
	// Constructor initializes the variables
	public ArrayStack() {
		DECAP = 10; // set the default capacity of the array to 10
		stack = (double[]) new double[DECAP];
		topIndex = -1; // set the topIndex to be -1 as the array is empty initially
	}
	
	@Override
	// This method checks if the array is empty
	public boolean isEmpty() {
		if (topIndex == -1)
			return true; // return true if topIndex = 1
		else
			return false;
	}
	
	// This method checks if the array is full
	public boolean isFull() {
		if (topIndex == (stack.length - 1)) // return true if topIndex equals the size of the array
			return true;
		else 
			return false;
	}
	
	/* This method will insert the element onto the top of the stack if the stack is not
	 * full and increment the index. If it's full, it will double the size of the array
	 * and increment the index then insert the element 
	 */
	@Override
	public void push(double d) {
		if (isFull()) {
			double[] newStack = (double[]) new double[DECAP*2]; // create a new stack which size is double
			for(int i = 0; i< DECAP; i++) { // move the element in the old stack to the new stack
				newStack[i] = stack[i];	
			}
			DECAP = DECAP*2; // double the original capacity
			stack = newStack;
		}
		topIndex++;
		stack[topIndex] = d;
	}
	
	// This method will return the element on the top of the stack and decrement the Index
	@Override
	public double pop() {
		if (!isEmpty()) {
			double top = stack[topIndex];
			topIndex--; 
			return top;
		} else {
			throw new EmptyStackException(); //"Pop attempted on an empty stack");
		}
	}

	
	// This method will return the element on the top of the stack
	@Override
	public double peek() {
		if (!isEmpty()) { // return the element on the top of the stack is it's not empty
			return stack[topIndex];	
		} else {
			throw new EmptyStackException(); //"Pop attempted on an empty stack");
		}
	}

}
