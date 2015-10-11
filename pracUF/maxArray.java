class maxSub
{
    int low,high,sum;

    maxSub(int x,int y,int z)
    {
        low=x;
        high=y;
        sum=z;
    }
}

class maxArray
{
    public static void main(String args[]) 
    {
        int x[]={1,2,5,-7,2,3};
        maxSub ans = findMax(x,0,x.length-1);
        for(int i=ans.low;i<=ans.high;i++)
        {
            System.out.print(x[i]+" ");
        }
        System.out.println("\n Sum : "+ans.sum);
    }

    public static maxSub findMax(int x[],int low,int high)
    {
        if(low==high) 
        {
            maxSub tmp = new maxSub(low,high,x[low]);
            return tmp;
        }
        else 
        {
            int mid = low + (high-low)/2;
            maxSub leftMax = findMax(x,low,mid);
            maxSub rightMax = findMax(x,mid+1,high);
            maxSub crossingMax = crossingMax(x,low,mid,high);
            
        return retMax(leftMax,rightMax,crossingMax);
        }
    }

    public static maxSub crossingMax(int x[],int low,int mid,int high)
    {
        int leftMax = 0,currentSum=0,rightMax=0,lowIndex=mid,highIndex=mid;
        for(int i=mid-1;i>=low;i--)
        {
            currentSum=currentSum+x[i];
            if(currentSum > leftMax)
            {
                leftMax = currentSum;
                lowIndex=i;
            }
        }
        currentSum = 0; 
        for(int i=mid+1;i<=high;i++)
        {
            currentSum=currentSum+x[i];
            if(currentSum > rightMax)
            {
                rightMax = currentSum;
                highIndex = i;
            }
        }
        maxSub tmp = new maxSub(lowIndex,highIndex,leftMax+rightMax+x[mid]);
        return tmp;
    }

    public static maxSub retMax(maxSub x,maxSub y,maxSub z)
    {
        if(x.sum>=y.sum && x.sum>=z.sum)
        {
            return x;
        }
        else if(y.sum>=x.sum && y.sum>=z.sum)
        {
            return y;
        }
        else 
        {
            return z;
        }

    }
}
