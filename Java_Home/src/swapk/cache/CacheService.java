package swapk.cache;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CacheService {

	private static Set<Cachable> cacheSet = new HashSet<Cachable>();
	
	static {
		//need to start thread
		try {
			Thread backEndThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						while( true ) {

							System.out.println("Back End Thread Scanning For Expired Objects...");
							Iterator<Cachable> keys = cacheSet.iterator();
							while(keys.hasNext())
							{
								Object key = keys.next();
								Cachable value = (Cachable)key;
								if (value.isExpired())
								{
									keys.remove();
									System.out.println("ThreadCleanerUpper Running. Found an Expired Object in the Cache."+value);
								}
							}
							Thread.sleep(5000);
						
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
			});
			
			backEndThread.setPriority(Thread.MIN_PRIORITY);
			backEndThread.start();
			Thread.sleep(30000);
	        System.exit(0);
		}
		catch(Exception e) {
			System.out.println("CacheService.Static Block: " + e);
		}
	}
	
	public static void putInCache(Object obj, int timeToLive)
	{
		Cachable cacheObj = new CachableObject(obj, timeToLive);
		cacheSet.add(cacheObj);
	}

	public static Object getCache(Object obj)
	{
		Object returnObj = null;
		if(cacheSet.contains(new CachableObject(obj,0)))
		{
			returnObj = obj;
		}
		return returnObj;
	}
	
}
