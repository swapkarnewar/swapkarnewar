package swapk.cache;

public class CacheTest {

	public static void main(String[] args) {
		
		String str = "Swapnil";
		CacheService.putInCache(str, 1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object obj = CacheService.getCache("Swapnil");
		
		System.out.println("Cached Obj = "+obj);
	}

}
