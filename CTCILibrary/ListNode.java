package CTCI.CTCILibrary;

public class ListNode {

	public int data;
	public ListNode next;
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
