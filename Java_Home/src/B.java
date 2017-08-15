class A 
{
	int x = 10;
	protected void display(int i) throws Exception
	{
		System.out.println("byte = "+i);
	}
	public void display(float i) throws NullPointerException
	{
		System.out.println("Byte base float= "+i);
	}
}

class CA extends A
{
	int x = 11;
	public void display(int i) throws NullPointerException
	{
		System.out.println("Byte Child= "+i);
	}
	
	public void display(float i) throws NullPointerException
	{
		System.out.println("Byte Child float= "+i);
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
		float i = 10;
		try {
			obj.display(i);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println(obj.x);
	}
}

