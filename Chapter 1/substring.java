package CTCI.Chapter1;

//C1-1.8
public class substring {

	public static boolean isSubstring(String s1, String s2){
		if(s1.indexOf(s2) != -1) return true;
		else return false;
	}
	
	public static boolean isRotation(String s1, String s2){
		if(s1 == null || s2 == null || s1.length() != s2.length()) return false;
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}
	
	public static void main(String[] args){
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for(String[] pair : pairs){
			System.out.println(pair[0] + "," + pair[1] + " " + isRotation(pair[0], pair[1]));
		}
	}
}
