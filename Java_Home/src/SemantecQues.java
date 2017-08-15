class SemanTest {
	public static void testme(String o ) {
		System.out.println("String test me");
	}
}

class SemanTest2 extends SemanTest {
	public static void testme(Object o ) {
		System.out.println("Obj test me");
	}
}

public class SemantecQues {

	public static void main(String[] args) {
		//System.out.println(getEmployeeCount());
		
		SemanTest2 s = new SemanTest2();
		s.testme(null);
		
		String str= "ab";
		str = str + "aa";
		//System.out.println(str);
	}
	
	static int getEmployeeCount() {
	    try {
	        return 2;
	    } catch(Exception e) {
	        System.out.println("exception");
	    	return 0;
	    } finally {
	        System.out.println("finally");
	        return -1;
	    }
	}
	
	/*public void testme(String str) {
		System.out.println("String test me");
	}*/
}
