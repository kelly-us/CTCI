package CTCI.CTCILibrary;

public class ListNode {

	public int data;
	public ListNode next;
	public ListNode prev;
	public ListNode last;
	
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
	
	public ListNode(int val, ListNode n, ListNode p){
		data = val;
		setNext(n);
		setPrevious(p);
	}
	
	public void setNext(ListNode n){
		next = n;
		if(this == last){
			last = n;
		}
		if(n != null && n.prev != this){
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(ListNode p){
		prev = p;
		if(p != null && p.next != this){
			p.setNext(this);
		}
	}
	
	public String printForward(){
		if(next != null){
			return data + "->" + next.printForward();
		}
		else{
			return ((Integer)data).toString();
		}
	}
	
	public ListNode clone(){
		ListNode next2 = null;
		if(next != null){
			next2 = next.clone();
		}
		ListNode head2 = new ListNode(data, next2, null);
		return head2;
	}
}
