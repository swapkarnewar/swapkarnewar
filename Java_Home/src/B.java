class A 
{
	public void display(int i)
	{
		System.out.println("byte = "+i);
	}
	/*public void display(byte i)
	{
		System.out.println("Byte Super= "+i);
	}*/
}

class CA extends A
{
	public void display(int i)
	{
		System.out.println("Byte Child= "+i);
	}
}

class DA extends A
{
	int k;
	
	void display()
	{
		System.out.println(k);
	}
}

public class B
{
	public static void main( String a[] )
	{
		A obj = new CA();
		byte i = 10;
		obj.display(i);
	}
}

