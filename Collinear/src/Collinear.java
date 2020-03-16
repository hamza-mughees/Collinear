// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author Hamza Mughees
 *  @version 18/09/18 12:21:09
 */
class Collinear
{

   // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     *
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * 
     * x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0 
     *
     * In our case y1=1, y2=2, y3=3.
     *
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     *
     * ----------------------------------------------------------
     *
     * 
     *  Order of Growth
     *  -------------------------
     *
     *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of growth: N^3
     *
     *  Explanation: Three linear for-loops
     *  
     *  For understanding purposes:
     *  x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)=0
     *  x1*(2-3) + x2*(3-1) + x3*(1-2)=0
     *  x1*(-1) + x2*(2) + x3*(-1)=0
     *  -x1 + 2*x2 - x3 =0
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3)
    {
      //TODO: implement this method
    	int count=0;
    	for (int i=0; i<a1.length; i++)
      	  for (int j=0; j<a2.length; j++)
      		  for (int k=0; k<a3.length; k++)
      			  if (-a1[i] + 2*a2[j] - a3[k] == 0)
      				  count++;
    	return count;
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-horizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2*log(N)
     *
     *  Explanation: Two linear for-loops with binary search order of growth multiplied
     *  
     *  For understanding purposes:
     *  This method will pick any two elements from a1 and a2.
     *  It will then add the difference between these elements onto the the element in a2.
     *  The result (search) will be searched for in a3 after a3 is sorted.
     *  search = a2[j] - a1[i] + a2[j]
     *  	   = 2*a2[j] - a1[i]  <-- formula used to calculate the number (search) to search in a3. 
     *
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3)
    {
      //TODO: implement this method
    	sort(a3);
    	int count = 0;
    	int search;
    	
    	for (int i=0; i<a1.length; i++)
    		for (int j=0; j<a2.length; j++)
    		{
    			search = 2*a2[j] - a1[i];
    			if (binarySearch(a3, search))
    				count++;
    		}
    	
    	return count;
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers. 
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2
     *
     *  Explanation: Two linear for-loops.
     *
     */
    static void sort(int[] a)
    {
      for ( int j = 1; j<a.length; j++)
      {
        int i = j - 1;
        while(i>=0 && a[i]>a[i+1])
        {
          int temp = a[i];
          a[i] = a[i+1];
          a[i+1] = temp;
          i--;
        }
      }
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: log(N)
     *
     *  Explanation: After each iteration, the array is halved
     *
     */
    static boolean binarySearch(int[] a, int x)
    {
      //TODO: implement this method
    	boolean contained = false;
    	int lo = 0;
    	int hi = a.length - 1;
    	
    	while (lo <= hi && !contained)
    	{
    		int mid = lo + (hi - lo)/2;
    		if (a[mid] > x)
        		hi = mid - 1;
        	else if (a[mid] < x)
        		lo = mid + 1;
        	else contained = true;
    	}
    	
    	return contained;
    }

}
