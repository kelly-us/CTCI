package CC150;

//C1-1.4
public class replace {
	
	//char array in-place
	/*
	 * 
	[solution]
	1. iterate through the string to calculate the new length of the string after replacing all the spaces
	2. Use two pointers, one indicates the old tail, another indicates the new tail, if the char is a space, replace it with %20, otherwise just copy the old char.

	[time complexity]
	O(n)

	[space complexity]
	O(1)
	 */
	public void replaceSpace(char[] str, int l){
		int count = 0;
		for(int i = 0; i < l; i++){
			if(str[i] == ' ')
				count++;
		}
		int nl = l + count * 2;
	
		str[nl] = '\0'; 
		int idx = nl - 1;
		for(int i = l-1; i >= 0; i--){
			if(str[i] != ' '){
				str[idx--] = str[i]; 
			}
			else{
				str[idx--] = '0';
				str[idx--] = '2';
				str[idx--] = '%';
			}
		}
		
		
	}
	
	

}
