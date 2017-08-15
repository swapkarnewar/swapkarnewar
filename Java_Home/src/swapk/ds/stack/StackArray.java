package swapk.ds.stack;


public class StackArray<T> {
	private int maxSize;
	private int top;
	private T[] stackArray;
	
	public StackArray( int size ){
		top = -1;
		maxSize = size;
		stackArray = (T[]) new Object[maxSize];
	}
	
	public boolean isStackEmpty(){
		return (top == -1);
	}
	
	public boolean isStackFull(){
		return ( top == maxSize-1 );
	}
	
	public void push(T data) throws Exception{
		if( isStackFull() )
			throw new Exception("Stack is Full.");
		stackArray[++top] = data;
	}
	
	public T pop() throws Exception{
		if( isStackEmpty() ){
			throw new Exception("Stack is Empty.");
		}
		T data = stackArray[top];
		top--;
		return data;
	}
	
	public T peek() throws Exception{
		if( isStackEmpty() ){
			throw new Exception("Stack is Empty.");
		}
		T data = stackArray[top];
		return data;
	}
	
	public void displayStack(){
		try{
			for(int iTemp=0; iTemp<=top; iTemp++){
				T data = stackArray[iTemp];
				System.out.print(data+" ");
			}
			System.out.println("\t");
		}
		catch( Exception e ){
			System.out.println("XXXXXX --- Caught exception in Display. ---- XXXXXX");
		}
	}
	
	public static void main( String a[] ){
		StackArray<Integer> stackArray = new StackArray<>(5);
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
