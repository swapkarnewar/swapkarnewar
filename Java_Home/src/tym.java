import java.util.Arrays;
import java.util.Comparator;


public class tym {

	public static void main(String[] args) {
		//int a = 9;
		//int b = 2;
		//System.out.println(a/b);
		//double a  = getValAtPos(5);
		 //int y = (int)a; 
		//double a  = 1.6d;
		 //int y = (int)Math.round(a);
		//System.out.println(y%10000005);
		int [] arr = {1,3,2,5,6};
		String a1 = largestNumber(arr);
		System.out.println(a1);
		
	    //double dVal = 3516.6666666666666;
	    /*double test = dVal*1000;
	    int a = (int)test;
	    double dVal1 = a/1000d;*/
	    //System.out.printf ("Value with 4 digits after decimal point %1.4f", dVal);
	    //System.out.print (dVal1);
	    
		/*int e = 3;
		double c = 2;
		if( c == (int)c )
			System.out.println("c is int");
		double a = e/c;
		System.out.println(a);
		if( a == (int)a )
			System.out.println("a is int");
		
		String str = "swapnil";
		int val = 0;
		for( int i = 0; i < str.length(); i++ ) {
			val = str.charAt(i) - 'a';
		}
		
		int [][] matrix = {{2,3},{6,4,5}};*/
		//System.out.println(matrix.length);
		
	}

	
	
	private static double getValAtPos(int i) {
		return (Math.sqrt(8*i-7)+1)/2;
	}
	
	public static String largestNumber(int[] nums) {
	    String[] arr = new String[nums.length];
	    for(int i=0; i<nums.length; i++){
	        arr[i]=String.valueOf(nums[i]);
	    }
	 
	    Arrays.sort(arr, new Comparator<String>(){
	        public int compare(String a, String b){
	            return (b+a).compareTo(a+b);
	        }
	    });
	 
	    StringBuilder sb = new StringBuilder();
	    for(String s: arr){
	        sb.append(s);
	    }
	 
	    while(sb.charAt(0)=='0'&&sb.length()>1)
	        sb.deleteCharAt(0);
	 
	    return sb.toString();
	}

}

//No need of following class
/*class LargestNumber {
	public static String largestNumber(int[] a) {
		final String sortString = "0123456789";
		StringBuffer result = new StringBuffer();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < a.length; i++) {
			String element = String.valueOf(a[i]);
			for (int j = 1; j <= element.length(); j++) {
				list.add(element.substring(j - 1, j));
			}
		}

		Collections.sort(list, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return sortString.indexOf(s2) - sortString.indexOf(s1);
			}
		});

		System.out.println(list);

		for (String element : list) {
			result = result.append(element);
		}
		return result.toString();
	}
}*/
