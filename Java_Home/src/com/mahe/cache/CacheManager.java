package com.mahe.cache;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class CacheManager 
{
	private static Set<TimeExpiredCachable> cacheSet = new HashSet<TimeExpiredCachable>();

	static
	{
		try
		{
			Thread threadCleanerUpper = new Thread(
					new Runnable()
					{
						int milliSecondSleepTime = 5000;
						public void run()
						{
							try
							{
								while (true)
								{
									System.out.println("ThreadCleanerUpper Scanning For "
											+ "Expired Objects...");
									Iterator<TimeExpiredCachable> keys = cacheSet.iterator();
									while(keys.hasNext())
									{
										Object key = keys.next();
										TimeExpiredCachable value = (TimeExpiredCachable)key;
										if (value.isExpired())
										{
											keys.remove();
											System.out.println("ThreadCleanerUpper Running. "
													+ "Found an Expired Object in the Cache."+value);
										}
									}
									Thread.sleep(this.milliSecondSleepTime);
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							return;
						} 
					}); 
			threadCleanerUpper.setPriority(Thread.MIN_PRIORITY);
			threadCleanerUpper.start();
		}
		catch(Exception e)
		{
			System.out.println("CacheManager.Static Block: " + e);
		}
	}

	public static void putInCache(Object obj,int minutesToLive)
	{
		TimeExpiredCachable cacheObj = new TimeExpiredCacheObject(obj, minutesToLive);
		cacheSet.add(cacheObj);
	}

	public static Object getCache(Object identifier)
	{
		Object returnObj = null;
		if(cacheSet.contains(new TimeExpiredCacheObject(identifier,0)))
		{
			returnObj = identifier;
		}
		return returnObj;
	}
}
