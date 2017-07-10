package swapk.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnagramString {

	public static void main(String[] args) {
		System.out.println("Enter 2 strings to check if they are anagram - ");
		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		
		isAnagramStrings(str1, str2);
		
	}

	private static void isAnagramStrings(String str1, String str2) {
		
		List<String> charList = new ArrayList<String>();
		
		char[] arrStr1 = str1.toCharArray();
		char[] arrStr2 = str2.toCharArray();
		
		if( arrStr1.length != arrStr2.length ) {
			System.out.println(str1 + " and "+str2+" are not Anagram.");
			return;
		}
		
		for( int i = 0; i < arrStr1.length; i++ )
			charList.add(String.valueOf(arrStr1[i]));
		
		for( int i = 0; i < arrStr2.length; i++ ) {
			if( charList.contains(String.valueOf(arrStr2[i])) ) {
				charList.remove(String.valueOf(arrStr2[i]));
			}
		}
		
		if( charList.size() == 0 ) {
			System.out.println("anagram");
		}
		else {
			System.out.println("not anagram");
		}
			
	}
	
	

}
