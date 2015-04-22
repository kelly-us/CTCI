package CTCI.Chapter2;

import CTCI.CTCILibrary.ListNode;

//C2-2.4
public class split {

	/*
	 * ¡¾solution¡¿
		Maintain two dummy nodes to track the less than sublist and greater than or equal to sublist. 
		In the end, merge the two sublists.
		¡¾time¡¿
		O(n)
		¡¾space¡¿
		O(1)
	 */
	public ListNode splitList(ListNode head, int x){
		if(head == null) return null;
		
		ListNode before = null;
		ListNode after = null;
		
		//partition list
		ListNode cur = head;
		while(cur != null){
			ListNode next = cur.next;
			if(cur.data < x){
				cur.next = before;
				before = cur;
			}
			else{
				cur.next = after;
				after = cur;
			}
			cur = next;
		}
		
		//Missing
		if(before == null) return after;
		
		//merge
		head = before;
		while(before.next != null){
			before = before.next;
		}
		before.next = after;
		return head;
	}
}
