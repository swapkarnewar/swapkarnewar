package swapk.therads.latest;
/**
 * Program to show that without synchronization problems will happen when  2 passengers try to book train ticket, dat too when only 1 ticket was available
 * Program to show that with synchronization no problems will happen when  2 passengers try to book train ticket, dat too when only 1 ticket was available
 * @author SKarnewar
 *
 */

class TicketCounter implements Runnable {

	static int ticketsRemained = 1;
	
	@Override
	public void run() {
		System.out.println("Book ticket for " + Thread.currentThread().getName());
		//Remove sync block here and see RACE condition here
		synchronized (this) {
			if( ticketsRemained > 0 ) {
				System.out.println("Going to book ticket for " + Thread.currentThread().getName());
				//some logic
				ticketsRemained--;
				System.out.println("Ticket booked for " + Thread.currentThread().getName());
				System.out.println("currently ticketsAvailable = "+ticketsRemained);
			}
			else {
				System.out.println("All tickets are booked....");
			}
		}
	}
	
}

public class RaceConditionEx {

	public static void main(String[] args) {
		TicketCounter tc = new TicketCounter();
		Thread t1 = new Thread(tc);
		Thread t2 = new Thread(tc);
		t1.start();
		t2.start();
	}

}
