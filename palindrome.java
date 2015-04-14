package CC150;

import java.util.Stack;
//Chapter2-2.7
public class palindrome {

	//iterative
	public boolean isPalindrome(ListNode head){
		if(head == null || head.next == null) return true;
		Stack<Integer> s = new Stack<Integer>();
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null){
			s.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null){
			slow = slow.next;
		}
		
		while(slow != null){
			int top = s.pop().intValue();
			if(top != slow.data) return false;
			slow = slow.next;
		}
		
		return true;
	}
	
	//recursive
	public boolean ans = true;
	public boolean isPalindrome_recursive(ListNode head){
		if(head == null || head.next == null) return true;
		
		int len = length(head);
		ListNode n = isPalindromeHelper_recursive(head, len);
		return ans;
		
	}
	
	public ListNode isPalindromeHelper_recursive(ListNode head, int len){
		if(head == null || len == 0){
			return head;
		}
		
		if(len == 1){
			return head.next;
		}
		
		ListNode n = isPalindromeHelper_recursive(head.next, len - 2);
		if(head.data != n.data) ans = false;
		
		return n.next;
	}
	
	public int length(ListNode head){
		int res = 0;
		while(head != null){
			res++;
			head = head.next;
		}
		return res;
	}
	
}
