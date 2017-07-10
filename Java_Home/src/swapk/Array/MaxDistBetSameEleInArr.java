package swapk.Array;

import java.util.HashMap;
import java.util.Map;

public class MaxDistBetSameEleInArr {

	public static void main(String[] args) {
		int [] arr = {3,2,1,2,1,4,5,8,2,6,7,4,3};
		Map<Integer, Integer> mapEleOcc = new HashMap<Integer, Integer>();
		int maxDist = 0;
		
		for(int i = 0; i <= arr.length -1; i++) {
			if( !mapEleOcc.containsKey(arr[i]) )
				mapEleOcc.put(arr[i], i);
			else
				maxDist = Math.max(maxDist, i-mapEleOcc.get(arr[i]));
		}
		
		System.out.println(maxDist);
	}

}
