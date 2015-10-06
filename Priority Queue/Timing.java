/*
 *          File: Timing.java
 *        Author: Daniel Wei-Hsuan. Chen <dnnl8017@uw.edu>
 * Last Modified: Febuary 6th, 2014
 *         Topic: Timing of implemntation
 * ----------------------------------------------------------------
 * This code times the run time of the Binary Heap, Tree Heap, and MyPQ implementation 
 */ 

import java.util.Random;

class Timing {
    public static final int NUM_TIMINGS = 5;

    public static void main(String[] args) {
        for(int timing = 0; timing < NUM_TIMINGS; ++timing) {
            long startTime = System.nanoTime();

            // ... The Insertion code being timed ...
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100);
        	BinaryHeap priorityQ = new BinaryHeap();
            //TreeHeap priorityQ = new TreeHeap();
            //MyPQ priorityQ = new MyPQ();
        	
        	int n = 128000;
        	for (int i = 0; i < n; i++){
        		priorityQ.insert(randomInt / 1.0);
        	}
        	        	
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            // 1 second = 1000000000 (10^9) nanoseconds.
            System.out.println("Insertion: " + elapsedTime + " nanoseconds or " + elapsedTime/(1000000000.0) + " seconds elapsed");
        	// The end of insertion timing
            
            // ... The DeleteMin code being timed ...
            long startTime2 = System.nanoTime();
        	for (int i = 0; i < n; i++){
        		priorityQ.deleteMin();
        	}
        
            long endTime2 = System.nanoTime();
            long elapsedTime2 = endTime2 - startTime2;
            // 1 second = 1000000000 (10^9) nanoseconds.
            System.out.println("DeleteMin: " + elapsedTime2 + " nanoseconds or " + elapsedTime2/(1000000000.0) + " seconds elapsed");
            // ... The DeleteMin code being timed ...
        }
    }
}