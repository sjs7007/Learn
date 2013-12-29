//Pascal Triangle 

class Pascal
{
	public static void main(String[] args) 
	{
		int n=10;
		int a[][]=new int[n+1][n+1];
		a[1][1]=1;
		a[1][2]=0;
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				a[i][j]=a[i-1][j]+a[i-1][j-1];
			}
		}	
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}

/*
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
1 6 15 20 15 6 1 
1 7 21 35 35 21 7 1 
1 8 28 56 70 56 28 8 1 
1 9 36 84 126 126 84 36 9 1 
*/