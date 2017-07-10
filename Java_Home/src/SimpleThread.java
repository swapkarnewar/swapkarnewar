import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleThread {

	public static List<String> arrList = new ArrayList<String>();
	
	static{
		arrList = getArrList();
		arrList = Collections.synchronizedList(arrList);
	}
	
	private static List<String> getArrList() {
        arrList.add("swap");
        arrList.add("harneesha");
        arrList.add("mas");
		return arrList;
	}
	
	public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        System.out.println("Staring main thread");
        
        t1.start();
        t2.start();
        System.out.println("Exiting main thread");
    }
	

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        try {
            SimpleThread.arrList.add("SWAPHAR");
            Thread.sleep(4000);
            for( String text :  SimpleThread.arrList){
            	System.out.println(Thread.currentThread().getName()+" "+ text);
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }
    
}