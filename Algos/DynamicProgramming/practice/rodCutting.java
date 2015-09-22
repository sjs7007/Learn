class rodCutting
{   
    static int maxProfit[]=new int[100];

    public static void main(String args[])
    {
        for(int i=0;i<maxProfit.length;i++)
        {
            maxProfit[i]=-1;
        }

        int r[]={0,1,5,8,9,10,17,17,20,24,30};
        System.out.println(findMaxProfit(r,10));
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

    public static int findMaxProfit(int r[],int lRod)
    {
        if(lRod==0)
        {
            return 0;
        }
        else if(maxProfit[lRod]>=0)
        {
            System.out.println("Memoized call. Yay.");
            return maxProfit[lRod];
        }
        int temp=-1;
        for(int i=1;i<=lRod;i++) //finding max for rod of length 
        {
            temp = max(temp,r[i]+findMaxProfit(r,lRod-i));
        }
//        System.out.println("Max profit of rod of "+lRod + " is : "+temp);
        maxProfit[lRod]=temp;
        return temp;
    }
}
