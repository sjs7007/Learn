class matrixDP
{
    static int minCost[][];
    static int splitTable[][];
 //   static int p[]={30,35,15,5,10,20,25};
    static int p[]={5,10,3,12,5,50,6};

    public static void main(String Args[])
    {
        minCost = new int[p.length-1][p.length-1];
        splitTable = new int[p.length-1][p.length-1];

        for(int i=0;i<minCost.length;i++)
        {
            for(int j=0;j<minCost.length;j++)
            {
                if(i!=j)
                {
                    minCost[i][j]=-1;
                }
            }
        }
        for(int i=1;i<=p.length-1;i++)
        {
            for(int j=1;j<=p.length-1;j++)
            {
                findLowest(i,j);
            }
        }

        for(int i=0;i<p.length-1;i++)
        {
            for(int j=0;j<p.length-1;j++)
            {
                System.out.print(minCost[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=0;i<p.length-1;i++)
        {
            for(int j=0;j<p.length-1;j++)
            {
                System.out.print(splitTable[i][j]+" ");
            }
            System.out.println();
        }



    }

    public static int findLowest(int i,int j)
    {
        if(minCost[i-1][j-1]>=0)
        {
            System.out.println("Memoized call. Yay.");
            return minCost[i-1][j-1];
        }
        else 
        {
            int temp=999999;
            for(int k=i;k<j;k++)
            {
                int temp2 = findLowest(i,k)+findLowest(k+1,j)+p[i-1]*p[k]*p[j];
               // System.out.println(p[i-1]+" "+p[k]+" "+p[j]+" "+temp2);
                if(temp>temp2)
                {
                    temp=temp2;
                    splitTable[i-1][j-1]=k;
                }
            }
            minCost[i-1][j-1]=temp;
            return temp;
        }
    }

    
}
