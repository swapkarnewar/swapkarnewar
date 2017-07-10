import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class WriteObjToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setStreet("MG Road");
		
		try {
			System.out.println("Start");
			FileOutputStream fos = new FileOutputStream("C:\\ABC.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(addr);
			oos.close();
			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("in Exception");
			e.printStackTrace();
		}
	}

}
