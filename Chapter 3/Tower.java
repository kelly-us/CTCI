package CTCI.Chapter3;

import java.util.Stack;


public class Tower {

	int index;
	Stack<Integer> disks;
	
	public Tower(int idx){
		index = idx;
		disks = new Stack<Integer>();
	}
	
	//the disk is indexed as d
	public void add(int d){
		if(!disks.isEmpty() && disks.peek() <= d){
			System.out.println("Error placing disk " + d);
		}else{
			disks.push(d);
		}
	}
	
	public void moveDisk(int n, Tower destination, Tower buffer){
		
	}
	
	
	public static void main(String[] args){
		int n = 3;
		Tower[] towers = new Tower[3];
		for(int i = 0; i < 3; i++){
			towers[i] = new Tower(i);
		}
		
		for(int i = n-1; i >= 0; --i){
			towers[0].add(i);
		}
		
		towers[0].moveDisk(n, towers[2], towers[1]);
	}
}
