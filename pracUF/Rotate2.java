//correct but TLE

public class Solution {
		public void rotate(ArrayList<ArrayList<Integer>> a) {
	    int n = a.get(0).size();
	    /*while(n>1) {
	        n--;
	        a = rotateOnce(a,i);
	    }*/
	    for(int i=1;i<=n/2;i++) //no of layers
	    {
	    	//no of rotation for ith layer n-1,n-3,n-5
	    	for(int j=n-(2*i)+1;j>0;j--)
	    	{
	    		a = rotateOnce(a,i-1);
	    	}
	    }
	    //return a;
	}


	public ArrayList<ArrayList<Integer>>  rotateOnce(ArrayList<ArrayList<Integer>> x,int i) {
	   int r=i,c=i,n=x.get(0).size(),temp;
	   //go right
	   //if(r==0)
	   int rightMax = n-1-i,bottomMax=n-1-i,topMin=i,leftMin=i;
	  // int i=0;
	   //while(leftMin<rightMax) {
	        temp = x.get(i).get(i);
	       // i++;
		   	  while(c<rightMax) {
		     //  temp=x.get(r).get(c);
		       c++;
		       //swap x[r][c] and temp
		       int sTemp=x.get(r).get(c);
		       x.get(r).set(c,temp);
		       temp=sTemp;
		   }
		   //go below
		   //c=n-1 here
		   while(r<bottomMax) {
		    //   temp=x.get(r).get(c);
		       r++;
		       //swap x[r][c] and temp
		       int sTemp=x.get(r).get(c);
		       x.get(r).set(c,temp);
		       temp=sTemp;
		       
		   }
		   //r=n-1 here
		   //go left
		   while(c>leftMin) {
		      // temp=x.get(r).get(c);
		       c--;
		       //swap x[r][c] and temp
		       int sTemp=x.get(r).get(c);
		       x.get(r).set(c,temp);
		       temp=sTemp;
		   }
		   //c=0 here
		   //go up
		   while(r>=topMin+1) {
		     //  temp=x.get(r).get(c);
		       r--;
		       //swap x[r][c] and temp
		       int sTemp=x.get(r).get(c);
		       x.get(r).set(c,temp);
		       temp=sTemp;
	 	  }
	 	  //r = topMin-1
	 //	  r=i;
	 //	  c=i;
	 //	  rightMax--;
	 	//  topMax++;
	 	//  bottomMax--;
	 	//  topMin++;
	 	//  leftMin++;
	   //}
	   return x;
	}
	
}
