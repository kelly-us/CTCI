package CC150;

public class ListNode {

	int data;
	ListNode next;
	public ListNode(){
		
	}
	
	public ListNode(int val, ListNode n){
		data = val;
		next = n;
	}
	
	public ListNode(int val){
		data = val;
		next = null;
	}
}
