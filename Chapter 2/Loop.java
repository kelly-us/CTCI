package CTCI.Chapter2;

import CTCI.CTCILibrary.ListNode;

//C2-2.6
public class Loop {

	/*
	 * 
	[solution]
	a tricky solution from the book: use two pointers, slow runner moves 1 step every time and  fast runner moves 2 step. 
	When the slow runner catches up with the fast runner, the hit point are k steps from the beginning of the loop, 
	where k is the steps between the head node and the beginning of the loop.
	[time]
	O(n)
	[space]
	O(1)
	 */
	public static ListNode findStart(ListNode head){
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
	
	public static void main(String[] args){
		int list_length = 100;
		int k = 10;
		
		//create linked list
		ListNode[] nodes = new ListNode[list_length];
		for(int i = 0; i < list_length; ++i){
			nodes[i] = new ListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		//create loop
		nodes[list_length - 1].next = nodes[list_length - k];
		ListNode loop = findStart(nodes[0]);
		
		if(loop == null){
			System.out.println("No Cycle!");
		}else{
			System.out.println(loop.data);
		}
	}
}
