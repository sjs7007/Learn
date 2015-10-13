public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    int n = a.get(0).size();
	    while(n>1) {
	        n--;
	        a = rotateOnce(a);
	    }
	    //return a;
	}
	
	public ArrayList<ArrayList<Integer>>  rotateOnce(ArrayList<ArrayList<Integer>> x) {
	   int r=0,c=0,n=x.get(0).size(),temp=x.get(0).get(0);
	   //go right
	   //if(r==0)
	   while(c<n-1) {
	     //  temp=x.get(r).get(c);
	       c++;
	       //swap x[r][c] and temp
	       int sTemp=x.get(r).get(c);
	       x.get(r).set(c,temp);
	       temp=sTemp;
	   }
	   //go below
	   //c=n-1 here
	   while(r<n-1) {
	    //   temp=x.get(r).get(c);
	       r++;
	       //swap x[r][c] and temp
	       int sTemp=x.get(r).get(c);
	       x.get(r).set(c,temp);
	       temp=sTemp;
	       
	   }
	   //r=n-1 here
	   //go left
	   while(c>0) {
	      // temp=x.get(r).get(c);
	       c--;
	       //swap x[r][c] and temp
	       int sTemp=x.get(r).get(c);
	       x.get(r).set(c,temp);
	       temp=sTemp;
	   }
	   //c=0 here
	   //go up
	   while(r>=1) {
	     //  temp=x.get(r).get(c);
	       r--;
	       //swap x[r][c] and temp
	       int sTemp=x.get(r).get(c);
	       x.get(r).set(c,temp);
	       temp=sTemp;
	   }
	   return x;
	}
	
	
}
