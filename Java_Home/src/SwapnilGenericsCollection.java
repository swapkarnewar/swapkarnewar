import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SwapnilGenericsCollection {

	
	public static void main(String[] args) {
		
		Collection<String> arrList1 = new ArrayList<String>();
		arrList1.add("Harneesha1");
		
		List<String> arrList = new ArrayList<String>(arrList1);
		arrList.add("swapnil");
		arrList.add("harneesha");
		
		System.out.println(arrList);
	}

}
