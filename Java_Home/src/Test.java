interface Side{	
	String getSide();
	}
class Head implements Side{
	public Head(){
		System.out.println("'Head Constructor' ");
	}
	@Override
	public String getSide() {
		return "Head ";
	}
}
class Tail implements Side{
	public Tail(){
		System.out.println("'Tail Constructor' ");
	}
	@Override
	public String getSide() {
		return "Tail ";
	}
}
public class Test {
	public Test(){
		System.out.println("'Test Constructor' ");
	}
	public static void overload(Head side){ 
		System.out.print(side.getSide()); 
	}
	public static void overload(Tail side){
		System.out.print(side.getSide()); 
	}
	public static void overload(Side side){
		System.out.print("Side "); 
	}
	public static void overload(Object side){
		System.out.print("Object "); 
	}
	public static void main1(String[] args) {
		Side firstAttempt = new Head();
		Tail secondAttempt = new Tail();
		overload(firstAttempt);
		overload((Object)firstAttempt);
		//overload(secondAttempt);
		//overload((Side)secondAttempt);
	}
}
