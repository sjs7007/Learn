//http://www.spoj.com/problems/LPS/

//actually answer to http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

class lps
{
    public static void main(String args[])
    {
        String input = "ge";
        int n=input.length();
        System.out.println(DP(0,n-1,input));
    }

    public static int DP(int i,int j,String input)
    {
        if(i==j)
        {
            return 1;
        }
        if(input.charAt(i)==input.charAt(j) && i+1==j)
        {
            return 2;
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
