// http://www.tutorialspoint.com/java/java_hashmap_class.htm
// hasmap key value pair
import java.util.*;

public class Solution {
	public static int findRank(String a) {
	    PriorityQueue<Character> PQ= new PriorityQueue(); 
	    for(int i=0;i<a.length();i++) {
	    	PQ.add(a.charAt(i));
	    }
	    HashMap charRank = new HashMap();
	    int rank=0;
	    while(PQ.size()>0) {
	    	rank++;
	    	char temp = PQ.poll();
	    	charRank.put(temp,rank);
	    	System.out.println(temp+" "+charRank.get(temp));
	    }
	    return -1;
	}
	
	public int factorial(int x) {
	    int fac=1;
	    while(x>1) {
	        fac=fac*x;
	        x--;
	    }
	    return fac;
	}

	public static void main(String args[]) {
		findRank("apqrxyzbcd");
	}
}
