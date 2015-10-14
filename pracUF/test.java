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
		//findPrimeFactors(8);
		//System.out.println(isPower(1024000000));
		System.out.println(findPrimeFactors(1024000000));
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
       // System.out.println(ret);
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

    public static boolean isPower(int a) {
        if(a==0 || a==1) {
            return false;
        }
        ArrayList<Integer> temp = findPrimeFactors(a);
        
        if(temp.size()==1) {
            return false; //prime number 
        }
        
        int count=1,start=-1;
        int comp =temp.get(0);
        for(int i=1;i<temp.size();i++) {
            start=i;
            if(temp.get(i)==comp) {
            	start=i+1;
                count++;
            } else
            {
                System.out.println("here1 : "+temp.get(i)+" com : "+count);
                break;
            }
        }
       // System.out.println(comp+" "+start);
        if(start==-1) {
            return false;
        }
        System.out.println(start+" "+temp.size());
        for(int i=start;i<temp.size();i++) {
            int tempC=1,compare=temp.get(i);
                            System.out.println("here2 : "+temp.get(i));

            i++;
            while( i<temp.size() && temp.get(i)==compare ) {
                tempC++;
                                                System.out.println("here3 : "+temp.get(i));

                i++;

            }
            if(tempC!=count) {
            	              //  System.out.println("here4 : "+temp.get(i));

                return false;
            }
            if(i!=temp.size())
                i--;
        }
        return true;
        
       
    }
    


}