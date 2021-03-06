package CTCI.Chapter2;

import CTCI.CTCILibrary.AssortedMethods;
import CTCI.CTCILibrary.ListNode;

//C2-2.2 iterative solution is easy, recursive is not
public class kthToLast {

	private static int res = -1;
	public static int kth_recursive(ListNode head, int k){
		if(head == null) return 0;
		int counter = kth_recursive(head.next,k) + 1;
		if(counter == k){
			res = head.data;
		}
		return counter;
	}
	
	
	private static int counter = 0;
	public static ListNode kth_recursive_2(ListNode head, int k){
		if(head == null) return null;
		ListNode n = kth_recursive_2(head.next, k);
		counter++;
		if(counter == k) return head;
		return n;
	}
	
	/*
	 * [solution]
		use two pointers, firstly move fast runner k-1 steps forward, and then move two pointers both one step everytime until the fast runner hit the end, return the slow runner
		[time]
		O(n)
		[space]
		O(1)
	 */
	public static ListNode kthToLastE_iterative(ListNode head, int k){
		if(head == null || k <= 0) return null;
		
		ListNode p1 = head;
		ListNode p2 = head;
		
		for(int i = 0; i < k - 1; i++){
			if(p2 == null) return null;
			p2 = p2.next;
		}
		
		if(p2 == null) return null;
		
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
	
	
	public static void main(String[] args){
		ListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		
		int nth = 3;
		int n1 = kth_recursive(head, nth);
		if(res == -1){
			System.out.println("Null. n is out of bounds");
		}else{
			System.out.println(nth + "th to last element is " + res);
		}
		ListNode n2 = kth_recursive_2(head, nth);
		if(n2 != null)
			System.out.println(n2.data);
		ListNode n3 = kthToLastE_iterative(head, nth);
		if(n3 != null)
			System.out.println(n3.data);
		
	}
}
