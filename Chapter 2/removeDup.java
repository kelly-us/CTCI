package CTCI.Chapter2;

import java.util.HashMap;
import CTCI.CTCILibrary.ListNode;
//C2-2.1
public class removeDup {

	/*
	 * 
	[solution]
	With extra buffer: use a hashmap to store the element and  remove the dup if it already exists in the hashmap
	Without extra buffer: use two pointers, one to indicate the current element, one to iterate through the rest of the linkedlist to remove dup.
	[time]O(N) or O(N^2)
	[space]O(N) or O(1)
	 */
	public void removeDuplicate(ListNode head){
		if(head == null || head.next == null) return;
		
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		ListNode cur = head;
		ListNode prev = null;
		while(cur != null){
			if(map.get(cur.data) != true){
				map.put(cur.data, true);
				prev = cur;
			}
			else{
				prev.next = cur.next;
			}
			cur = cur.next;
		}
		
	}
	
	//Follow up
	public void removeDuplicate_runner(ListNode head){
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
		
	}
	
}


