import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class MyAbstractClass{
	
}
public class Test5 {

	public static void main5(String[] args) {
		StringBuilder str = new StringBuilder("AB   XY   FG   ");
		String str1 = str.substring(0, 5);
		String str2 = str.substring(10, 15);
		StringBuilder sb = new StringBuilder("ABC");
		
		if(sb.length() != 5 && sb.length() < 5){
			int i = 5 - sb.length() ;
			StringBuilder sb1 = new StringBuilder();
			for(int j=0;j<i;j++)
				sb.append(" ");
			//System.out.println(i);
			System.out.println(sb.toString());
		}
		
		System.out.println(str1+sb.toString()+str2);
		System.out.println(str2.length());
	}

}
