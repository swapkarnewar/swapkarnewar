import java.util.Scanner;


public class MonkAndTimeByQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter total number of elements");
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		if( N > 100)
			return;
		int[] calling = new int[N];
		int[] ideal = new int[N];
		
		for(int i=0; i<N; i++)
		{
			calling[i] = Integer.parseInt(scan.nextLine());
		}
		System.out.print("calling seq:");
		for(int i=0; i<N; i++)
			System.out.print(calling[i]+" ");
		System.out.println("-----------");
		
		for(int i=0; i<N; i++)
		{
			ideal[i] = Integer.parseInt(scan.nextLine());
		}
		System.out.print("ideal seq:");
		for(int i=0; i<N; i++)
			System.out.print(ideal[i]+" ");
		
		int i =0;
		int timeCount = 0;
		int pushVar;
		
		while(N>0)
		{
			if(ideal[i] == calling[0]){
				shiftArray(calling, N);
				N--;
				timeCount++;
				i++;
				
			}
			else{
				pushVar = calling[0];
				shiftArray(calling, N);
				calling[N-1] = pushVar;
				timeCount++;
			}
		}
		System.out.println("Final timeCount = "+timeCount);
	}

	public static void shiftArray(int[] calling, int n)
	{
		for(int i=0; i<n-1; i++)
			calling[i] = calling[i+1];
			//System.out.print(calling[i]+" ");
		/*int j = 0;
		for(j=0;j<n-1;j++);
			calling[j] = calling[j+1];*/
	}
}
