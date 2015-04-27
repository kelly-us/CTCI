package CTCI.Chapter2;

import CTCI.CTCILibrary.AssortedMethods;
import CTCI.CTCILibrary.ListNode;

//C2-2.3
public class deleteNode {

	/*
	 * 
	[solution]
	if the node to be deleted is the last node of the linked list, return false, 
	otherwise, copy the elem of the next node to the current node and delete the next node
	[time]
	O(1)
	[space]
	O(1)
	 */
	public static boolean delete(ListNode n){
		if(n == null || n.next == null) return false;
		
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
	
	public static void main(String[] args){
		ListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		
		delete(head.next.next.next);
		System.out.println(head.printForward());
	}
	
}
