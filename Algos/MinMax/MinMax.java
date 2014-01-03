//Find Min and Max simultaneously using 3n/2 comparisions at mix instead of 2n-2,Cormen,pg214


class MinMax
{
	public static void main(String[] args) 
	{
		int A[]={32,421,321,12,46,3223,23,56,324,2};
		int n = A.length;
		int start=0,min=0,max=0;
		if(n%2==1)
		{
			start=1;
			min=A[0];
			max=A[0];
		}
		else
		{
			start=2;
			if(A[0]<=A[1])
			{
				min=A[0];
				max=A[1];
			}
			else
			{
				min=A[1];
				max=A[0];
			}
		}
		for(int i=start;i<n;i=i+2)
		{
			int x = A[i];
			int y = A[i+1];
			System.out.println(x+" "+y);
			if(x<y)
			{
				if(x<min)
				{
					min=x;
				}
				if(y>max)
				{
					max=y;
				}
			}
			else
			{
				if(x>max)
				{
					max=x;
				}
				if(y<min)
				{
					min=y;
				}
			}
		}
		System.out.println("Max : "+max+", Min : "+min);
	}
}


/*
	if n = odd,
	Initial min = Initial max = 1st element,else min=min of 1st two,max=max of 1st two
	
	Consider rest of the elements in pairs, let's say x,y
	if(x<y)
	{
		if(x<min)
		{
			min = x
		}
		if(y>max)
		{
			max = y;
		}
	}
	else
	{
		if(x>max)
		{
			max = x;
		}
		else
		{
			if(y<min)
			{
				min=y
			}
		}
	}


*/

/*
{32,421,321,12,46,3223,23,56,324}
421 321
12 46
3223 23
56 324
Max : 3223, Min : 12


{32,421,321,12,46,3223,23,56,324,2};
321 12
46 3223
23 56
324 2
Max : 3223, Min : 2
*/