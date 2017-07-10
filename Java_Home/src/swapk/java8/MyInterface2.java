package swapk.java8;

public interface MyInterface2 {
	
	public default void log1(String str){
		System.out.println("In MyInterface2::log1");
	}
	
	static boolean isNull(String str) {
		System.out.println("MyInterface2 Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
	
	default void print(String str) {
		if (!isNull(str))
			System.out.println("MyInterface2 Print::" + str);
	}
	
	public void method2();
}
