import java.util.ArrayList;
import java.util.List;


abstract class AbstractExample {

	public abstract void display();
	
	
}

abstract class AbstractExample1 extends AbstractExample{

	public abstract void displayChild();
	
}

interface testInter1 extends testInter{
	void testMethodNew();
}

public class AbstractExample2 extends AbstractExample1 implements testInter1 {
	
	public static void main(String a[]){
		AbstractExample2 obj = new AbstractExample2();
		//obj.methoda();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(24);
		list.add(25);
		list.add(26);
		list.add(35);
		list.add(46);
		System.out.println(list);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(null);
		System.out.println(list2);
		
		System.out.println(list.containsAll(list2));
		
	}

	@Override
	public void testMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testMethodNew() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayChild() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	
}