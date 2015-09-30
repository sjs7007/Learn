//http://www.spoj.com/problems/ACODE/

import java.util.*;

class acode
{
    static long DP[]=new long[6000];

    public static void main(String args[])
    {
        //int a[]={2,5,1,1,4};
        //int a[]={1,1,1,1,1,1,1,1,1,1};
        //int a[]={3,3,3,3,3,3,3,3,3,3};
        
        Scanner ip = new Scanner(System.in);

                
        while(true)
        {
            
            for(int i=0;i<DP.length;i++)
            DP[i]=-1;

            
            String input = ip.next();
            if(input.equals("0"))
                break;
            int a[]=new int[input.length()];
            for(int i=0;i<a.length;i++)
            a[i]=Character.getNumericValue(input.charAt(i));
            int n = a.length;
            System.out.println(DP(a,0));
        }
    }

    public static long DP(int x[],int start)
    {
        //int mul=1;
        if(DP[start]>0)
            return DP[start];
        if(x.length==0)
            return 1;
        long count=0;

        if(x.length>=1 && x[0]>=1)
        {
            int y[]=new int[x.length-1];
            for(int i=1;i<x.length;i++)
                y[i-1]=x[i];
            count = count + DP(y,start+1);
        }
        if(x.length>=2 && ((x[0]==1 && x[1]<=9) || (x[0]==2 && x[1]<=6)))
        {
            int z[]=new int[x.length-2];
            for(int i=2;i<x.length;i++)
                z[i-2]=x[i];
            count = count + DP(z,start+2);
        }
       // if(count==0)
         //   count=1;
        DP[start]=count;
        return count;
    }
}
