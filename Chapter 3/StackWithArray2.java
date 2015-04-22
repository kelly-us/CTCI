package CTCI.Chapter3;

public class StackWithArray2 {
	int default_size = 4;
	int n = 3;
	StackData[] stacks = {new StackData(0, default_size), 
							new StackData(default_size, default_size), 
							new StackData(default_size * 2, default_size)
	};
	int total_size = default_size * n;
	int[] buffer = new int[total_size];
	
	
	public int previousElem(int elem){
		if(elem == 0) return total_size - 1;
		else return elem - 1;
	}
	
	public int nextElem(int elem){
		if(elem + 1 == total_size) return 0;
		else return elem + 1;
	}
	
	
	public void push(int idx, int val) throws Exception{
		
	}
	
	public int pop(int idx) throws Exception{
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
}
