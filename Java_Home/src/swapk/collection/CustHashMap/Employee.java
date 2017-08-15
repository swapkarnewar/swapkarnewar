package swapk.collection.CustHashMap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Externalizable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7984403909913279269L;
	private Integer id;
	private String name;
	private String city;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String name) {
		System.out.println("Called constructor");
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writting");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Reading");
	}


}
