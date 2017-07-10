package swapk.Array;
/**
 * @author skarnewar
 * CTCI
 * Chapter 1 Question 5
 * input : pale pal
 * output : true
 * 
 * input : pales pals
 * output : true
 * 
 * input : pale bake
 * output : false
 * 
 * input : pale bale
 * output : true
 */
public class OneAwayProblem {

	
	public static void main(String[] args) {
		String a = "pald";
		String b = "pale";
		boolean isOneEdit1 = oneEditAway(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit1);
	}

	private static boolean oneEditAway(String str1, String str2) {
		
		if( Math.abs(str1.length() - str2.length()) > 1 ) {
			return false;
		}
		int index1 = 0;
		int index2 = 0;
		
		String s1 = (str1.length() < str2.length()) ? str1 : str2;
		String s2 = (str1.length() < str2.length()) ? str2 : str1;
		
		boolean foundDifference = false;
		while( index1 < s1.length() && index2 < s2.length() ) {
			if( s1.charAt(index1) != s2.charAt(index2) ) {
				if( foundDifference ) return false;
				foundDifference = true;
				if( s1.length() == s2.length() )
					index1++;
			}
			else {
				index1++;
			}
			index2++;
		}
		return true;
	}

}
