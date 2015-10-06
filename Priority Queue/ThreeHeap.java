/*
 *          File: ThreeHeap.java
 *        Author: Daniel Wei-Hsuan. Chen <dnnl8017@uw.edu>
 * Last Modified: Febuary 6th, 2014
 *         Topic: ThreeHeap - Priority Queue Implementation
 * ----------------------------------------------------------------
 * This code uses ThreeHeap to implement the Priority Queue interface 
 */ 

public class ThreeHeap implements PriorityQueue {

	private int size;  //Keeping track of the last used index
	private int DECAP; //This is the size of the array
	private double[] threeHeap; 
	
	// Constructor initializes the variables
	public ThreeHeap () {	
		DECAP = 10;  //This is the initial size of the array
		threeHeap = (double[]) new double[DECAP];
		size = 0; //Indicates the size and the last used position in the heap
	}

	// an index value to indicate position for the insertion by percolating up
	// the heap and comparing the values
	public int percolateUp(int hole, double val) {
		if (hole % 3 == 2) { // If the given index is a left child
			while(val < threeHeap[hole/3 + 1]) { // If the parent is larger than the given value then make the switch
				threeHeap[hole] = threeHeap[hole/3 + 1]; 
				hole = hole / 3 + 1;
			}
		} else
			while(hole > 1 && val < threeHeap[hole/3]) { // The case of middle child and right child
				threeHeap[hole] = threeHeap[hole/3];
				hole = hole /3;
			}
		return hole;
	}
	
	// This method will take an index value from the insertion method and return
	// an index value to indicate position for the replacement of deleted value by
	// percolating down the heap and comparing the values
	public int percolateDown(int hole, double val){
		int target;
		while (3 * hole <= size) {  
			int left = 3 * hole - 1;
			int middle = 3 * hole;
			int right = 3 * hole + 1; 
			if (right > size || threeHeap[left] < threeHeap[right]) 
				if(threeHeap[left] < threeHeap[middle]) { // If right child does not exist and left is smaller than middle 
				target = left; // set the target to left
				} else
					target = middle; // if left is not smaller than choose middle
			else
				target = right; 
			if (threeHeap[target] < val) { // If the target is smaller than the given value then make the switch
				threeHeap[hole] = threeHeap[target];
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
			newHeap[i] = threeHeap[i];
		}
		DECAP = DECAP*2; // double the original capacity
		threeHeap = newHeap;
	}
	
	// This method returns true when the array is empty, return false otherwise
	@Override
	public boolean isEmpty() {
		if (size == 0) 
			return true; // Return true if the size is zero
		else
			return false;
	}

	// This method returns the current size of the heap
	@Override
	public int size() {
		return size; // Return the current size of the heap
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
			return threeHeap[1]; // Return the min value in the priority queue
		else
			throw new EmptyPQException();
	}

	// This method will take a double value and insert it in the heap
	// according to the priority
	@Override
	public void insert(double x) {
		if (size == (threeHeap.length - 1))
			resize(); // Call resize method when the heap is full
		size++;
		int i = percolateUp(size, x); // find the place to make the insertion
		threeHeap[i] = x;
	}

	// This method will delete the highest priority in the heap
	// and fix the heap structure by finding a replacement value
	@Override
	public double deleteMin() {
		if (!isEmpty()) {
			double ans = threeHeap[1]; // store the min value and return it later
			int hole = percolateDown(1, threeHeap[size]); // find the place to insert the replacement value for the min
			threeHeap[hole] = threeHeap[size];
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
