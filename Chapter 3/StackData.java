package CTCI.Chapter3;

//C3-3.1
public class StackData {

	int start;
	int capacity;
	int pointer;
	int size = 0;
	
	public StackData(int _start, int _capacity){
		this.start = _start;
		pointer = _start - 1;
		this.capacity = _capacity;
	}
	
	public boolean isWithinStack(int index, int total_size){
		if(start <= index && index < start + capacity){
			return true;
		}else if(start + capacity > total_size && 
				index < (start + capacity) % total_size){
			return true;
		}
		return false;
	}
}
