import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TestCons {
	
	public static void main(String[] args) {
		System.out.println("in main");
		List<Integer> cancelledLineItemIdList = new ArrayList<Integer>();
		List<Integer> cancelledLineItemIdList1 = new ArrayList<Integer>();
		
		cancelledLineItemIdList.add(1);
		cancelledLineItemIdList.add(2);
		cancelledLineItemIdList.add(3);
		cancelledLineItemIdList.add(4);
		
		/*cancelledLineItemIdList1.add(1);
		cancelledLineItemIdList1.add(2);
		cancelledLineItemIdList1.add(3);
		cancelledLineItemIdList1.add(4);
		cancelledLineItemIdList1.add(5);
		cancelledLineItemIdList1.add(6);
		cancelledLineItemIdList1.add(7);*/
		
/*		boolean flag = cancelledLineItemIdList1.containsAll(cancelledLineItemIdList);
		System.out.println(flag);*/
		
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		
		set1.addAll(cancelledLineItemIdList);
		//set2.addAll(cancelledLineItemIdList1);
		
		set2.removeAll(set1);
		
		for (Integer diffElement : set2) {
	        System.out.println(diffElement.toString());
	    }
		
		
	}

}
