package CC150;

//C1-1.5
public class compress {

	//concatenation stringBuffer
	/*
	 * 
	[solution]
	scan the string, use a prev value and a counter to keep track of the repeat of a char, and then update the compressed string accordingly.
	[time]
	O(n)
	[space]
	O(n)
	 */
	public String compressStr(String s){
		if(s == null) return null;
		/*int length = s.length();
		int new_length = compressedLength(s);
		if(new_length >= length) return s;
		*/
		StringBuffer n = new StringBuffer();
		char last = s.charAt(0);
		int count = 1;
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == last){
				count++;
			}
			else{
				n.append(last);
				n.append(count);
				last = s.charAt(i);
				count = 1;
			}
		}
		//
		n.append(last);
		n.append(count);
		if(n.toString().length() >= s.length())
			return s;
		else 
			return n.toString();
	}
	
	/*
	public int compressedLength(String s){
		if(s == null || s.length() == 0) return 0;
		int res = 0;
		char last = s.charAt(0);
		int count = 1;
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == last){
				count++;
			}
			else{
				last = s.charAt(i);
				res += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		
		res += 1 + String.valueOf(count).length();
		return res;
	}*/
}
