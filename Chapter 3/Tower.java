package CTCI.Chapter3;

import java.util.Stack;

//C3-3.4
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
	
	public void moveTopTo(Tower t){
		int top = disks.pop();
		t.add(top);
	}
	
	//use stack to mimic the recursive process, each push represent a condition
	 /*
	 struct op{
	 	int begin, end;
	 	int src, bri, dst;
	 }

	 void hanoi(int n, int src, int bri, int dst){
	 	stack<op> s;
	 	s.push(op(1, n, src, bri, dst));
	 	while(!s.isEmpty()){
	 		op tmp = s.peek();
	 		s.pop();
	 		if(tmp.begin != tmp.end){
	 			s.push(op(tmp.begin, tmp.end - 1, tmp.bri, tmp.src, tmp.dst));
	 			s.push(op(tmp.end, tmp.end, tmp.src, tmp.bri, tmp.dst));
	 			s.push(op(tmp.begin, tmp.end - 1, tmp.src, tmp.dst, tmp.bri));
	 		}else{
	 			System.out.println("Move disk " + tmp.begin + " from " + tmp.src + " to " + tmp.dst);
	 		}
	 	}
	 }
	 	
	 */
	
	public void moveDisk(int n, Tower destination, Tower buffer){
		if(n > 0){
			System.out.println("move " + n + "disks from " + index + " to " + buffer.index + " with buffer " + destination.index);
			moveDisk(n - 1, buffer, destination);
			System.out.println("move top from " + index + " to " + destination.index);
			moveTopTo(destination);
			System.out.println("move " + n + "disks from " + index + " to " + destination.index + " with buffer " + buffer.index);
			buffer.moveDisk(n - 1, destination, this);
		}
	}
	
	public void print(){
		System.out.println("contents of tower " + index + " : " + disks.toString());
	}
	
	
	public static void main(String[] args){
		int n = 5;
		Tower[] towers = new Tower[3];
		for(int i = 0; i < 3; i++){
			towers[i] = new Tower(i);
		}
		
		for(int i = n-1; i >= 0; --i){
			towers[0].add(i);
		}
		
		towers[0].print();
		towers[0].moveDisk(n, towers[2], towers[1]);
		towers[2].print();
	}
}
