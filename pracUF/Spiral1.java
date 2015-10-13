import java.util.*;

public class Solution {
	// DO NOT MODIFY THE LIST
	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 // Populate result;
		 int bottomMax = a.size();
		 int rightMax = a.get(0).size();
		 int leftMin = 0;
		 int topMin = 1;
		 int n = bottomMax * rightMax;
		 int r=0,c=-1;
		 int count=0;
		 while(count<n) {
		     while(count<n)
		     {
		           if(c>=rightMax-1)
		            break;
		         else
		            c++;
		         count++;
		         result.add(a.get(r).get(c));
		       
		     }
		   // System.out.println(result);
	         rightMax--;
		     while(count<n)
		     {
		         if(r>=bottomMax-1)
		            break;
		         else
		            r++;
		         count++;
		         result.add(a.get(r).get(c));

		     }
		     		//   System.out.println(result);

		     bottomMax--;
		     while(count<n)
		     {
		         if(c<=leftMin)
		            break;
		         else
		            c--;
		         count++;
		         //System.out.println("c : "+count);
		         result.add(a.get(r).get(c));
		     }
		     leftMin++;
		     
		     		//  System.out.println(result);
		     		 // System.out.println(r+" "+topMin);

		     while(count<n)
		     {
		         if(r<=topMin)
		            break;
		         else
		             r--;

		         count++;

		         result.add(a.get(r).get(c));
		        
		     }
		     		    // System.out.println(result);

		      topMin++;
		 }
		 return result;
	}

	public static void main(String args[])
	{
		ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
		
		x.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		x.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		x.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));
		
		System.out.println(x);
		spiralOrder(x);
	}
}
