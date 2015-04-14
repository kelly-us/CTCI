package CC150;

import CC150.ListNode;

//C2-2.5
public class addList {

	public ListNode add(ListNode l1, ListNode l2, int carry){
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
	public ListNode addList(ListNode l1, ListNode l2){
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
	
	public ListNode addListHelper(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null) return null;
		ListNode head = addListHelper(l1.next, l2.next);
		
		int sum = l1.data + l2.data + carry;
		ListNode n = new ListNode(sum%10, head);
		carry = sum > 10 ? 1: 0;
		return n;
	}
	
	public int length(ListNode head){
		int res = 0;
		while(head != null) {
			head = head.next;
			res++;
		}
		return res;
	}
	
	public ListNode padList(ListNode head, int length){
		if(head == null || length <= 0) 
			return head;
		for(int i = 0; i < length; i++){
			ListNode n = new ListNode(0, null);
			head = insertBefore(head, n);
		}
		return head;
	}
	
	public ListNode insertBefore(ListNode head, ListNode before){
		if(before == null) return head;
		before.next = head;
		return before;
		
	}
}
