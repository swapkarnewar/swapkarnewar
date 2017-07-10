import java.io.IOException;

class NewNullPointerException extends NullPointerException {
	
}

class ExceptionExsBase {
	public void display() throws NewNullPointerException {
		System.out.println("in base");
	}
	
	public void test() throws NewNullPointerException {
		System.out.println("in test");
	}
}

class ExceptionExsChild extends ExceptionExsBase {
	public void display() throws NullPointerException {
		System.out.println("in child");
	}
	
	public void countNum(int i) {
		System.out.println("count = "+i);
	}
	
	
	
}

public class ExceptionExs {

	public static void main(String[] args) {
		//ExceptionExsChild obj = (ExceptionExsChild) new ExceptionExsBase();//class cast exception
		ExceptionExsBase obj1 = new ExceptionExsChild();//no exception
		obj1.display();
		obj1.test();
		((ExceptionExsChild)obj1).countNum(1);
	}

}
