package swapk.inheritance;

public class Animal {

	
	int b = 1;

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	static void foo1(Animal a) {
		System.out.println("in animal foo1"+a.getB());
	}
	
	public int getVal() {
		return 1;
	}
	
	public int getValuesFromBase() {
		return getVal();
	}
}
