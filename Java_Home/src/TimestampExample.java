import java.sql.Timestamp;


public class TimestampExample {

	public static void main(String[] args) {
		Timestamp schedStartDateTime = new Timestamp(System.currentTimeMillis());
		System.out.println(schedStartDateTime);
		
		String test = schedStartDateTime.toString();
		
		//Timestamp.parse(test);
		Timestamp schedStartDateTime1 = Timestamp.valueOf(test);
		System.out.println(schedStartDateTime1);
		
	}

}
