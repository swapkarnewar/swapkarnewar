package swapk.cloning;

class Cat {
	int j;
	Cat(int j) {
		this.j = j;
	}
}

class Dog implements Cloneable {
	Cat c;
	int i;
	Dog( Cat c, int i ) {
		this.c = c;
		this.i = i;
	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class ShallowCloningDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Cat c = new Cat(20);
		Dog d1 = new Dog(c, 10);
		System.out.println(d1.i+"..."+d1.c.j);
		
		Dog d2 = (Dog) d1.clone();
		d2.i = 888;
		d2.c.j = 999;
		System.out.println(d1.i+"..."+d1.c.j);
		//original obj is changed, i.e d1.c.j is changed to 999
		//This is shallow copy
		
		//In shallow cloning, by using cloned obj ref if we perform any change to the contained obj then
		//those changes will be reflected to the main obj, to overcome this problem use Deep Cloning
		
	}

}
