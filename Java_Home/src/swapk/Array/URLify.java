package swapk.Array;
/**
 * @author skarnewar
 * CTCI
 * Chapter 1 Question 3
 */
import java.util.Arrays;

public class URLify {

	public static void main(String[] args) {
		String str = "My name is Swapnil   ";
		System.out.println(str.length());
		
		char[] arr = str.toCharArray();
		int trueLength = findTrueLength(arr) + 1;
		System.out.println(trueLength);
		arr = convertStringToURL(arr, trueLength);
		
		StringBuilder sb = new StringBuilder(arr.length);
		for (char c : arr) {
			if (c == 0) {
				break;
			}
			sb.append(c);
		}
		str = sb.toString();
		System.out.println("after -: "+str);
	}	

	private static char[] convertStringToURL(char[] arr, int trueLength) {
		int spaceCount = 0;
		for( int i = 0; i < trueLength; i++ ) {
			if( arr[i] == ' ' )
				spaceCount++;
		}
		int totalLength = trueLength + spaceCount*2;
		arr = Arrays.copyOf(arr, totalLength);
		System.out.println(totalLength);
		for( int i = trueLength-1; i >=0; i-- ) {
			if( arr[i] == ' ' ) {
				arr[totalLength-1] = '0';
				arr[totalLength-2] = '2';
				arr[totalLength-3] = '%';
				totalLength = totalLength - 3;
			}
			else {
				arr[totalLength-1] = arr[i];
				totalLength--;
			}
		}
		return arr;
	}

	private static int findTrueLength(char[] arr) {
		for(int i = arr.length-1; i >= 0; i--) {
			if( arr[i] != ' ' ) {
				return i;
			}
		}
		return 0;
	}

}
