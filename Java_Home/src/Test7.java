import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test7 {

	public static void main7(String[] args) {
		// TODO Auto-generated method stub
		//Date date = new Date();
		
		//SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm");
		//System.out.println(date.toString());
		//System.out.println(timeFormat.format(date));

		//SimpleDateFormat hh - 12 hr format HH - 24 hr format
		
		String str = new String("2344-2311");
		System.out.println(str);
		List<Integer> shipmentIdsList = new ArrayList<Integer>();
		for(int i=0;i<2;i++)
		{
			shipmentIdsList.add(Integer.parseInt(str.split("-")[i]));
		}
		System.out.println(shipmentIdsList.toString());
		
		
		
		System.out.println("hiii");
	}

}
