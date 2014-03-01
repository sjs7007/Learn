// Selection Sort
class SelectionSort
{
	public static void main(String args[])
	{
		int num[]={4,5,1,3,2,6};
		int pos=-1;
		for(int i=0;i<num.length;i++)
		{
			int min=num[pos+1];
			int temp=pos+1;
			//loop find min. number and position 
			for(int j=pos+2;j<num.length;j++)
			{
				if(num[j]<min)
				{
					min=num[j];
					temp=j;
				}
			}
			//now swap pos+1 with min
			pos++;
			num[temp]=num[pos];
			num[pos]=min;

			//Display After ith iteration
			System.out.print("After iteration "+(i+1)+" : ");
			for(int j=0;j<num.length;j++)
			{
				System.out.print(num[j]+" ");
			}
			System.out.println();
		}
	}
}

/*

Links : http://en.wikipedia.org/wiki/Selection_sort

Output : 

After iteration 1 : 1 5 4 3 2 6 
After iteration 2 : 1 2 4 3 5 6 
After iteration 3 : 1 2 3 4 5 6 
After iteration 4 : 1 2 3 4 5 6 
After iteration 5 : 1 2 3 4 5 6 
After iteration 6 : 1 2 3 4 5 6 

*/
