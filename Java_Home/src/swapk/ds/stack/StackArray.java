package swapk.ds.stack;

public class StackArray {
	private int maxSize;
	private int top;
	private int[] stackArray;
	
	public StackArray( int size ){
		top = -1;
		maxSize = size;
		stackArray = new int[maxSize];
	}
	
	public boolean isStackEmpty(){
		return (top == -1);
	}
	
	public boolean isStackFull(){
		return ( top == maxSize-1 );
	}
	
	public void push(int data) throws Exception{
		if( isStackFull() )
			throw new Exception("Stack is Full.");
		stackArray[++top] = data;
	}
	
	public int pop() throws Exception{
		if( isStackEmpty() ){
			throw new Exception("Stack is Empty.");
		}
		int data = stackArray[top];
		top--;
		return data;
	}
	
	public int peek() throws Exception{
		if( isStackEmpty() ){
			throw new Exception("Stack is Empty.");
		}
		int data = stackArray[top];
		return data;
	}
	
	public void displayStack(){
		try{
			for(int iTemp=0; iTemp<=top; iTemp++){
				int data = stackArray[iTemp];
				System.out.print(data+" ");
			}
			System.out.println("\t");
		}
		catch( Exception e ){
			System.out.println("XXXXXX --- Caught exception in Display. ---- XXXXXX");
		}
	}
	
	public static void main( String a[] ){
		StackArray stackArray = new StackArray(5);
		try{
			stackArray.push(1);
			stackArray.push(2);
			stackArray.push(3);
			stackArray.push(4);
			stackArray.push(5);
			stackArray.displayStack();
			System.out.println("Popped element = "+stackArray.pop());
			System.out.println("Now peek is = "+stackArray.peek());
			stackArray.displayStack();
			
		}
		catch( Exception e ){
			System.out.println("XXXXXX --- Caught exception. ---- XXXXXX");
		}
		
	}
}
