
class Animal{
	public int i = 2;
	
	public Animal(){
		System.out.println("Animal Constructor");
	}
	public void methodInAnimal(){
		System.out.println("In Animal::method():-> " + Integer.SIZE);
	}
}

public class Test1 extends Animal{
	
	public int i = 2;
	public Test1(){
		System.out.println("Test1 Constructor");
	}
	
	/*public void methodInTest1(){
		System.out.println("In Test1::method()");
	}*/
	
	public static void main2(String[] args){
		Test1 a = new Test1();
		System.out.println(a);
		Animal an = a;
		System.out.println(an);
		/*if(an instanceof Test1){
			System.out.println("animal obj can be downcasted");
			Test1 tst1 = (Test1) an;
			System.out.println(tst1);
		}*/
		
/*		Animal animal = new Animal();
		Test1 tst2 = (Test1)animal;*/
	}
}
