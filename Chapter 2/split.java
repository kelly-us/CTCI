package CTCI.Chapter2;

import CTCI.CTCILibrary.ListNode;

//C2-2.4
public class split {

	/*
	 * [solution]
		Maintain two dummy nodes to track the less than sublist and greater than or equal to sublist. 
		In the end, merge the two sublists.
		[time]
		O(n)
		[space]
		O(1)
	 */
	public static ListNode splitList(ListNode head, int x){
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
	
	public static void main(String args[]){
		int length = 10;
		ListNode[] nodes = new ListNode[length];
		for(int i = 0; i < length; ++i){
			nodes[i] = new ListNode(i >= length / 2 ? length - 1 - i : i, null, i > 0 ? nodes[i-1] : null);
		}
		
		ListNode head = nodes[0];
		System.out.println(head.printForward());
		ListNode head2 = splitList(head, 3);
		System.out.println(head2.printForward());
	}
}
