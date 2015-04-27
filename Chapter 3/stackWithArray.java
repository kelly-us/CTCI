package CTCI.Chapter3;

//C3-3.1
public class stackWithArray {
	//fix division
	static int stackSize = 100;
	static int[] buffer = new int[stackSize * 3];
	static int[] stackPointer = {-1, -1, -1};
	
	public static void push(int stackIndex, int val) throws Exception{
		if(stackPointer[stackIndex] + 1 >= stackSize){
			throw new Exception("Out of space");
		}
		
		stackPointer[stackIndex]++;
		buffer[absTopOfStack(stackIndex)] = val;
	}
	
	public static int pop(int stackIndex) throws Exception{
		if(stackPointer[stackIndex] == -1){
			throw new Exception("Trying to pop an empty stack");
		}
		
		int ret = buffer[absTopOfStack(stackIndex)];
		buffer[absTopOfStack(stackIndex)] = 0;
		stackPointer[stackIndex]--;
		return ret;
	}
	
	public static boolean isEmpty(int stackIndex){
		return stackPointer[stackIndex] == -1;
	}
	
	public static int peek(int stackIndex){
		return buffer[absTopOfStack(stackIndex)];
	}
	
	
	
	public static int absTopOfStack(int stackIndex){
		return stackIndex * stackSize + stackPointer[stackIndex];
	}
	
	public static void main(String args[]) throws Exception{
		push(2, 4);
		System.out.println("Peek 2: " + peek(2));
		push(0, 3);
		push(0, 7);
		push(0, 5);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));
	}

}

