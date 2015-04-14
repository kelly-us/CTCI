package CC150;

import java.util.HashMap;

//C1-1.1
//ASCII string or Unicode string?
public class UniqueCharacter {
	/*
	 * 
	[solution]
	1.create a hashmap to indicate whether a char existed before, if yes, return false
	2.After scanning the whole string, if no false returned, return true.

	[time complexity]
	O(n)

	[space complexity]
	O(n)
	 */
	//hashmap time complexity: O(n) space complexity: O(n)
	public boolean isUnique(String s){
		//first check the length of the string
		if(s.length() > 256) return false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
		for(int i = 0; i < s.length(); ++i){
			char c = s.charAt(i);
			if(map.get(c) != 1){
				map.put(c,1);
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	//no additional data structures 
	public boolean isUnique_array(String s){
		if(s.length() > 256) return false;
		int checker = 0;
		for(int i = 0; i < s.length(); i++){
			int index = s.charAt(i) - 'a';
			if((checker & (1 << index)) != 0)
				return false;
			checker |= (1 << index);
		}
		return true;
	}
	
	public static void main(String[] args){
		
	}
}
