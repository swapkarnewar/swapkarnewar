package swapk.inheritance;

public class App {

	public static void main(String []a) {
		Lion lion = new Lion();
		lion.setB(12);
		lion = (Lion) foo(lion);
		System.out.println("in main : "+lion.getB());
		Animal.foo1(lion);
		
		Animal anml1 = new Animal();
		//Lion newLion1 = ((Lion)anml1);
		//NOTE: obj of base is created and try to typecast that reference - gives class cast exception
		//but if Animal anml = new Lion(); and now try to typecast it will succeed
		
		Animal anml = new Lion();
		Lion newLion = ((Lion)anml);
		newLion.setA(122);
		System.out.println(newLion.getA());
		System.out.println("----------------");
		
		anml = foo(anml);
		
		System.out.println("----------------");
		System.out.println(((Animal)lion).getB());//no need of typecast here, coz child class obj can call base methods.
		System.out.println("here : "+anml.getValuesFromBase());
		//((Lion)anml).setA(122);
		//System.out.println("last = "+((Lion)anml).getA());
	
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("in thread : "+Thread.currentThread().getName());
				//Thread.currentThread().stop();
				System.out.println("After stop in thread : "+Thread.currentThread().getName());
			}
		},"T1");
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.start();
		System.out.println("After thread in main");
	}
	
	static Animal foo(Animal a) {
		System.out.println("in foo : "+a.getB());
		a.setB(111);
		return a;
	}
	
}
