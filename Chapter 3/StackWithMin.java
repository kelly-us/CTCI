package CTCI.Chapter3;

import java.util.Stack;

import CTCI.CTCILibrary.AssortedMethods;

//C3-3.2
/*
 * 
[solution]
use an additional min_stack to keep track of the min elements. when pushing number x to the stack, push x to min_stack if:
1)min_stack is empty
2)x is less or equal to the top of min_stack
when popping an element from stack, pop it from min_stack if:
1) x is equal to the top of min_stack
[time]
O(1)
[space]
O(n)
 */
public class StackWithMin extends Stack<Integer>{
	Stack<Integer> s;
	
	public StackWithMin(){
		s = new Stack<Integer>();
	}
	
	public void push(int val){
		if(val <= min()){
			s.push(val);
		}
		super.push(val);
	}
	
	public Integer pop(){
		int ret = super.pop();
		if(ret == min()){
			s.pop();
		}
		return ret;
	}
	
	public int min(){
		if(s.isEmpty()){
			return Integer.MAX_VALUE;
		}
		return s.peek();
	}
	
	public static void main(String args[]){
		StackWithMin s = new StackWithMin();
		for(int i = 0; i < 15; ++i){
			int value = AssortedMethods.randomIntInRange(0, 100);
			s.push(value);
			System.out.print(value + ", ");
		}
		System.out.println("");
		for(int i = 0; i < 15; ++i){
			System.out.println("poped " + s.pop());
			System.out.println("New min is " + s.min());
		}
	}
}
