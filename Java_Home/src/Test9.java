import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class Test9 {

	static Boolean isLocnEmpty = new Boolean(false);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*		ArrayList<String> lst = new ArrayList<String>(); 
		boolean retValiLpnOnLocnId = false;
		lst.add("abc");
		lst.add("swap");
		if( lst.size() > 0)
		{
			retValiLpnOnLocnId = true;
			for (Iterator iterator = lst.iterator(); iterator.hasNext();) {
                if(iterator.next() == null)
                {
                	retValiLpnOnLocnId = false;
                	break;
                }
			}
		}
		
		System.out.println(retValiLpnOnLocnId);
		System.out.println(lst);
		*/
		//boolean[] flagArr = new boolean[2];
		boolean[] flagArr = test(true);
		if( true )
		{
			System.out.println(flagArr[0]);
			System.out.println(flagArr[1]);
		}
		
		Collection<String> list = new ArrayList<>();
		list.add("Swap");
		list.add("Swap1");
		System.out.println(list);
	}

	private static boolean[] test(boolean flag) {
		boolean[] flagArr = new boolean[2];
		flagArr[0] = true;
		flagArr[1] = true;
		
		System.out.println("in func,"+flagArr[0]);
		System.out.println("in func,"+flagArr[1]);
		
		return flagArr;
	}

}
