1. How did you test that your stack implementations were correct?

On top of using the Reverse.java file to test that the file was successfully reversed. I have written a 10 line .dat file to test my stack implementation with a sampling rate of 88.2 kHz and have input random value between -1.0 and 1.0 in the second column. The output .dat file gives me the reverse order of input file. 

I have also tested a few cases (part of the code attached in the extracredit zip file) that are not tested in the Reverse.java program. Besides pushing a bunch of elements into the array/linked list and then popping them all off. I have tried cases like
Empty Input:
1) Popping the elements when the array/linked list is empty
2) Peeking the element when the array/linked list is empty
3) Push a few numbers and then pop them off to see if it’s the expected value
4) Push a class instead of double into the array/linked list

2. The file secret.wav is a backwards recording of a word or short phrase. Use sox (or another converter) and your program to reverse it, and write that as the answer to this question.

The scent of the bitter almonds always reminded him of the faith of unrequited love.

3. Your array stacks start with a small array and double in size if they become full. For a .dat file with 1 million lines, how many times would this resizing occur? What about with 1 billion lines or 1 trillion lines (assuming the computer had enough memory)? Explain your answer.

1 million lines: The resizing would have occurred 20 times. 
1 billion lines: The resizing would have occurred 30 times.
1 trillion lines: The resizing would have occurred 40 times.

There are one element we push onto the stack in each row (The value on the second column) so if there are a million row in the file.
It would require n times of resizing. By solving the n in 2^n = 1,000,000, we would get 20 as the number of the times of resizing. 
By following the same logic, we would get 30 for a billion lines and 40 for a trillion lines.

4. Suppose that, instead of a DStack interface, you were given a fully-functional FIFO Queue class. How might you implement this project (i.e., simulate a Stack) with one or more instances of a FIFO Queue? 
 Write pseudocode for your push and pop operations. Refer to the Written-Homework Guidelines for instructions on writing pseudocode. Assume your Queue class provides the operations enqueue,dequeue, isEmpty, and size.

void push (element d)
{
  queue.enqueue(d); //Insert the element d in the queue
}


public double pop ()
{
  n = queue.size(); // set the variable n to the size of the queue
  
  for (i from 0 to n - 2) //Loop through the queue and move the element in the front to the back from index 0 to Index n - 2
  {
    queue_element = queue.dequeue ();
    queue.enqueue (queue_element);
  }
  element = queue.dequeue(); // now store the element in the front of the queue then remove the element
  return element; // return the element that was stored in the last step
}

5. In the previous question, what trade-offs did you notice between a Queue implementation of a Stack and your original array-based implementation? Which implementation would you choose, and why?

If we do the dequeue, enqueue operation in the pop function, then it will have a execution growth upperbound of O(n) where n is the length of the queue, and the push operation will have O(1) time bound.

If we do the array-based implementation in the pop function, then it will have an execution growth upper bound of O(1), and the push operation would have O(n) time bound. 

We’ve noticed that the trade-offs between a Queue implementation of a Stack and the array-based implementation are that pop causes more processing time in Queue implementation whereas push causes more time in Array-based implementation. I would choose Queue implementation if the program performs more push operations and choose Array-based implementation if the program performs more pop operations.


7. What did you enjoy about this assignment? What did you not enjoy? What could you have done better?

I enjoyed how this assignment teaches me the concept of the abstract data type (Stack) vs. the different types of data type implementations. I can now fully grasp the concept of the stack and its operation at a logical level as well as understanding the algorithms for implementing stack operations using array and linked list. 

However, there are some parts of the assignment I think could be improved to make the assignment a better learning process. If the purpose of the assignment and the concepts of Stack ADT and array/linked list implementation could be explained better in the lecture, then I would have a better time understanding why we are doing what we are doing in this assignment.

8. What else, if anything, would you would like to include related to this homework?
I would like to include more applications of the stack implementation in the file that’s related to the homework.

