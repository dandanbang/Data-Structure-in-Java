/*
 *          File: Test.java
 *        Author: Daniel Wei-Hsuan. Chen <dnnl8017@uw.edu>
 * Last Modified: Febuary 6th, 2014
 *         Topic: Testing the code
 * ----------------------------------------------------------------
 * This code tests the Binary Heap, Tree Heap, and MyPQ implementation 
 */ 

class Test {
    public static void main(String[] args) {
		
    	//BinaryHeap priorityQ = new BinaryHeap(); 
    	ThreeHeap priorityQ = new ThreeHeap();
    	//MyPQ priorityQ = new MyPQ();
   
		// System.out.println(priorityQ.deleteMin()); //Testing if an exception is thrown when there's nothing in the heap
    	// System.out.println(priorityQ.findMin()); //Testing if an exception is thrown when there's nothing in the heap
//		System.out.println(priorityQ.size()); // Testing if the size is zero in the beginning
    	
    	priorityQ.insert(2.3);
		priorityQ.insert(1.3);
		priorityQ.insert(0.3);
		priorityQ.insert(0.3);
		priorityQ.insert(0.2);
		priorityQ.insert(4983.8);
		priorityQ.insert(81234.9);
		// Testing the make empty function
//		//System.out.println(priorityQ.makeEmpty());
		priorityQ.insert(3.3);
		priorityQ.insert(4.6);
		priorityQ.insert(77.7);
		priorityQ.insert(934.2);
		priorityQ.insert(5.5);
		priorityQ.insert(2.2);
//		//priorityQ.insert("adijd"); // Testing cases with different type of input
		System.out.println(priorityQ.size());
//		//System.out.println(priorityQ.DECAP());  //Testing whether size are double in binary heap and threeheap
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.size());
		System.out.println(priorityQ.findMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.isEmpty());
		System.out.println(priorityQ.findMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.deleteMin());
		System.out.println(priorityQ.isEmpty()); // Testing the isEmpty function
		System.out.println(priorityQ.findMin()); // testing the findmin when heap is empty
		System.out.println(priorityQ.deleteMin()); // testing the deleteMin when heap is empty
    }
}