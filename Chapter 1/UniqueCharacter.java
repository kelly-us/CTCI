package CTCI.Chapter1;

import java.util.HashSet;
import java.util.Set;

//C1-1.1
//ASCII string or Unicode string
public class UniqueCharacter {
	/*
	 * 
	 * [solution] 1.create a hashset to indicate whether a char existed before,
	 * if yes, return false 1-2.if it is a ASCII string then use an boolean
	 * array with size of 256 1-3.if it is a UTF-16 string then use an boolean
	 * array with size of 65536 2.After scanning the whole string, if no false
	 * returned, return true.
	 * 
	 * [time complexity] O(n)
	 * 
	 * [space complexity] O(n)
	 */
	// hashset time complexity: O(n) space complexity: O(n)
	public static boolean isUnique(String s) {

		if (s == null || s.length() == 0)
			return true;
		if (s.length() > Character.MAX_VALUE)
			return false;
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				return false;
			} else {
				set.add(c);
			}
		}
		return true;
	}

	// no additional data structures. space complexity: O(1)
	public static boolean isUnique_array(String s) {
		// first check the length of the string
		// if(s.length() > 256) return false;
		// boolean[] checker = new boolean[256];

		// assume only lower case letters a through z
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if ((checker & (1 << index)) != 0)
				return false;
			checker |= (1 << index);
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "abcde", "hello", "apple", "kitle" };
		for (String word : words) {
			System.out.println(word + " : " + isUnique(word) + ","
					+ isUnique_array(word));
		}
	}
}
