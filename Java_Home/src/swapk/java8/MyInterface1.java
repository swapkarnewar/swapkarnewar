package swapk.java8;

public interface MyInterface1 {
	
	public default void log(String str){
		System.out.println("In MyInterface1::log");
	}
	
	public void method1();
}
