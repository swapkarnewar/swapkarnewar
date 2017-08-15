package swapk.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import swapk.collection.CustHashMap.Employee;

public class EmpSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Employee emp = new Employee(1, "swapnil");
		FileOutputStream fout=new FileOutputStream("f.txt");  
		ObjectOutputStream out=new ObjectOutputStream(fout);  

		out.writeObject(emp);  
		out.flush();  
		System.out.println("success");  
		
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
		Employee emp1=(Employee)in.readObject();  
		System.out.println(emp1);  

		in.close();  


		
	}

}
