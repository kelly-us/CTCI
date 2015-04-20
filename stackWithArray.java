package CC150;

public class stackWithArray {
	//fix division
	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {-1, -1, -1};
	
	public void push(int val, int stackIndex) throws Exception{
		if(stackPointer[stackIndex] + 1 >= stackSize){
			throw new Exception("Out of space");
		}
		
		stackPointer[stackIndex]++;
		buffer[absTopOfStack(stackIndex)] = val;
	}
	
	public int pop(int stackIndex) throws Exception{
		if(stackPointer[stackIndex] == -1){
			throw new Exception("Trying to pop an empty stack");
		}
		
		int ret = buffer[absTopOfStack(stackIndex)];
		buffer[absTopOfStack(stackIndex)] = 0;
		stackPointer[stackIndex]--;
		return ret;
	}
	
	public boolean isEmpty(int stackIndex){
		return stackPointer[stackIndex] == -1;
	}
	
	public int peek(int stackIndex){
		return buffer[absTopOfStack(stackIndex)];
	}
	
	
	
	public int absTopOfStack(int stackIndex){
		return stackIndex * stackSize + stackPointer[stackIndex];
	}

}

