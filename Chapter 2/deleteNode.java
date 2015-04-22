package CTCI.Chapter2;

import CTCI.CTCILibrary.ListNode;

//C2-2.3
public class deleteNode {

	/*
	 * 
	¡¾solution¡¿
	if the node to be deleted is the last node of the linked list, return false, 
	otherwise, copy the elem of the next node to the current node and delete the next node
	¡¾time¡¿
	O(1)
	¡¾space¡¿
	O(1)
	 */
	public boolean delete(ListNode n){
		if(n == null || n.next == null) return false;
		
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
	
}
