package swapk.java8;

public class MyClass implements MyInterface1,MyInterface2 {

	public static void main(String[] args) {
		//Default methods in Interface Demo
		MyClass obj = new MyClass();
		obj.log("swapnil");
		
		//static methods in Interface Demo
		MyClass obj1 = new MyClass();
		obj1.print("");
		obj1.isNull("abc");
	}
	
	
	//We have isNull method in interface 2 as static 
		//still we are writing here with not so correct logic
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	@Override
	public void log(String str){//This will be called any time from obj 
		//and makes default method in interface as useless
		System.out.println("Class  In MyInterface1::log");
	}

	@Override
	public void method2() {
		System.out.println("In method2");
	}

	@Override
	public void method1() {
		System.out.println("In method1");
	}

}
