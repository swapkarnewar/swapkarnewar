package swapk.goldman.Array;

public class Solution2 {

	public static void main(String[] args) {
		String pattern = "MNM";
		String s = findPossibleSmallestNumberMatchingPattern(pattern);
		System.out.println(s);
	}

	private static String findPossibleSmallestNumberMatchingPattern(String pattern) {
		char[] arr = pattern.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for( int i = 0; i < arr.length; i++ ) {
			String charStr = String.valueOf(arr[i]);
			if( charStr.equals("M") ) {
				int a = count++;
				String s1 = String.valueOf(a + 1);
				if( sb.toString().contains(s1) ) {
					a = count++;
					s1 = String.valueOf(a + 1);
					sb.append(s1);
				}
				else {
					sb.append(s1);
				}
				Integer itemp = Integer.valueOf(s1) - 1;
				if( sb.toString().contains(String.valueOf(itemp)) ) {
					sb.append(String.valueOf(itemp-1));
				}
				else {
					sb.append(String.valueOf(itemp));
				}
			}
			else if( charStr.equals("N") ) {
				if( i > 1 && String.valueOf(arr[i-1]).equals("M") ) {
					
				}
				else {
					sb.append("12");
				}
			}
		}
		if( sb.toString().equals("") )
			return "-1";
		return sb.toString();
	}

}
