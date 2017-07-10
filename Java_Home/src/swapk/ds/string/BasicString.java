package swapk.ds.string;

public class BasicString {

	public static void main(String[] args) {
		String s1 = "Swapnil";
		String s2 = "Swapnil";
		
		//String Pools are maintained in PermGen until 1.6
		//Since 1.7 its maintained in Main Heap Area
		String s3 = new String("Swapnil").intern();
		//System.out.println(s3 == s1);
		
		String str1 = "Swapnil Karnewar";
		System.out.println(str1.matches("(.*)Karnewar"));
		
		
		String str = "ABC";
		System.out.println(str.length());
		System.out.println(str.substring(1));
	}

}
