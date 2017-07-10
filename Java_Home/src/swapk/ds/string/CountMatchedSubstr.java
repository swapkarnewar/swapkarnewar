package swapk.ds.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Count matches of specific substring in a String
 * Most Common interview question
 * @author SKarnewar
 *
 */
public class CountMatchedSubstr {

	public static void main(String[] args) {
		String s1 = "SwapnilSunilKarnewarSwapnilShraddhanand";
		Pattern pattern = Pattern.compile("Swapnil");
		Matcher matcher = pattern.matcher(s1);
		int occurance = 0;
		
		while( matcher.find() ){
			occurance++;
		}
		System.out.println(occurance);
		
		/**
		 * SubString( startInd, endInd ), includes 5th element and excludes 8th element
		 */
		System.out.println(s1.substring(5,8));
		/**
		 * SubString( startInd ), includes 5th element and up to end
		 */
		System.out.println(s1.substring(5));
		
		/**
		 * Substring has a memory leak up untill 1.7
		 * This is fixed from 1.7
		 */
		//<TODO>How is memory leak in String?
		String str = s1.substring(0,7);
		System.out.println(str);
		
		//StringBuffer is thread safe. Coz each method has synchronized keyword
		//StringBuilder is not thread safe.
	}

}
