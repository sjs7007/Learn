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
	    rank=0;
	    int n = a.length();
	    for(int i=0;i<a.length();i++) {
	    //	 charRank.get(a.charAt(i));
	    	int ipRank = (int)charRank.get(a.charAt(i));
	    	///System.out.println(ipRank);
	    	int smallerPresent=0;
	    	for(int j=0;j<i;j++) {
	    		if((int)charRank.get(a.charAt(j)) < ipRank) {
	    			smallerPresent++;
	    		}
	    	}
	    	System.out.println((ipRank-1-smallerPresent)+" "+factorial(n-i-1));
	    	int temp1 = ipRank-1-smallerPresent;
	    	if(temp1>0) {
	    		rank = rank + temp1*factorial(n-i-1);
	    	}
	    	if(rank>1000003) {
	    		rank = rank % 1000003;
	    	}
	    }
	    rank=rank+1;
	    return rank;
	}
	
	public static int factorial(int x) {
	    int fac=1;
	    while(x>1) {
	        fac=fac*x;
	        x--;
	  		if(fac>1000003) {
	  			fac = fac % 1000003;
	  		}
	    }
	    return fac;
	}

	public static void main(String args[]) {
		System.out.println(findRank("oqnxiamw"));
	}
}
