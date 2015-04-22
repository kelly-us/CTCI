package CTCI.Chapter3;

import java.util.Stack;


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
}
