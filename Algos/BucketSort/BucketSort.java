//Bucket Sort,Cormen,Pg 200

class BucketSort
{
	public static void main(String[] args) 
	{
		int nBucket = 10; //10 buckets
		int nMax = 10; //max number of numbers in each bucket
		double B[][]=new double[nBucket][nMax];
		double A[]={0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
		int n = A.length;
		//Display Initial Array
		System.out.print("Initial Array : ");
		displayArray(A);
		//Create empty list, put -1 at start
		for(int i=0;i<nBucket;i++)
		{
			for(int j=0;j<nMax;j++)
			{
				B[i][j]=-1;
			}
		}
		//Now insert elements into buckets
		for(int i=0;i<n;i++)
		{
			double num = A[i];
			int bNumber = (int)Math.floor(A[i]*10);
			insert(B,bNumber,num);
		}
		//display buckets
		System.out.println("Buckets after insertion.");
		displayBuckets(B,nBucket,nMax);
		//now Perform Insertion sort for each bucket but only till index so that value !=-1
		for(int i=0;i<nBucket;i++)
		{
			insertionSort(B,i);
		}
		//display buckets after Sorting
		System.out.println("Buckets after sorting.");
		displayBuckets(B,nBucket,nMax);	
		//now Merge Sorted Buckets	
		double sorted[] = new double[A.length];
		Merge(B,sorted,nBucket);
		//Display sorted array
		System.out.print("Sorted Array : ");
		displayArray(sorted);
	}

	public static void insert(double B[][],int bNumber,double num)
	{
		int pos=0;
		for(int i=0;;i=i+1)
		{
			if(B[bNumber][i]==-1)
			{
				break;
			}
			else
			{
				pos++;
			}
		}
		B[bNumber][pos]=num;
	}

	public static void displayBuckets(double B[][],int nBucket,int nMax)
	{
		for(int i=0;i<nBucket;i++)
		{
			System.out.print(i+" : ");
			for(int j=0;j<nMax;j++)
			{
				if(B[i][j]==-1)
				{
					System.out.print("/");
					break;
				}
				System.out.print(B[i][j]+"-->");
			}
			System.out.println();
		}
	}

	public static void insertionSort(double B[][],int bNumber)
	{
		for(int j=1;;j++)
		{
			double key = B[bNumber][j];
			if(key==-1.0)
			{
				break;
			}
			int i = j-1;
			while(i>=0 && B[bNumber][i]>key)
			{
				B[bNumber][i+1]=B[bNumber][i];
				i=i-1;
			}
			B[bNumber][i+1]=key;
		}
	}

	public static void Merge(double B[][],double sorted[],int nBucket)
	{
		int k=0;
		for(int i=0;i<nBucket;i++)
		{
			for(int j=0;B[i][j]!=-1.0;j++)
			{
				sorted[k]=B[i][j];
				k++;
			}
		}
	}

	public static void displayArray(double A[])
	{
		for(double i:A)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
}

/* Output 

Initial Array : 0.78 0.17 0.39 0.26 0.72 0.94 0.21 0.12 0.23 0.68 
Buckets after insertion.
0 : /
1 : 0.17-->0.12-->/
2 : 0.26-->0.21-->0.23-->/
3 : 0.39-->/
4 : /
5 : /
6 : 0.68-->/
7 : 0.78-->0.72-->/
8 : /
9 : 0.94-->/
Buckets after sorting.
0 : /
1 : 0.12-->0.17-->/
2 : 0.21-->0.23-->0.26-->/
3 : 0.39-->/
4 : /
5 : /
6 : 0.68-->/
7 : 0.72-->0.78-->/
8 : /
9 : 0.94-->/
Sorted Array : 0.12 0.17 0.21 0.23 0.26 0.39 0.68 0.72 0.78 0.94 

*/