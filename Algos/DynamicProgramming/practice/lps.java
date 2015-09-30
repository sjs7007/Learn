//http://www.spoj.com/problems/LPS/

class lps
{
    public static void main(String args[])
    {
        String input = "abca";
        int n=input.length();
        System.out.println(DP(0,n-1,input));
    }

    public static int DP(int i,int j,String input)
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            return 1;
        }
        else if(input.charAt(i)==input.charAt(j))
        {
            return(2+DP(i+1,j-1,input));
        }
        else
        {
            return(max(DP(i+1,j,input),DP(i,j-1,input)));
        }

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
