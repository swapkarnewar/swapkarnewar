import java.io.IOException;


class Game 
{
	void play()
	{
		
	}
}
class Cricket extends Game
{
	protected void play()
	{
		
	}
}

public class TestGame {

	public static void main(String[] args) {
        //m();
		
		try{
            throw new IOException();
     }catch(IOException | ArithmeticException ex){
            System.out.println(ex + " handled ");
     }   
		
	}
 
	static void m(){
        try{
               int i=10/0;
        }catch(ArithmeticException e){
               System.out.println("catch");
        }finally{
        	System.out.println("sdsd");;
        }
        
        System.out.println("after finaly");
        
	}
	
}
