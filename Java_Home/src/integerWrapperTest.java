import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class integerWrapperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = 0;
		System.out.println(a);
		BigDecimal sw = new BigDecimal(23);
		a= sw.intValue();
		
		int b = a.intValue();
		System.out.println(b);
		
		List list = new ArrayList<>();
		list.add("swapnil");
		list.add(null);
		
		System.out.println(list.toString());
		
		Integer r = 128;
		Integer r2 = 128;
		System.out.println(r.intValue()==r2.intValue());
		
	}

}
