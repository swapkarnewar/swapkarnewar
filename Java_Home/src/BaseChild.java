class C {
	
	public C() {
		System.out.println("in c");
	}
	int x = 10;
	
	/*public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}*/

	static int retVal()
	{
		return 1;
	}
	
	public void displayC(){
		System.out.println("in C");
	}

}

class D extends C
{
	public D() {
		System.out.println("in d");
	}
	int x = 11;
	/*public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}*/

	static int retVal()
	{
		return 8;
	}
	
	public void displayD(){
		System.out.println("in D");
	}
}

class BaseChild
{
	public static void main(String[] args) {
		C obj = new D();
		System.out.println(obj.x);

		System.out.println(((D)obj).x);
		
		((D)obj).displayD();
		
		//System.out.println(obj.getX());
		//System.out.println(obj.getX());
		//BaseChild obj =  new BaseChild();
		//obj.method(10,10);
		
		
	}
	
	void method(int i, long j)
	{
		System.out.println("int i="+i);
	}
	void method(long i, long j)
	{
		System.out.println("long i="+i);
	}
}