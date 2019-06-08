
public class MANH_TEST {

	public static void main( String [] ar ) {
		
		//((MANHCUST)getMheContainerDirectiveProcessor()).test();
		
		MANHBASE b = new MANHCUST();
		b.disp();
	}

	private static IMANHCUST getMheContainerDirectiveProcessor() {
		return (IMANHCUST) new MANHCUST();
	}			

}
