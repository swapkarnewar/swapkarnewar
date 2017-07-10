
public class StaticExs{

	private static int count;
    public static String str;
    public static final String DB_USER = "myuser";
    
    static{
    	final String str1 = str+"StaticBlockHii";
    	System.out.println(str1);
    }
    
	public static void main(String[] args) {
		StaticExs.str = "HiMain";
		System.out.println(StaticExs.DB_USER);
		Chemical che = new Chemical();
		che.displayStatic();
	}

}

class Chemical{
	public void displayStatic(){
		StaticExs.str = "Hi";
		System.out.println(StaticExs.str);
	}
}