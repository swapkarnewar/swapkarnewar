package swapk.cache;

import java.util.Calendar;
import java.util.Date;

public class CachableObject implements Cachable {
	
	private Object obj;
	private Date dateOfExpiration;
	
	public CachableObject(Object obj, int timeToLive) {
		this.obj = obj;
		
		if( timeToLive != 0 ){
			dateOfExpiration = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateOfExpiration);
			cal.add(cal.MINUTE, timeToLive);
			dateOfExpiration = cal.getTime();
		}
	}
	
	@Override
	public boolean isExpired() {
		
		if (dateOfExpiration != null){
			if (dateOfExpiration.before(new java.util.Date())) {
				System.out.println("CachableObject.isExpired()::Expired from Cache! EXPIRE TIME: "+dateOfExpiration.toString()+" CURRENT TIME: "+(new java.util.Date()).toString());
				return true;
			}
			else {
				System.out.println("CachableObject.isExpired()::NOT Expired from Cache!");
				return false;
			}
		}
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "CachableObject [obj=" + obj + ", dateOfExpiration="
				+ dateOfExpiration + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((obj == null) ? 0 : obj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CachableObject other = (CachableObject) obj;
		if (this.obj == null) {
			if (other.obj != null)
				return false;
		} else if (!this.obj.equals(other.obj))
			return false;
		return true;
	}
	
	

}
