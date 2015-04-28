package CTCI.Chapter3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import CTCI.CTCILibrary.AssortedMethods;

//C3-3.5
/*
 * [solution]
when adding x to the queue, just push it to the first stack.
when removing from the queue:
1)if the second stack is not empty, directly pop from the second stack
2)else if the first stack is not empty, shift all elements to the second stack, and pop from the second stack
3)else throw exception
[time]
add O(1), remove and peek operates in O(n)
[space]
O(n)
[gist]
https://gist.github.com/kelly-us/ca1854a0b3d928a2db46
 */
public class MyQueue<T> {
	Stack<T> s1, s2;
	
	public MyQueue(){
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public void add(T val){
		s1.push(val);
	}
	
	public int size(){
		return s1.size() + s2.size();
	}
	
	public void shiftStacks(){
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
	}
	
	public T remove(){
		shiftStacks();
		return s2.pop();
	}
	
	public T peek(){
		shiftStacks();
		return s2.peek();
	}
	
	public static void main(String[] args){
		MyQueue<Integer> my_queue = new MyQueue<Integer>();	
		
		// Let's test our code against a "real" queue
		Queue<Integer> test_queue = new LinkedList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			int choice = AssortedMethods.randomIntInRange(0, 10);
			if (choice <= 5) { // enqueue
				int element = AssortedMethods.randomIntInRange(1, 10);
				test_queue.add(element);
				my_queue.add(element);
				System.out.println("Enqueued " + element);
			} else if (test_queue.size() > 0) {
				int top1 = test_queue.remove();
				int top2 = my_queue.remove();
				if (top1 != top2) { // Check for error
					System.out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
				} 
				System.out.println("Dequeued " + top1);
			}
			
			if (test_queue.size() == my_queue.size()) {
				if (test_queue.size() > 0 && test_queue.peek() != my_queue.peek()) {
					System.out.println("******* FAILURE - DIFFERENT TOPS: " + test_queue.peek() + ", " + my_queue.peek() + " ******");
				}
			} else {
				System.out.println("******* FAILURE - DIFFERENT SIZES ******");
			}
		}
	}
}
