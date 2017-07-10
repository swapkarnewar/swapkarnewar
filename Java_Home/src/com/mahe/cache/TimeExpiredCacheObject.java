package com.mahe.cache;

class TimeExpiredCacheObject implements TimeExpiredCachable
{

	private Object obj;
	
	private java.util.Date dateofExpiration;
	
	public TimeExpiredCacheObject(Object obj, int minutesToLive)
    {
      this.obj = obj;
      // minutesToLive of 0 means it lives on indefinitely.
      if (minutesToLive != 0)
      {
        dateofExpiration = new java.util.Date();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(dateofExpiration);
        cal.add(cal.MINUTE, minutesToLive);
        dateofExpiration = cal.getTime();
      }
    }
	
	@Override
	public String toString() {
		return "TimeExpiredCacheObject [obj=" + obj + "]";
	}

	@Override
	public boolean isExpired() 
	{
		if (dateofExpiration != null)
		{
			if (dateofExpiration.before(new java.util.Date()))
			{
				System.out.println("CachedResultSet.isExpired:  Expired from Cache! EXPIRE TIME: " 
			+ dateofExpiration.toString() + " CURRENT TIME: " +
							(new java.util.Date()).toString());
				return true;
			}
			else
			{
				System.out.println("CachedResultSet.isExpired:  Expired not from Cache!");
						return false;
			}
		}
		else
			return false;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((obj == null) ? 0 : obj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeExpiredCacheObject other = (TimeExpiredCacheObject) obj;
		if (this.obj == null) {
			if (other.obj != null)
				return false;
		} else if (!this.obj.equals(other.obj))
			return false;
		return true;
	}
}
