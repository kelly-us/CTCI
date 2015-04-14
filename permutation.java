package CC150;

import java.util.Arrays;

//C1-1.3
public class permutation {

	//string permutation??anagram comparison is case sensitive and whitespace significant
	public boolean isPerm(String s, String t){
		if(s == null || t == null || s.length() != t.length()) return false;
		
		return sort(s).equals(sort(t));
	}
	
	public String sort(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	//char can cover all Unicode character
	/*
	 * 
	[solution]
	use one array of size 256 to count the occurence of each ascii char in
	both string. 

	[time complexity]
	O(n)

	[space complexity]
	O(1)
	 */
	public boolean isPerm_count(String s, String t){
		if(s == null || t == null || s.length() != t.length()) return false;
		
		int[] count = new int[256];
		
		char[] s_array = s.toCharArray();
		for(char c : s_array){
			count[c]++;
		}
		
		char[] t_array = t.toCharArray();
		for(char c: t_array){
			count[c]--;
			if(count[c] < 0){
				return false;
			}
		}
		
		return true;
	}
}
