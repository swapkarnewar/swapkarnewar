import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/problem/algorithm/what-is-the-maximum-distance-that-you-can-cover-505/
 * @author skarnewar
 *
 */
public class MaxDistance {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        double maxDistCovered = 0d;
		int N = s.nextInt();
		double [] arrSpeed = new double[N];
		double [] arrDist = new double[N];
        for (int i = 0; i < N; i++) {
            arrSpeed[i] = s.nextInt();
        }
        
        for (int i = 0; i < N; i++) {
        	arrDist[i] = s.nextInt();
        }
        
        final double FUEL_CAPACITY = s.nextInt();
        
        for (int i = 0; i < N; i++) {
        	//double val = Double.parseDouble(new DecimalFormat("##.###").format(findMaxDist(arrSpeed[i], arrDist[i], FUEL_CAPACITY)));
        	double val = findMaxDist(arrSpeed[i], arrDist[i], FUEL_CAPACITY);
        	if( maxDistCovered < val )
        		maxDistCovered = val;
        }
        
        //System.out.printf("%.3f",maxDistCovered);
	    double test = maxDistCovered*1000;
	    int a = (int)test;
	    double dVal1 = a/1000d;
	    System.out.println(dVal1);
        
	}

	private static double findMaxDist(double x, double y, double fualCap) {
		return ((x*fualCap)/y);
	}

}
