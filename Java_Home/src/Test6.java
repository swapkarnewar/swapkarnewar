import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

public class Test6 {

	public static void main6(String[] args) {
		// TODO Auto-generated method stub
		String string = "2/11/15 14:00";
		String string1 = "2/12/16 15:00";
		DateFormat format = new SimpleDateFormat("MM/dd/yy HH:mm", Locale.ENGLISH);
		GregorianCalendar cal = new GregorianCalendar();
		GregorianCalendar cal1 = new GregorianCalendar();
		Date date;
		Date date2;
		try {
			date = format.parse(string);
			date2 = format.parse(string1);
			System.out.println(date.toString());
			System.out.println(date2.toString());
			cal.setTime(date);
			cal1.setTime(date2);
	        cal.add(Calendar.DATE, 6);
	        cal1.add(Calendar.DATE, 6);
			System.out.println(cal.getTime()); // Sat Jan 02 00:00:00 GMT 2010
			System.out.println(cal1.getTime());
			
/*			cal1.setTime(date);
 * 
 * Wed Feb 11 14:00:00 IST 2015
Thu Feb 11 15:00:00 IST 2016
			
			long milis1 = cal.getTimeInMillis();
	        long milis2 = cal1.getTimeInMillis();
	        System.out.println(milis2);
	        long diff = milis1 - milis2;

	        long diffDays = diff / (24 * 60 * 60 * 1000);
	        System.out.println(diffDays);
	        */
	        
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
