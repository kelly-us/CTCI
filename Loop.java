package CC150;

import CC150.ListNode;

//C2-2.6
public class Loop {

	/*
	 * 
	¡¾solution¡¿
	a tricky solution from the book: use two pointers, slow runner moves 1 step every time and  fast runner moves 2 step. 
	When the slow runner catches up with the fast runner, the hit point are k steps from the beginning of the loop, 
	where k is the steps between the head node and the beginning of the loop.
	¡¾time¡¿
	O(n)
	¡¾space¡¿
	O(1)
	 */
	public ListNode findStart(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		
		if(fast == null || fast.next == null)
			return null;
		
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
}
