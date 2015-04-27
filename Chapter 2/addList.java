package CTCI.Chapter2;

import CTCI.CTCILibrary.ListNode;

//C2-2.5
public class addList {

	public static ListNode add(ListNode l1, ListNode l2, int carry){
		if(l1 == null && l2 == null && carry == 0) return null;
		
		int sum = carry;
		if(l1 != null) sum += l1.data;
		if(l2 != null) sum += l2.data;
		
		
		ListNode n = new ListNode();
		n.data = sum % 10;
		
		ListNode nn = null;
		if(l1 != null || l2 != null){
			nn = add(l1 != null ? l1.next : null,
				     l2 != null ? l2.next : null,
				     sum >= 10 ? 1 : 0);
		}
		
		n.next = nn;
		return n;
	}
	
	//follow-up
	public static int carry = 0;
	public static ListNode add_2(ListNode l1, ListNode l2){
		int len1 = length(l1);
		int len2 = length(l2);
		
		if(len1 < len2){
			l1 = padList(l1, len2-len1);
		}
		else{
			l2 = padList(l2, len1-len2);
		}
		ListNode head = null;
		head = addListHelper(l1, l2);
		if(carry == 0){
			return head;
		}
		else{
			ListNode n = new ListNode(carry, null);
			return insertBefore(head, n);
		}
		
	}
	
	public static ListNode addListHelper(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null) return null;
		ListNode head = addListHelper(l1.next, l2.next);
		
		int sum = l1.data + l2.data + carry;
		ListNode n = new ListNode(sum % 10, head);
		carry = sum >= 10 ? 1: 0;
		return n;
	}
	
	public static int length(ListNode head){
		int res = 0;
		while(head != null) {
			head = head.next;
			res++;
		}
		return res;
	}
	
	public static ListNode padList(ListNode head, int length){
		if(head == null || length <= 0) 
			return head;
		for(int i = 0; i < length; i++){
			ListNode n = new ListNode(0, null);
			head = insertBefore(head, n);
		}
		return head;
	}
	
	public static ListNode insertBefore(ListNode head, ListNode before){
		if(before == null) return head;
		before.next = head;
		return before;	
	}
	
	public static int linkedListToInt(ListNode n){
		int val = 0;
		if(n.next != null){
			val = 10 * linkedListToInt(n.next);
		}
		return val + n.data;
	}
	
	public static int linkedListToInt_2(ListNode n){
		int val = 0;
		while(n != null){
			val = val * 10 + n.data;
			n = n.next;
		}
		return val;
	}
	
	public static void main(String[] args){
		ListNode lA1 = new ListNode(9, null, null);
		ListNode lA2 = new ListNode(9, null, lA1);
		ListNode lA3 = new ListNode(9, null, lA2);
		
		ListNode lB1 = new ListNode(1, null, null);
		ListNode lB2 = new ListNode(0, null, lB1);
		ListNode lB3 = new ListNode(0, null, lB2);	
		
		ListNode list3 = add(lA1, lB1, 0);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());
		
		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);
		
		System.out.println(l1 + " + " + l2 + " = " + l3);
		System.out.println(l1 + " + " + l2 + " = " + (l1 + l2));	
		
		ListNode list4 = add_2(lA1, lB1);
		int l11 = linkedListToInt_2(lA1);
		int l12 = linkedListToInt_2(lB1);
		int l13 = linkedListToInt_2(list4);
		
		System.out.println("= " + list4.printForward());
		
		System.out.println(l11 + " + " + l12 + " = " + l13 );
		System.out.println(l11 + " + " + l12 + " = " + (l11 + l12));	
	}
}
