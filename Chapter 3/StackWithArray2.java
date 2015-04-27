package CTCI.Chapter3;

import CTCI.CTCILibrary.AssortedMethods;

//C3-3.1
public class StackWithArray2 {
	static int default_size = 4;
	static int n = 3;
	static StackData[] stacks = {new StackData(0, default_size), 
							new StackData(default_size, default_size), 
							new StackData(default_size * 2, default_size)
	};
	static int total_size = default_size * n;
	static int[] buffer = new int[total_size];
	
	
	public static int previousElem(int elem){
		if(elem == 0) return total_size - 1;
		else return elem - 1;
	}
	
	public static int nextElem(int elem){
		if(elem + 1 == total_size) return 0;
		else return elem + 1;
	}
	
	public static int numberOfElem(){
		return stacks[0].size + stacks[1].size + stacks[2].size;
	}
	
	public static void shift(int idx){
		StackData s = stacks[idx];
		if(s.size >= s.capacity){
			shift((idx + 1) % n);
			s.capacity++;
		}
		
		for(int i = (s.start + s.capacity -1) % total_size;
				s.isWithinStack(i, total_size);
				i = previousElem(i)){
			buffer[i] = buffer[previousElem(i)];
		}
		buffer[s.start] = 0;
		s.start = nextElem(s.start);
		s.pointer = nextElem(s.pointer);
		s.capacity--;
	}
	
	public static void expand(int idx){
		shift((idx + 1) % n);
		stacks[idx].capacity++;
	}
	
	
	public static void push(int idx, int val) throws Exception{
		StackData s = stacks[idx];
		if(s.size >= s.capacity){
			if(numberOfElem() >= total_size){
				throw new Exception("out of space");
			}else{
				expand(idx);
			}
		}
		
		s.size++;
		s.pointer = nextElem(s.pointer);
		buffer[s.pointer] = val;
	}
	
	public static int pop(int idx) throws Exception{
		StackData s = stacks[idx];
		if(s.size == 0){
			throw new Exception("Trying to pop an empty stack");
		}
		int ret = buffer[s.pointer];
		buffer[s.pointer] = 0;
		s.pointer = previousElem(s.pointer);
		s.size--;
		return ret;
	}
	
	public static int peek(int idx){
		StackData s = stacks[idx];
		return buffer[s.pointer];
	}
	
	public static boolean isEmpty(int idx){
		StackData s = stacks[idx];
		return s.size == 0;
	}
	
	
	public static void main(String [] args) throws Exception  {
		push(0, 10);
		push(1, 20);
		push(2, 30);
		
		push(1, 21);
		push(0, 11);
		push(0, 12);
		
		pop(0);
		
		push(2, 31);
		
		push(0, 13);
		push(1, 22);
		
		push(2, 31);
		push(2, 32);
		push(2, 33);
		push(2, 34);

		System.out.println("Final Stack: " + AssortedMethods.arrayToString(buffer));
		
		pop(1);
		push(2, 35);
		
		System.out.println("Final Stack: " + AssortedMethods.arrayToString(buffer));
	}
}
