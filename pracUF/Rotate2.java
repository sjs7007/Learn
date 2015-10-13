public class Rotate2 {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    int n = a.get(0).size();
	    while(n>1) {
	        n--;
	        a = rotateOnce(a);
	    }
	    //return a;
	}

	public static void main(String )
	
	public ArrayList<ArrayList<Integer>>  rotateOnce(ArrayList<ArrayList<Integer>> x) {
	   int r=0,c=0,n=x.get(0).size(),temp;
	   //go right
	   //if(r==0)
	   int rightMax = n-1,bottomMax=n-1,topMin=0,leftMin=0;
	   int i=0;
	   while(leftMin<rightMax) {
	        temp = x.get(i).get(i);
	        i++;
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
	 	  r=i;
	 	  c=i;
	 	  rightMax--;
	 	//  topMax++;
	 	  bottomMax--;
	 	  topMin++;
	 	  leftMin++;
	   }
	   return x;
	}
	
	
}
