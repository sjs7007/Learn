import java.util.*;

class test
{
	public static void main(String args[])
	{
		/*int x[][]={{1,2,3},{4,5,6},{7,8,9}};
		int n=3;
		for(int c=0;c<n;c++)
		{
			for(int r=0;r<=c;r++)
			{
				System.out.print(x[r][c-r]+" ");
			}
			System.out.println();
		}
		int k=n;
		for(int c=n-1;c>=k-n;c--)
		{
			for(int r=k-n+1;r<=n-1;r++)
			{
				//System.out.print(r+" "+(k-r));
				System.out.print(x[r][c]+" ");
			}
			k++;
			System.out.println();
		}*/
		findPrimeFactorsArray(10);
	}

	   public static ArrayList<Integer> findPrimeFactors(int a) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int temp=a;
        while(temp%2==0) {
            ret.add(2);
            temp=temp/2;
        }
        for(int i=3;i<=Math.sqrt(temp);i=i+2) {
            while(temp%i==0) {
                ret.add(i);
                temp=temp/i;
            }
        }
        if(temp>2) {
            ret.add(temp);
        }
        System.out.println(ret);
        return ret;
    }

     public static int[] findPrimeFactorsArray(int a) {
        int ret[] = new int[a+1];
        int temp=a;
        while(temp%2==0) {
            //ret.add(2);
            ret[2]=ret[2]+1;
            temp=temp/2;
        }
        for(int i=3;i<=Math.sqrt(temp);i=i+2) {
            while(temp%i==0) {
               // ret.add(i);
                ret[i]=ret[i]+1;
                temp=temp/i;
            }
        }
        if(temp>2) {
            //ret.add(temp);
            ret[temp]=ret[temp]+1;
        }
       // System.out.println(ret);
        for(int i=0;i<ret.length;i++) {
        	if(ret[i]!=0)
        		System.out.println(i+"^"+ret[i]);
        }
        return ret;
    }
}