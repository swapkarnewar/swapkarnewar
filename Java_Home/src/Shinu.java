import java.util.HashMap;
import java.util.Map;


public class Shinu 
{
	public static void main(String args[])
	{
		Map<String,String> kmap = new HashMap<>();
		kmap.put("x", "y");
		printMap(kmap);
		modifyMap(kmap);
		printMap(kmap);
		setNull(kmap);
		printMap(kmap);
	}

	private static void setNull(Map<String, String> kmap) 
	{
		kmap = new HashMap<>();
	}

	private static void modifyMap(Map<String, String> kmap) 
	{
		kmap.put("x", "z");
	}

	private static void printMap(Map<String, String> kmap) 
	{
		for(Map.Entry<String, String> ent : kmap.entrySet())
		{
			System.out.println("Key "+ent.getKey()+" Value: "+ent.getValue());
		}
	}
 


}




