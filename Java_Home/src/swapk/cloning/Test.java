package swapk.cloning;

public class Test implements Cloneable{

	int i = 10;
	int j = 20;
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Test t1 = new Test();
		/**
		 * This will create the another reference named t2 to the t1 object
		 */
		//Test t2 = t1;
		Test t2 = (Test) t1.clone(); //As clone return Object we need that base object downcast to the child here Test...
		//As clone method in object throws CloneNotSupportedException, we need to catch or add throws for this exception
		t2.i = 888;
		t2.j = 999;
		System.out.println(t1.i+"..."+t1.j);
		//Now it gives  java.lang.CloneNotSupportedException because we have to make Test as cloneable by implementing it to Cloneable interface - this is marker interface
	}

}
