import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimestampExample {

	public static void main(String[] args) throws Exception {
		String str = "17 08 07 13 37 37";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yy MM dd HH mm ss");
		Date startDate = formatter.parse(str);
		
		System.out.println(startDate);
		/*Timestamp schedStartDateTime = new Timestamp(System.currentTimeMillis());
		System.out.println(schedStartDateTime);
		
		String test = schedStartDateTime.toString();
		
		//Timestamp.parse(test);
		Timestamp schedStartDateTime1 = Timestamp.valueOf(test);
		System.out.println(schedStartDateTime1);*/
		
	}

}
