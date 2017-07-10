package swapk.geekForGeeks;

import java.io.*;
import java.util.Scanner;

class GFG {
    
	public static void main (String[] args) {
		//code
		int[] array1 = new int[100];
		int[] array2 = new int[100];
		
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while( t > 0 ) {
            int n = sc.nextInt();
            // Input the array1
            for (int i = 0; i < n; i++)
                array1[i] = sc.nextInt();
 
            // Input the array2
            for (int i = 0; i < n; i++)
                array2[i] = sc.nextInt();
            
            System.out.println(compareTwoArrays(array1, array2));
            
            t--;
        }
	}
	
	private static int compareTwoArrays(int[] array1, int[] array2) 
	{
	    int flag = 1;
	    boolean[] temp = new boolean[1001];
	    for(int i = 0; i <= temp.length-1; i++) 
	    {
	        temp[i] = false;
	    }
	    
	    for(int i = 0; i <= array1.length-1; i++) 
	    {
	        temp[array1[i]] = true;
	    }
	    
	    for(int i = 0; i <= array2.length-1; i++) 
	    {
	       if(! temp[array2[i]])
	       {
	           flag = 0;
	           break;
	       }
	    }
	    return flag;
	    
	}
}