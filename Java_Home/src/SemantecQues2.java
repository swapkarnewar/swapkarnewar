import java.util.Collection;
import java.util.HashMap;


public class SemantecQues2 {
	
	public static void main(String []ar) {
		String str1 = "test";
		String str2 = "stte";
		
		if( str1.length() == str2.length() ) {

			char[] s1 = str1.toCharArray();
			char[] s2 = str2.toCharArray();
			
			int value = 0;
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for( int i=0; i < s1.length; i++ ) {
				if( map.containsKey(s1[i]) ) {
					int retVal = map.get(s1[i]);
					map.put(s1[i], retVal+1);
				}
				else {
					map.put(s1[i], ++value);
				}
			}
			
			for( int i=0; i < s2.length; i++ ) {
				int retVal = map.get(s2[i]);
				if(retVal>0) { 
					map.put(s2[0], --retVal);
				}
			}
			
			Collection<Integer> values = map.values();
			for( int val : values ) {
				if(val>0)
				{
					System.out.println("false");
					break;
				}
			}
			
		}
		else {
			System.out.println("fasle");
		}
		
	}
	
}

