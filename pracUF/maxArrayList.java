//correct for edge caases
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


public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> x) {
        
        maxSub ans = findMax(x,0,x.size()-1);
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i=ans.low;i<=ans.high;i++)
        {
           // System.out.print(x[i]+" ");
            ret.add(x.get(i));
        }
        //System.out.println("\n Sum : "+ans.sum);
        return ret;
    }


    public static maxSub findMax(ArrayList<Integer> x,int low,int high)
    {
        if(low==high) 
        {
            if(x.get(low)>=0)
            {
                maxSub tmp = new maxSub(low,high,x.get(low));
                return tmp;
            }
            else 
            {
                return(new maxSub(0,0,-1));
            }
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

    public static maxSub crossingMax(ArrayList<Integer> x,int low,int mid,int high)
    {
        int leftMax = 0,currentSum=0,rightMax=0,lowIndex=mid,highIndex=mid;
        for(int i=mid-1;i>=low;i--)
        {
            currentSum=currentSum+x.get(i);
            if(currentSum > leftMax)
            {
                leftMax = currentSum;
                lowIndex=i;
            }
        }
        currentSum = 0; 
        for(int i=mid+1;i<=high;i++)
        {
            currentSum=currentSum+x.get(i);
            if(currentSum > rightMax)
            {
                rightMax = currentSum;
                highIndex = i;
            }
        }
        maxSub tmp = new maxSub(lowIndex,highIndex,leftMax+rightMax+x.get(mid));
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
