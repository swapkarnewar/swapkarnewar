import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

class MyCollectionUtil{
	public static void display(Collection col){
		Iterator itr = col.iterator();
		while( itr.hasNext() ){
			System.out.println(itr.next());
		}
	}
}

class Temporary {
	 
    
    public String toString() {
        return "Temporary";
    }
    
    public void finalize(){
        System.out.println("Finalize method called");
    }
}

public class TestCollection {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Map hashMap= new WeakHashMap();
		
		Temporary t1 = new Temporary();
		Temporary t2 = new Temporary();
		
		hashMap.put(t1,"sai");
		System.out.println("B4:- "+hashMap);
		t1=null;
        System.gc();
        System.out.println("After :- "+hashMap);
		
        
        Set set = new HashSet();
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		/*System.out.println(set.add("10"));
		System.out.println(set.add("20"));
		System.out.println(set.add("20"));//not added since set restrict duplicates
		System.out.println(set.add("Nitil"));
		System.out.println(set.add(null));*/
		set.add("Swapnil");
		set.add("snehal");
		set.add("snehalllll");
		set.add("swap");
		
		MyCollectionUtil.display(set);
		Iterator k = set.iterator();
		while( k.hasNext() ) {
			String d = (String) k.next();
			if( "snehal".equals(d) ) {
				//set.add("love"); //error since fail-fast
				System.out.println("hi--------");
			}
		}
		MyCollectionUtil.display(set);
		//output of set is like stack, FIFO
		//here snehal and then Swapnil
		//MyCollectionUtil.display(set);
		
		/*Iterator<Integer> itr2 = set.iterator();
		while( itr2.hasNext() )
		{
			System.out.println(itr2.next());
		}*/
		
		
		list.add(10);
		list.add(30);
		list.add(20);
		list.add(50);
		list.add(60);
		//int b = list.set(1, 40);
		//Collections.reverse(list);
		/*System.out.println(list);
		*/
		
		/*for( Integer n : list ){
			System.out.println(n);
			if( n == 20 )
				list.add(50);
		}*/ //same ConcurrentModificationException
		
		
		
		Iterator listItr = list.iterator();
		while( listItr.hasNext() ){
			int a = (int) listItr.next();
			System.out.println(a);
			if( a == 20 )
				list.add(100);
		}  //same ConcurrentModificationException
		
		/*while( listItr.hasNext() ){
			int a = (int) listItr.next();
			System.out.println(a);
			if( a == 20 )
				listItr.remove();;
		}*/
		
		System.out.println("list is here-"+list);
		
		//boolean flag = list.add("snehal");
		//boolean flag2 = list.remove("snehal");
		//System.out.println(flag);
		//System.out.println(flag2);
		//MyCollectionUtil.display(list);
		
/*		NavigableSet<String> myCollection = new TreeSet();
		myCollection.add("1");
		myCollection.add("6");
		myCollection.add("76");
		myCollection.add("2");
		myCollection.add("4");
		myCollection.add("3");*/
		
		//MyCollectionUtil.display(myCollection);
		//System.out.println(myCollection.headSet("3",true));
		
		//System.out.println(myCollection.ceiling("5"));
		ConcurrentHashMap<Integer, String> myMap = new ConcurrentHashMap<Integer, String>();
		//Map<Integer, String> mySyncMap = Collections.synchronizedMap(myMap);
		myMap.put(1, "Swap");
		myMap.put(33, "Nitil");
		myMap.put(5, "AAbc");
		myMap.put(20, "snehal");
		
		/*Iterator itr = myMap.keySet().iterator();
		
		//System.out.println(myMap.keySet());
		
		while( itr.hasNext() )
		{
			Object i = itr.next();
			System.out.println(myMap.get(i));
			if( ((Integer)i).intValue() == 2 ){
				myMap.put(7, "harnee");
			}
		}*/

		myMap.put(15, "chikuu");
		myMap.put(4, "A");
		
		
		Set<Entry<Integer,String>> entrySet = myMap.entrySet();
		System.out.println("entrySet - " + entrySet);
		

		//sort by key
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(myMap);
		Set<Entry<Integer,String>> entrySetOfTree = treeMap.entrySet();
		System.out.println("after sort by key= "+entrySetOfTree);
		
		//sort by val
		Comparator<Entry<Integer, String>> valueComparator = new Comparator<Entry<Integer,String>>() {
            
            @Override
            public int compare(Entry<Integer, String> e1, Entry<Integer, String> e2) {
                String v1 = e1.getValue();
                String v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };

     // Sort method needs a List, so let's first convert Set to List in Java
        List<Entry<Integer, String>> listOfEntries = new ArrayList<Entry<Integer, String>>(entrySet);
        
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        
        LinkedHashMap<Integer, String> sortedByValue = new LinkedHashMap<Integer, String>(listOfEntries.size());
        
        // copying entries from List to Map
        for(Entry<Integer, String> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println("after sort by val="+ sortedByValue);

		
	/*	Collections.reverse(mapValList);
		System.out.println(mapValList);*/
		
		ConcurrentSkipListSet<String> copySet = new ConcurrentSkipListSet<String>();
		/*copySet.add(null);
		copySet.add(null);
		copySet.add(null);*/
		copySet.add("snehalLove");
		copySet.add("snehalLove");//it will not print as duplicate
		MyCollectionUtil.display(copySet);
		/*while( itr.hasNext() )
		{
			Object key = itr.next();
			Object value = myMap.get(key);
			System.out.println(value);
		}*/
		//System.out.println(mySortedMap.lastKey());
		
		//TEsting if list has no elements will iterator work?
		List<Integer> listInt = new ArrayList<>();
		Iterator i = listInt.iterator();
		
		System.out.println("hasElement : "+i.hasNext());
		//System.out.println("elements : "+i.next());
		
		Long q = -129L;
		Long z = -129L;
		System.out.println(q==z);
		
		System.out.println("asssssssssssssssssssssssssssssssssssssssssssssssss");
		Set<Integer> sp = new CopyOnWriteArraySet<>();
		sp.add(11);
		sp.add(12);
		Iterator t = sp.iterator();
		while(t.hasNext()) {
			sp.add(13);
			System.out.println(t.next());
		}
		
		System.out.println(sp);
		
		
		
		
	}
	
}
