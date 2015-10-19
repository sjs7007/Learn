class BinarySearch
{
    public static void main(String args[])
    {
        int x[]={1,4,40,80,87,90,96,100,101,102};
        binarySearch(x,0,x.length-1,40);
        binarySearch(x,0,x.length-1,42);
    }

    public static void binarySearch(int x[],int low,int high,int key)
    {
        if(low<high)
        {
            int mid = low + (high-low)/2;
            if(x[mid]==key)
            {
                System.out.println("Key "+key+" found at : "+mid);
            }
            else if(key>x[mid])
            {
                binarySearch(x,mid+1,high,key);
            }
            else
            {
                binarySearch(x,low,mid-1,key);
            }
        }
        else
        {
            System.out.println("Key "+key+" not present.");
        }
    }
}
