// http://www.tutorialspoint.com/java/java_hashmap_class.htm
// hasmap key value pair
import java.util.*;

public class Rank2 {
	public static int findRank(String a) {
	    PriorityQueue<Character> PQ= new PriorityQueue(); 
	    for(int i=0;i<a.length();i++) {
	    	PQ.add(a.charAt(i));
	    }
	    //HashMap charRank = new HashMap();
	    Map<Character,ArrayList<Integer>> charRank  = new HashMap<Character,ArrayList<Integer>>(); //pos 1 rank, 2 count
        int rank=0;
	    while(PQ.size()>0) {
	    	char temp = PQ.poll();
            if(!charRank.containsKey(temp)) {
                rank++;
                charRank.put(temp,new ArrayList<Integer>(Arrays.asList(rank,1)));
            }
            else {
                ArrayList temp2 = charRank.get(temp);
                //System.out.println(temp2.get(0));
                //System.out.println(temp2.get(1));
                charRank.put(temp,new ArrayList<Integer>(Arrays.asList((int)temp2.get(0),(int)temp2.get(1)+1)));
            }
	    	//System.out.println(temp+" "+charRank.get(temp));
	    }


        /* Print hashmap 
            // Get a set of the entries
          Set set = charRank.entrySet();
          // Get an iterator
          Iterator i = set.iterator();
          // Display elements
          while(i.hasNext()) {
             Map.Entry me = (Map.Entry)i.next();
             System.out.print(me.getKey() + ": ");
             System.out.println(me.getValue());
          }
          System.out.println();
        */

	    rank=0;
	    int n = a.length();
	    for(int i=0;i<a.length();i++) {
	    //	 charRank.get(a.charAt(i));
	    	int ipRank = (int)charRank.get(a.charAt(i));
	    	///System.out.println(ipRank);
	    	int smallerUniquePresent=0;
	    	/*for(int j=0;j<i;j++) {
	    		if((int)charRank.get(a.charAt(j)) < ipRank) {
	    			smallerPresent++;
	    		}
	    	}*/
            Iterator i = set.iterator();
            while(i.hasNext()) {
                Map.Entry me = (Map.Entry)i.next();
                if((int)me.getKey().get(0)<ipRank) {
                    smallerUniquePresent++;
                }
            }

	    //	System.out.println((ipRank-1-smallerPresent)+" "+factorial(n-i-1));
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
		findRank("aabcad");
        //System.out.println(findRank("aaa"));
	}
}
