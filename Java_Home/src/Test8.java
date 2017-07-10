import java.util.ArrayList;
import java.util.List;


public class Test8 {

	public static void main8(String[] args) {
		
		String lpnListStr = "00000999996052236076,00000999996052236083,00000999996052236090,00000999996052236106,00000999996052236113,00000999996052236120,00000009246052235866,00000009246052235873,00000009246052235880,00000009246052235897,00000009246052235903,00000009246052235910,00000009246052235927,00000009246052235934,00000009246052235941,00000009246052235958,00000009246052235965,00000009246052235972,00000009246052235989,00000009246052235996,00000009246052236009,00000009246052236016,00000009246052236023,00000009246052236030,00000009246052236047,00000009246052236054,00000009246052236061";
		String [] list=lpnListStr.split(",");
		int len=list.length;
		String lpnList=null;
		StringBuffer sb=new StringBuffer();
		
		System.out.println(len);
		
		for(int index=0;index<len;index++){
			if(index%5==0 && index>0){
				sb.append("\n"+list[index]+",");
			}
			else if(index == 0){
				sb.append(list[index]+",");
			}
			else{
				sb.append(list[index]+",") ;
			}
		}
		
		lpnList =sb.toString();
		lpnList = lpnList.substring(0, lpnList.length()-1);
		
		System.out.println(lpnList);
			
	}

}
