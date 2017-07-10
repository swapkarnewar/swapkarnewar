package swapk.hackerrank.array;

import java.util.Scanner;

public class ArrayReversal {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        for(int arr_i=0; arr_i < n; arr_i++){
            System.out.print(arr[arr_i]+" ");
        }
        
        System.out.println("n="+n);
        
        for( int i = 0; i <= (n/2 - 1) ; i++ ) {
        	int temp = arr[n-1-i];
        	arr[n-1-i] = arr[i];
        	arr[i] = temp;
        }
        
        for(int arr_i=0; arr_i < n; arr_i++){
            System.out.print(arr[arr_i]+" ");
        }
		
	}

}
