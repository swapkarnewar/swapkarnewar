package swapk.goldman.Array;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] numArray = {-1456, 345671, -43218, -123};
		String res = findQualifiedNumbers(numArray);
		System.out.println(res);
		
	}

	private static String findQualifiedNumbers(int[] numberArray) {
		Arrays.sort(numberArray);
		System.out.println(numberArray[0]);
		System.out.println(numberArray[1]);
		System.out.println(numberArray[2]);
		System.out.println(numberArray[3]);
		String[] arr = new String[numberArray.length];
	    for(int i=0; i<numberArray.length; i++){
	        arr[i]=String.valueOf(numberArray[i]);
	    }
	    
		StringBuilder sb = new StringBuilder();
		for( int i = 0; i < arr.length; i++ ) {
			if( arr[i].contains("123") || arr[i].contains("321") ) {
				sb.append(arr[i]);
				sb.append(",");
			}
		}
		if( sb.toString().equals("") )
			return "-1";
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
