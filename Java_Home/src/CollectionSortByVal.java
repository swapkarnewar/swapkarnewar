import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class PSO {
	String name;
	int id;
	PSO(String name, int id) {
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "PSO [name=" + name + ", id=" + id + "]";
	}
}
public class CollectionSortByVal {

	public static void main(String[] args) {
		
		Map<Integer, String> testMap = new HashMap<Integer, String>();
		testMap.put(1, "S");
		testMap.put(2, "K");
		testMap.put(3, "H");
		testMap.put(4, "N");
		testMap.put(5, "Sa");
		
		//System.out.println(testMap);
		
		System.out.println(testMap.keySet());
		System.out.println(testMap.values());
		Set<Entry<Integer, String>> entrySet = testMap.entrySet();
		System.out.println(entrySet);
		
		List<Entry<Integer, String>> listOfentrySet = new ArrayList<Entry<Integer, String>>(entrySet);
		
		//System.out.println(listOfentrySet.get(0).getValue());
		
        System.out.println("Before sorting by value: "+listOfentrySet);
        Collections.sort(listOfentrySet, new Comparator<Map.Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> o1,
					Entry<Integer, String> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
        	
		});
        System.out.println("Before sorting by value: "+listOfentrySet);
        
        PSO pso1 = new PSO("swapnil", 1);
        PSO pso2 = new PSO("har", 2);
        PSO pso3 = new PSO("sah", 3);
        
        Map<PSO, Integer> psoMap = new HashMap<PSO, Integer>();
        psoMap.put(pso1, 1);
        psoMap.put(pso2, 2);
        psoMap.put(pso3, 3);
        
        System.out.println(psoMap);
        Set<Entry<PSO, Integer>> psoEntrySet = psoMap.entrySet();
        List<Entry<PSO, Integer>> psoListEntry = new ArrayList<Map.Entry<PSO,Integer>>(psoEntrySet);
        Collections.sort(psoListEntry, new Comparator<Entry<PSO, Integer>>() {

			@Override
			public int compare(Entry<PSO, Integer> o1, Entry<PSO, Integer> o2) {
				return o1.getKey().name.compareTo(o2.getKey().name);
			}
        	
		});
        System.out.println("EMp:::::::::"+psoListEntry);
	}

}
