import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class EmployeeAmcatTest implements Comparable<EmployeeAmcatTest>
{
	private int employeeId;
	private String name;
	
	public EmployeeAmcatTest(int employeeId, String name) {
		this.employeeId = employeeId;
		this.name = name;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmployeeAmcatTest [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeAmcatTest other = (EmployeeAmcatTest) obj;
		if (employeeId != other.employeeId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(EmployeeAmcatTest o) {
		return this.name.compareTo(o.getName());
	}
	
}

class Dad {
	public int i = 10;
	public void disp() {
		System.out.println("in dad");
	}
	
	public void baseMethod(int i) {
		System.out.println("base");
	}
	
	
}

class Porga extends Dad {
	public int i = 20;
	public void disp() {
		System.out.println("in Porga");
	}
	
	public void baseMethod(float i) {
		System.out.println("child");
	}
	
	public void tempMethod() {
		System.out.println("tempMethod");
	}
	
	
}

public class AmcatTest {
	
	public static void main(String[] args) {
		/*Scanner scan = new Scanner(System.in);
		long n = scan.nextInt();
		
		Map<Long,Long> map = new HashMap<>();
		
		for( long i = 0; i < n; i++ ) {
			long houseNum = scan.nextLong();
			long pos = scan.nextLong();
			map.put(houseNum, pos);
		}*/

		Dad o = new Porga();
		((Porga)o).tempMethod();
		
		EmployeeAmcatTest e1 = new EmployeeAmcatTest(1, "z");
		EmployeeAmcatTest e2 = new EmployeeAmcatTest(1, "f");
		EmployeeAmcatTest e3 = new EmployeeAmcatTest(1, "a");
		
		boolean isWM13 = false;
		String scannedItemBrcd = "WM20ITMOSE,WM20ITMDIFFERENTTEST,WM13";
		String varRefField7 = "";
		String varRefField8 = "";
		String wm13 = "";
		String var_scnBrcd= scannedItemBrcd;
		
		if(scannedItemBrcd.contains(","))
		{
			if(scannedItemBrcd.length() >= 4)
			wm13 = scannedItemBrcd.substring(scannedItemBrcd.length() - 4, scannedItemBrcd.length());
			if(wm13.equalsIgnoreCase("WM13")){
				isWM13 = true;
			}
			if(isWM13){
				int firstCommaIndex = scannedItemBrcd.indexOf(",");
				varRefField7 = scannedItemBrcd.substring(0, firstCommaIndex);
				var_scnBrcd = scannedItemBrcd.substring(firstCommaIndex+1, scannedItemBrcd.length() - 5);
				scannedItemBrcd=varRefField7;
				varRefField8 = var_scnBrcd;
				 
			}
		}
		
		if(varRefField7 == null || (varRefField7 != null && varRefField7.isEmpty())){
			varRefField7 = "WM13null";
		}
		
		if(varRefField8 == null || (varRefField8 != null && varRefField8.isEmpty())){
			varRefField8 = "WM13null";
		}
		if(scannedItemBrcd == null || (scannedItemBrcd != null && scannedItemBrcd.isEmpty())){
			scannedItemBrcd = "WM13null";
		}
		
		System.out.println("varRefField7 = "+varRefField7);
		System.out.println("varRefField8 = "+varRefField8);
		System.out.println("scannedItemBrcd = "+scannedItemBrcd);
		
		//System.out.println(isPalindrome("swap"));
		//int n = 153;
		//isArmstrongNumber(n);
	}

	private static void isArmstrongNumber(int n) {
		//https://www.programiz.com/java-programming/examples/armstrong-number
		int originalNumber = n;
		int remainder, result = 0;
				
		while (originalNumber != 0)
		{
			remainder = originalNumber % 10;
			result += Math.pow(remainder, 3);
			originalNumber = originalNumber/10;
			//OR we can write like -->  originalNumber /= 10;
		}
		
		if( result == n ) {
			System.out.println("armstrong");
		}
		else {
			System.out.println("not armstrong");
		}
	}
	
	public static boolean isPalindrome(String str) {
		
		char[] arr = str.toCharArray();
		for( int i = 0, j = arr.length-1; i <= (arr.length-1)/2; i++,j-- ) {
			if( arr[i] != arr[j] ) {
				return false;
			}
		}
		return true;

	}

}
