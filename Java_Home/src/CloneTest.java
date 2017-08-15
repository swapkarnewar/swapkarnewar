import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


class Tess2 {
    int x, y;

	@Override
	public String toString() {
		return "Tess2 [x=" + x + ", y=" + y + "]";
	}
    
}

class Tess1 implements Cloneable {
	int i;
	int j;
	Tess2 c = new Tess2();
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	@Override
	public String toString() {
		return "Tess1 [i=" + i + ", j=" + j + ", c=" + c + "]";
	}
	
	
	
}
public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Tess1 t1 = new Tess1();
		t1.i = 10;
		t1.j = 20;
		t1.c.x = 30;
		t1.c.y = 40;
		System.out.println(t1);
		Tess1 t2 = (Tess1)t1.clone();
		t2.i = 100;
		t2.c.x = 1000;
		System.out.println(t1);
		System.out.println(t2);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println("b4: "+list);
		//Collections.copy(list2, list);
		ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
		list2.set(0, 11);
		System.out.println("after: "+list+"::"+list2);
	}

}
