package CC150;

//C1-1.2
public class reverse {
	
	//in C, be careful to the null character
	/*
	 * ¡¾solution¡¿
		Use two pointers to indicate the positions of the char needed to be swaped
		¡¾time¡¿O(N)
		¡¾space¡¿O(1)
	 */
	public void reverseString(char[] c){
		if(c == null || c.length < 2) return;
		int n = c.length;
		for(int i = 0, j = n - 1; i < j; i++, j--){
			char t = c[i];
			c[i] = c[j];
			c[j] = t;
		}
	}
}
