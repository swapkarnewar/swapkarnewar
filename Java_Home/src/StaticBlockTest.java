class BaseAnimal {
	
	static{
		System.out.println("in animal static");
	}
	
	{
		System.out.println("in animal instance");
	}
	
	BaseAnimal() {
		
		System.out.println("in animal cons");
	}
	
}

class ChildLion extends BaseAnimal {
	
	static{
		System.out.println("in ChildLion static");
	}
	
	{
		System.out.println("in ChildLion instance");
	}
	
	ChildLion() {
		System.out.println("in ChildLion cons");
	}
	
}

public class StaticBlockTest {

	public static void main(String[] args) {
		BaseAnimal obj = new ChildLion();
	}

}
