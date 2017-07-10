class Base4{
	public static void foo(Base4 bObj){
		System.out.println("in base foo");
		bObj.bar();
	}
	void bar(){
		System.out.println("in base bar");
	}
}
class Derived4 extends Base4{
	public static void foo(Derived4 bObj){
		System.out.println("in derived foo");
		bObj.bar();
	}
	void bar(){
		System.out.println("in derived bar");
	}
	void meth(){
		System.out.println("in meth bar");
	}
}
public class Test4{
	public static void main4(String[] args) {
		Base4 bObj = new Derived4();
		bObj.foo(bObj);
		Derived4 o = (Derived4)new Base4();
	}
}