package CTCI.Chapter2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import CTCI.CTCILibrary.AssortedMethods;
import CTCI.CTCILibrary.ListNode;
//C2-2.1
public class removeDup {

	/*
	 * 
	[solution]
	With extra buffer: use a hashset to store the element and  remove the dup if it already exists in the hashset
	Without extra buffer: use two pointers, one to indicate the current element, one to iterate through the rest of the linkedlist to remove dup.
	[time]O(N) or O(N^2)
	[space]O(N) or O(1)
	 */
	public static void removeDuplicate(ListNode head){
		if(head == null || head.next == null) return;
		
		Set<Integer> s = new HashSet<Integer>();
		ListNode cur = head;
		ListNode prev = null;
		while(cur != null){
			if(!s.contains(cur.data)){
				s.add(cur.data);
				prev = cur;
			}
			else{
				prev.next = cur.next;
			}
			cur = cur.next;
		}
		
	}
	
	//Follow up
	public static void removeDuplicate_runner(ListNode head){
		if(head == null || head.next == null) return;
		
		ListNode cur = head;
		while(cur != null){
			ListNode runner = cur;
			while(runner.next != null){
				if(runner.next.data == cur.data){
					runner.next = runner.next.next;
				}
				else{
					runner = runner.next;
				}
			}
			cur = cur.next;
			
		}
	}
	
	public static void main(String[] args){
		ListNode head = AssortedMethods.randomLinkedList(30, 0, 2);
		System.out.println(head.printForward());
		ListNode clone = head.clone();
		removeDuplicate(head);
		System.out.println(head.printForward());
		removeDuplicate_runner(clone);
		System.out.println(clone.printForward());
	}
	
}


