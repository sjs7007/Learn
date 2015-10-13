class test
{
	public static void main(String args[])
	{
		int x[][]={{1,2,3},{4,5,6},{7,8,9}};
		int n=3;
		for(int c=0;c<n;c++)
		{
			for(int r=0;r<=c;r++)
			{
				System.out.print(x[r][c-r]+" ");
			}
			System.out.println();
		}
		int k=n;
		for(int c=n-1;c>=k-n;c--)
		{
			for(int r=k-n+1;r<=n-1;r++)
			{
				//System.out.print(r+" "+(k-r));
				System.out.print(x[r][c]+" ");
			}
			k++;
			System.out.println();
		}
	}
}