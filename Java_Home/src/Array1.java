import java.util.Scanner;


public class Array1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of Array -");
		int sizeOfArr = scan.nextInt();
		System.out.println("sizeOfArr ="+sizeOfArr);
		
		if(sizeOfArr > 100){
			System.out.println("size enterd > 100");
			return;
		}
			
		
		int[] arr = new int[sizeOfArr];
		for(int i=0;i<sizeOfArr;i++){
			arr[i] = scan.nextInt();
			if(arr[i]>1000 || arr[i]<0){
				System.out.println("array element is > 1000 || < 0");
				return;
			}
		}
		
		System.out.print("Arr = ");
		for(int i=0;i<sizeOfArr;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println("\n");
		
		System.out.println("Reverse Arr = ");
		for(int i=sizeOfArr-1;i>=0;i--)
			System.out.println(arr[i]+" ");
	}

}
