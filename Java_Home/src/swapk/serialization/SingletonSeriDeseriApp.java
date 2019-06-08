package swapk.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

class SingletonSeriDeseriApp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1683843293047597287L;
	private String name;
	private int id;
	private static SingletonSeriDeseriApp INSTANCE = null;
	
	//private SingletonSeriDeseriApp() { }
	
	public static SingletonSeriDeseriApp getInstance() {
		if (INSTANCE == null) {
			synchronized (SingletonSeriDeseriApp.class) {
				INSTANCE = new SingletonSeriDeseriApp();
				INSTANCE.id = 2;
				INSTANCE.name = "swap";
			}         
		}
		return INSTANCE;
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		System.out.println("in readObject()");
		//ois.defaultReadObject();
		//id=ois.readInt();
        //name=(String)ois.readObject();
		/*synchronized (SingletonSeriDeseriApp.class) {
			if (INSTANCE == null) {
				INSTANCE = this;
			}
		}*/
	}
	
	private Object readResolve() throws ObjectStreamException {
		System.out.println("in readResolve()");
		return INSTANCE;
	}
	
	@Override
	public String toString() {
		return "SingletonSeriDeseriApp [name=" + name + ", id=" + id + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Are objects same before serialization : "+ (getInstance() == getInstance()) );
		FileOutputStream fout=new FileOutputStream("f.txt");  
		ObjectOutputStream out=new ObjectOutputStream(fout);  

		System.out.println("serialization start....");
		out.writeObject(getInstance());  
		out.flush();  
		System.out.println("serialization done....");
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
		System.out.println("deserialization start....");
		SingletonSeriDeseriApp emp1=(SingletonSeriDeseriApp)in.readObject();  
		in.close();
		System.out.println(emp1);
		System.out.println("deserialization done....");
		
		System.out.println("Are objects same before serialization : "+ (emp1 == getInstance()) );
	}

}
