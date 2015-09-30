//http://www.spoj.com/problems/LPS/


class lps
{
    boolean table[][];
    
    public static void main(String args[])
    {
        String input = "ge"; 
        int n=input.length();
        table=new int[n][n];
        System.out.println(DP(0,n-1,input));
        int max=1;

        //base case 1 : 1char
        for(int i=0;i<n;i++)
        {
            table[i][i]=true;
        }
        //base case 2 : 2char
        for(int i=0;i<=n-2;i++)
        {
            if(input.charAt(i)==input.charAt(i+1))
            {
                table[i][i+1]=true;
                max=2;
            }
        }
        //general 
        for(int i=0;i<n;i++)
        {

        }

    }

    public static int DP(int i,int j,String input)
    {
        if(i==j)
        {
         //   table[i][j]=true;
            return 1;
        }
        if(input.charAt(i)==input.charAt(j) && i+1==j)
        {
           // table[i][j]=true;
            return 2;
        }
        else if(input.charAt(i)==input.charAt(j) && DP(i+1,j-1,input)>0)
        {
           // table[i][j]=true;
            return(2+DP(i+1,j-1,input));
        }
        else
        {
            return 0;
        }
        /*else
        {
            return(max(DP(i+1,j,input),DP(i,j-1,input)));
        }*/

    }

    public static int max(int x,int y)
    {
        if(x>=y)
        {
            return x;
        }
        else
        {
            return y;
        }
    }
}
