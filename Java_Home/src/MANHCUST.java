
public class MANHCUST extends MANHBASE implements IMANHCUST {
	
	private Integer nbrOfCopies = null;
	
	public void disp() {
		System.out.println("IN CUST");
	}
	
	@Override
	public void dispCust() {
		System.out.println("IN ICUST");
	}
	
	public static void m() {
		System.out.println("in base static");
	}
}
