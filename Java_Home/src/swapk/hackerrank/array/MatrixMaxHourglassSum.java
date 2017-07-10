package swapk.hackerrank.array;

import java.util.Scanner;

public class MatrixMaxHourglassSum {

	public static int maxSum = 0;
	public static int arr[][] = new int[6][6];
	
	public static void main( String[] args ) {
		
		Scanner in = new Scanner(System.in);
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        
        /*for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                System.out.print(arr[arr_i][arr_j]+" ");
            }
            System.out.println();
        }*/
        
        for( int i = 0; i < 4; i++ ) {
        	for( int j = 0; j < 4; j++ ) {
        		findMaxHourglassSum(i,j);
        	}
        }
        
        System.out.println(maxSum);
	}

	private static void findMaxHourglassSum(int i, int j) {
		int temp = 0;
		
		//sum of rows
		for( int k = j; k <= j+2; k++ ) {
			temp = temp + arr[i][k];
			temp = temp + arr[i+2][k];
		}
		//adding sum of middle element
		temp = temp + arr[i+1][j+1];
		
		if( maxSum < temp ) {
			maxSum = temp;
		}
	}
	
}
