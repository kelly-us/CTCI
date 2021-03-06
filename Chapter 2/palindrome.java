package CTCI.Chapter2;

import CTCI.CTCILibrary.ListNode;
import java.util.Stack;
//Chapter2-2.7
public class palindrome {

	//iterative
	/*
	 * 
		[solution]
		use two pointers, slow runner moves one step every time and fast runner moves two steps each time. push the first half of the list into a stack and compare the second half with the pop value of the stack.
		[time]
		O(n)
		[space]
		O(n)
	 */
	public static boolean isPalindrome(ListNode head){
		if(head == null || head.next == null) return true;
		Stack<Integer> s = new Stack<Integer>();
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
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
	public static boolean ans = true;
	public static boolean isPalindrome_recursive(ListNode head){
		if(head == null || head.next == null) return true;
		
		int len = length(head);
		ListNode n = isPalindromeHelper_recursive(head, len);
		return ans;
		
	}
	
	public static ListNode isPalindromeHelper_recursive(ListNode head, int len){
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
	
	public static int length(ListNode head){
		int res = 0;
		while(head != null){
			res++;
			head = head.next;
		}
		return res;
	}
	
	public static void main(String[] args){
		int length = 10;
		ListNode[] nodes = new ListNode[length];
		for(int i = 0; i < length; ++i){
			nodes[i] = new ListNode(i >= length / 2 ? length - 1 - i : i, null, i > 0 ? nodes[i-1] : null);
		}
		
		ListNode head = nodes[0];
		System.out.println(head.printForward());
		
		System.out.println("isPalindrome : " + isPalindrome(head));
		System.out.println(isPalindrome_recursive(head));
		
	}
	
}
