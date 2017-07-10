package swapk.collection.CustHashMap;

public class Employee {
	
	private Integer id;
	private String name;
	
	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString(){
		return "Employee: id->"+id+", name->"+name;
	}
	
	public int hashCode(){
		return id.hashCode()+name.hashCode();
	}
	
	public boolean equals( Object o)
	{
		if( o == null )
			return false;
		if( this.getClass() != o.getClass() )
			return false;
		
		Employee e = (Employee)o;
		return e.id.equals(this.id) && e.name.equals(this.name);
	}
}
