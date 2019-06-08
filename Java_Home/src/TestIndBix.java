import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class OK{
	String abc;
	
	
	void setStr(String a) {
		abc = a;
	}
	
	@Override
	public String toString() {
		return "OK [abc=" + abc + "]";
	}
}
class BaseA1{
	final public int GetResult(int a, int b) { return 0; }
	void disp() throws IOException {
		System.out.println("in base");
	}
	
	public void test() {
		System.out.println("in base");
	}
}

class CustomB1 extends BaseA1{
	public int GetResult(int a, int b, int c) {return 1; }
	void disp() throws RuntimeException {
		System.out.println("in base");
	}
	
	public void test() {
		System.out.println("in cust");
	}
}


class Producer implements Runnable {
	
	private List<Integer> sharedQueue;
	private int maxSize = 10;
	
	public Producer( List<Integer> sharedQueue ) {
		this.sharedQueue = sharedQueue;
	}
	
	@Override
	public void run() {
		for( int i = 1; i <= 10; i++ ) {
			try {
				produce(i);
			}
			catch( Exception e ) {
				e.printStackTrace();
			}
		}
	}

	public void produce(int i) throws InterruptedException {
		
		synchronized (sharedQueue) {
			System.out.println("produced..."+i);
			sharedQueue.add(i);
			Thread.sleep(1000);
			if( sharedQueue.size() == maxSize ) {
				sharedQueue.notify();
			}
		}
	}
	
}

class Consumer implements Runnable {
	
	private List<Integer> sharedQueue;
	
	public Consumer( List<Integer> sharedQueue ) {
		this.sharedQueue = sharedQueue;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				consume();
				Thread.sleep(100);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void consume() throws InterruptedException {
		
		synchronized (sharedQueue) {
			Thread.sleep(100);
			sharedQueue.wait();
			int size = sharedQueue.size();
			for( int i = 1; i <= size; i++ ) {
				System.out.println("Consumed..."+sharedQueue.remove(0));
			}
		}
	}
	
}

class BubbleSortTechnique {
	public static int[] sort( int[] arr ) {
		for( int i = 0; i < arr.length; i++ ) {
			for( int j = 0; j < arr.length-1-i; j++ ) {
				if( arr[j] > arr[j+1] ) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
}


public class TestIndBix implements Runnable{

	 int x, y; 
     
	 
	public static void main(String [] args) throws InterruptedException {
		
/*		TestIndBix run1 = new TestIndBix();
		TestIndBix run2 = new TestIndBix();
        Thread t1 = new Thread(run1); 
        Thread t2 = new Thread(run2); 
        t1.start(); 
        t2.start(); */
		
		
		List<Integer> sharedQueue = new LinkedList<Integer>();
		Producer p = new Producer(sharedQueue);
		Consumer c = new Consumer(sharedQueue);
		Thread producerThread = new Thread(p, "ProducerThread");
        Thread consumerThread = new Thread(c, "ConsumerThread");
        
        //consumerThread.start();
        //Thread.sleep(100);
        //producerThread.start();
        
        BaseA1 base = new BaseA1();
        //CustomB1 cust = (CustomB1) new BaseA1(); //Gives error
        base.test();
        
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(null, null);
        map.put(1, null);
        map.put(null, "s");
        map.put(1, "aaa");
        System.out.println(map);
        
        System.out.println("--------------");
        
        //////////////////
        int j=2, y=3, z = 10;
        for(;j<6; j++) {
        	y = (++y + z++);
        	System.out.println(y+z);
        }
        //////////////////
        
        byte a[] =  {65, 66, 67, 68, 69, 70};
        byte b[] =  {71, 72, 73, 74, 75, 76};
        System.arraycopy(a, 2, b, 1, a.length-2);
        //System.out.println(new String(a) + " " + new String(b));
        ///////////
        
        //String test = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001,";
        /*test = test.substring(0, test.length() - 1);
        System.out.println(test);*/
        
        
        System.out.println("->>>>>>>>>>>>>>");
        
        List<Integer> test = new CopyOnWriteArrayList<Integer>();
        test.add(10);
        test.add(20);
        test.add(5);
        test.add(30);
        test.add(4);
        test.add(20);
        test.add(60);
        
        /*ListIterator<Integer> lstItr = test.listIterator();
        while(lstItr.hasNext()) {
        	if(lstItr.hasPrevious() && lstItr.hasNext()) {
        		Integer aInt = (Integer)lstItr.next();
        		System.out.println(aInt);
        	}
        }*/
        
        List<Integer> index = new ArrayList<Integer>();
        for(int  i = 1; i < test.size()-1; i ++ ) {
        	int curr = test.get(i);
        	int prev = test.get(i-1);
        	int nex = test.get(i+1);
        	if( prev > curr && curr < nex  ) {
        		index.add(i);
        	}
        }
        
        System.out.println(index);
        List<Integer> newTest = new ArrayList<Integer>();
        int count = 0;
        for( int i = 0; i < test.size(); i++ ) {
        	if( index.contains(i) ) {
        		continue;
        	}
        	else
        		newTest.add(test.get(i));
        }
        
        test.removeAll(test);
        test.addAll(newTest);
        System.out.println(test);
        
        
        
	}
	
	



	public static String addLetter(char letter, char[] word){
		String sb = "";
		for(int i = 70; i < 500; i+=70 ) {
			sb = new StringBuilder(new String(word)).insert(i, letter).toString();
		}
		
		return sb;
		
	}

	
	
	public final static boolean isStringcontainsAllDigits(String s) {
	    boolean containsAllDigits = true;

	    if (s != null && !s.isEmpty()) {
	        for (char c : s.toCharArray()) {
	            if (!(containsAllDigits = Character.isDigit(c))) {
	            	containsAllDigits = false;
	            	break;
	            }
	        }
	    }
	    return containsAllDigits;
	}
	
	public void run() {
		System.out.println("Entering in run() by "+Thread.currentThread().getName());
		try {
			synchronized(TestIndBix.class) {
				System.out.println("In block by "+Thread.currentThread().getName());
				Thread.sleep(500);
				System.out.println("Exiting block by "+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting from run() by "+Thread.currentThread().getName());
	}
	  

}
