/*
 *          File: BinaryHeap.java
 *        Author: Daniel Wei-Hsuan. Chen <dnnl8017@uw.edu>
 * Last Modified: Febuary 6th, 2014
 *         Topic: BinaryHeap - Priority Queue Implementation
 * ----------------------------------------------------------------
 * This code uses binary heap to implement the Priority Queue interface 
 */ 
	
public class BinaryHeap implements PriorityQueue {
	
	private int size;  //Keeping track of the last used index
	private int DECAP; //This is the size of the array
	private double[] heap; 
	
	// Constructor initializes the variables
	public BinaryHeap () {
		DECAP = 10;  //This is the initial size of the array
		heap = (double[]) new double[DECAP];
		size = 0; //Indicates the size of the array and the last used index
	}
	
	// This method will take an index value from the insertion method and return
	// an index value to indicate position for the insertion by percolating up
	// the heap and comparing the values
	public int percolateUp(int hole, double val) {
		while(hole > 1 && val < heap[hole/2]) { // if the given index is larger than one and less than it's parents then make a switch
			heap[hole] = heap[hole / 2];
			hole = hole / 2;
		}
		return hole; 
	}
	
	// This method will take an index value from the insertion method and return
	// an index value to indicate position for the replacement of deleted value by
	// percolating down the heap and comparing the values
	public int percolateDown(int hole, double val){
		int target;
		while (2 * hole <= size) { // If the left child is smaller than the current size of array
			int left = 2 * hole; // Define the left children and right children
			int right = left + 1; 
			if (right > size || heap[left] < heap[right]) // If left is smaller than right then set target to right
				target = left;
			else
				target = right;
			if (heap[target] < val) { // If target is smaller than the given value then make the switch
				heap[hole] = heap[target];
				hole = target;
			} else
				break;
		}
		return hole;
	}
	
	// This method double the size of the array when the array is full
	public void resize() {
		double[] newHeap = (double[]) new double[DECAP*2]; // create a new heap which size is double
		for(int i = 0; i< DECAP; i++) { // move the element in the old stack to the new stack
			newHeap[i] = heap[i];	
		}
		DECAP = DECAP*2; // double the original capacity
		heap = newHeap;
	}
	
	// This method returns true when the array is empty, return false otherwise
	@Override
	public boolean isEmpty() {
		if (size == 0) 
			return true;
		else
			return false;
	}
	
	// This method returns the current size of the heap
	@Override
	public int size() {
		return size;
	}
	
	// This method returns the current capacity of the array and it's written for
	// testing
	public int DECAP() {
		return DECAP;
	}
	
	// This method will return the highest priority in the queue
	@Override
	public double findMin() {
		if (!isEmpty()) 
			return heap[1];
		else
			throw new EmptyPQException();
	}

	// This method will take a double value and insert it in the heap
	// according to the priority
	@Override
	public void insert(double x) {
		if (size == (heap.length - 1)) // Call resize method if the heap is full
			resize();
		size++;
		int i = percolateUp(size, x); // find the place to make the insertion
		heap[i] = x;
	}

	// This method will delete the highest priority in the heap
	// and fix the heap structure by finding a replacement value
	@Override
	public double deleteMin() {
		if (!isEmpty()) {
			double ans = heap[1]; // store the min value and return it later
			int hole = percolateDown(1, heap[size]); // find the place to insert the replacement value for the min
			heap[hole] = heap[size];
			size--;
			return ans;
		} else
			throw new EmptyPQException();
	}

	// This method will make the array empty
	@Override
	public void makeEmpty() {
		size = 0;
	}
}
