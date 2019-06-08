package swapk.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * To shrink a string "abbcccbfgh" by removing Consecutive k characters till no removal can be done.
 * e.g. for k=3 output for the above string will be "afgh".
 * @author SKarnewar
 *
 */

public class RemoveConsecutiveDupes {

	public static void main(String[] args) {
		String str = new String();
		str = "abbcccbfgh";
		int k = 3;
		str = removeConsDups(str,k);
		System.out.println(str);
	}

	private static String removeConsDups(String str, int k) {
		List<Character> list = new ArrayList<>();
		char[] arr = str.toCharArray();
		for( int i = 0; i < arr.length; i++ ) {
			list.add(arr[i]);
			if( list.size() > 2 ) {
				if( list.get(list.size() - 2) == list.get(list.size() - 1) && list.get(list.size() - 2) == list.get(list.size() - 3) ) {
					list.remove(list.size()-1);
					list.remove(list.size()-1);
					list.remove(list.size()-1);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for( Character c : list ) {
			sb.append(c);
		}
		str = sb.toString();
		return str;
	}

}
