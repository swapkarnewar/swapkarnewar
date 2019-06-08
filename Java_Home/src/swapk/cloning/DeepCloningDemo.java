package swapk.cloning;

/**
 * The process of creating exactly duplicate independant copy including contained obj is called deep cloning
 * in deep cloning, if the main obj contains any primitive var then in cloned obj duplicate copies will be created.
 * if the main obj contains any ref var, then corrosponding contained obj also will be created in cloned copy.
 * 
 * Class method's clone method provides shallow copy.
 * For deep cloning programmer is responsible to do code i.e we need to override the clone method
 * @author SKarnewar
 *
 */

class DeepCat {
	int j;
	DeepCat(int j) {
		this.j = j;
	}
}

class DeepDog implements Cloneable {
	DeepCat c;
	int i;
	DeepDog( DeepCat c, int i ) {
		this.c = c;
		this.i = i;
	}
	public Object clone() throws CloneNotSupportedException {
		//Deep copy
		DeepCat c1 = new DeepCat(c.j);
		DeepDog d = new DeepDog(c1, i);
		return d;
	}
}

public class DeepCloningDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		DeepCat c = new DeepCat(20);
		DeepDog d1 = new DeepDog(c, 10);
		System.out.println(d1.i+"..."+d1.c.j);
		
		DeepDog d2 = (DeepDog) d1.clone();
		d2.i = 888;
		d2.c.j = 999;
		System.out.println(d1.i+"..."+d1.c.j);
	}

}
