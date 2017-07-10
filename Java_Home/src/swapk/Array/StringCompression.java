package swapk.Array;
/**
 * @author skarnewar
 * CTCI
 * Chapter 1 Question 6
 * input : aabccccccaaa
 * output : a2b1c6a3
 */
public class StringCompression {

	public static void main(String[] args) {
		String str = "aabccccccaaa";
		System.out.println(str);
		System.out.println(compress(str));
	}

	private static String compress(String str) {
		StringBuilder compressedString = new StringBuilder();
		int count = 0;
		for( int i = 0; i < str.length(); i++ ) {
			if( i+1 < str.length() && str.charAt(i) == str.charAt(i+1) ) {
				count++;
			}
			else {
				count++;
				compressedString.append(str.charAt(i));
				compressedString.append(count);
				count = 0;
			}
		}
		return (compressedString.toString().length() < str.length()) ? compressedString.toString() : str;
	}

}
