import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class SyncArrListExample {

	public static void main(String[] args) {
		 
        final List<Integer> arrayList = new ArrayList<Integer>();
        final List<Integer> synchronizedArrayList;

        // Let's make arrayList synchronized
        synchronizedArrayList = Collections.synchronizedList(arrayList);
        
        //Thread 1 will add elements in synchronizedArrayList
        Thread t1 = new Thread(new Runnable() {

               public void run() {
                     for (int i = 0; i <= 3; i++) {
                            synchronizedArrayList.add(i);
                     }
               }
        }, "thread-1");
        
        t1.start();
        
        System.out.println(synchronizedArrayList.size());
        
        for(int j=0; j<synchronizedArrayList.size(); j++)
        	System.out.println(synchronizedArrayList.get(j).toString());

        //Thread 2 will iterate on synchronizedArrayList
        /*Thread t2 = new Thread(new Runnable() {
               public void run() {
                     Iterator<Integer> it = synchronizedArrayList.iterator();
                     while (it.hasNext()) {
                            try {
                                   Thread.sleep(100);
                            } catch (InterruptedException e) {
                                   e.printStackTrace();
                            }
                            System.out.println(it.next());//throws ConcurrentModificationException
                     }

               }
        }, "thread-2");*/
        //t2.start();

 }

}
