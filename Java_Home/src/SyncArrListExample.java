import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class SyncArrListExample {

	public static void main(String[] args) {
		 
        final List<Integer> synchronizedArrayList = new ArrayList<Integer>();
        //final List<Integer> synchronizedArrayList;

        // Let's make arrayList synchronized
        //synchronizedArrayList = Collections.synchronizedList(arrayList);
        
        //Thread 1 will add elements in synchronizedArrayList
        Thread t1 = new Thread(new Runnable() {

               public void run() {
		            	   try {
		           			Thread.sleep(1000);
		           		} catch (InterruptedException e) {
		           			// TODO Auto-generated catch block
		           			e.printStackTrace();
		           		}
                            synchronizedArrayList.add(12);
               }
        }, "thread-1");
        
        t1.start();
        
        
        System.out.println("size = " + synchronizedArrayList.size());
        
        for(int j=0; j<synchronizedArrayList.size(); j++)
        	System.out.println("ele - " + synchronizedArrayList.get(j).toString());

        //Thread 2 will iterate on synchronizedArrayList
        Thread t2 = new Thread(new Runnable() {
               public void run() {
            	   System.out.println("int t2 - "+synchronizedArrayList.get(0));
               }
        }, "thread-2");
        t2.start();

 }

}
