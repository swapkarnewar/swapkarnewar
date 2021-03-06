package swapk.collection.CustHashMap;


public class HashMapCustom {

	/**Using bucket array 
	 * contains entry object
	 * of default size 4 here
	 */
	
	private Entry<Integer, String>[] table;
	private int capacity = 4;//this is initial capacity of HashMap
	
	/**Entry class is inner class made as static class,
	 * So that it can be used 
	 * without creating object of outer class
	 */
	
	static class Entry<Integer, String>{
		Integer key;
		String value;
		Entry<Integer, String> next;
		
		public Entry(Integer key, String value, Entry<Integer, String> next) 
		{
			this.key = key;
			this.value = value;
			this.next = next;
		}

		@Override
		public java.lang.String toString() {
			return "Entry [key=" + key + ", value=" + value + "]";
		}
		
	}
	
	/**As soon as the object of 
	 * this custom hash map is created, 
	 * the array of entry should be initiated.
	 * So Added that code in Constructor of the HashMapCustom() 
	 */
	
	public HashMapCustom() {
		table = new Entry[4];
	}
	
	/**Method allows you put 
	 * key-value pair in HashMapCustom.
	 * NOTE: this method doesn't allows you to add null values
	 */
	
	public void put(Integer newKey, String data){
		if( newKey == null )
			return;	//doesn't allows to add null values as we have made it as custom
		
		//now calculate hash of key i.e the index of the bucket in bucket array
		int hash = hash(newKey);
		
		//now create the new Entry for the key-val pair as
		Entry<Integer, String> entry = new Entry<Integer, String>(newKey, data, null);
		
		//if table[hashVal] is null then add entry there
		if( table[hash] == null )
		{
			table[hash] = entry;
		}
		else
		{
			//go fwd and check the existin entry has same key i.e check with equals method
			Entry<Integer, String> current = table[hash];
			
			if( current.next == null )
			{
				//only one entry is there, so directly add the entry next to current, as
				if( current.key.equals(newKey) )
				{
					current.value = data;
					return;
				}
				else
				{
					current.next = entry;
				}
			}
			else
			{
				//multiple entries are there
				while( current.next != null )
				{
					if( current.key.equals(newKey) )
					{
						current.value = data;
						return;
					}
					else
					{
						current = current.next;
					}
				}
				current.next = entry;
			}
		}
	}

	/**This method calculated the hashcode of key, 
	 * that hash value is the mod by capacity 
	 * i.e 4 then we will take the absolute value 
	 * which is index of bucket array 
	 * that we dont want in float
	 */
	private int hash(Integer newKey) {
		return Math.abs(newKey.hashCode()%capacity);
	}

	/**
     * Method returns value corresponding to key.
     */
	public String get(Integer newKey){
		int hash = hash(newKey);
		
		if( table[hash] == null )
		{
			return null;
		}
		else
		{
			Entry<Integer, String> current = table[hash];
			
			while( current != null )
			{
				if( current.key.equals(newKey) )
				{
					return current.value;
				}
				else
				{
					current = current.next;
				}
			}
			return null;	
		}
	}

	/**This method removes the specified 
	 * key-value pair from custom hash map
	 * @newKey key to be removed
	 */
	public boolean remove(Integer newKey){
		int hash = hash(newKey);
		
		if( table[hash] == null ) {
			return false;
		}
		else
		{
			Entry<Integer, String> current = table[hash];
			Entry<Integer, String> previous = null;
			
			if( current.next == null )
			{
				//only one entry is there, so directly add the entry next to current, as
				if( current.key.equals(newKey) )
				{
					table[hash] = null;
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				//multiple entries are there
				if( current.key.equals(newKey) )
				{
					table[hash] = current.next;
					return true;
				}
				while( current != null )
				{
					if( current.key.equals(newKey) )
					{
						previous.next = current.next;
						return true;
					}
					else
					{
						previous = current;
						current = current.next;
					}
				}
				return false;
			}
			
		}
	}
	
	/**This method displays the current 
	 * contents of custom hash map
	 */
	public void display(){
		for( int i=0; i<capacity; i++ )
		{
			if( table[i] != null )
			{
				Entry<Integer, String> entry = table[i];
				while( entry != null )
				{
					System.out.println("{"+entry.key+"="+entry.value+"}" +" ");
					entry = entry.next;
				}
			}
		}
	}
	
}
