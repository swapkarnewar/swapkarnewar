import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class ReadObjFromFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address address;

		   try{
			   System.out.println("Start");
			   
			   FileInputStream fin = new FileInputStream("c:\\ABC.ser");
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   address = (Address) ois.readObject();
			   ois.close();

			   System.out.println(address.getStreet()+", "+address.getCity());
			   System.out.println("Done");

		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	}

}
