package swapk.Array;

/**
 * Knuth�Morris�Pratt(KMP) Pattern Matching(Substring search)
 * KMP substring - search pattern in provided string in O(m+n)
 * i.e String.subString custom implementation
 * Traditional O(mn)
 * @author SKarnewar
 *
 */
public class SubstringSearch {

	public static void main(String [] args) {
		String str = "abcxabcdabcdabcy";
		String subString = "abcdabcy";
        SubstringSearch ss = new SubstringSearch();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
	}

	private boolean KMP(char[] text, char[] pattern) {
		int []lps = computeTemporaryArray(pattern);
		int i = 0;
		int j = 0;
		while( i < text.length && j < pattern.length ) {
			if( text[i] == pattern[j] ) {
				i++;
				j++;
			}
			else {
				if( j != 0 ) {
					j = lps[j-1];
				}
				else {
					i++;
				}
			}
		}
		if(j == pattern.length){
            return true;
        }
		return false;
	}

	private int[] computeTemporaryArray(char[] pattern) {
		int []lps = new int[pattern.length];
		int index = 0;
		for( int i = 1; i < pattern.length; ) {
			if( pattern[index] == pattern[i] ) {
				lps[i] = index + 1;
				index++;
				i++;
			}
			else {
				if( index != 0 ) {
					index = lps[index-1];
				}
				else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
	
	/**
	 * traditional way
	 */
	private boolean custSubstring(char[] text, char[] pattern) {
		int i = 0;
		int j = 0;
		int k = 0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                j=0;
                k++;
                i = k;
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
	}
}
