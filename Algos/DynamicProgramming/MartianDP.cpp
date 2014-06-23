//SPOJ Problem : http://www.spoj.com/problems/MARTIAN/ Dynamic Programming

#include <iostream>
#include <stdio.h>
using namespace std;

int getOptimal(int b[][1000],int y[][1000],int row,int column);
int max(int x,int y);

int answer[1000][1000];

int main()
{
	int n=-1,m=-1;

	scanf("%d %d",&n,&m);

	int y[1000][1000],b[1000][1000];

	
	while(n!=0 && m!=0)
	{
		//int y[n][m],b[n][m];

		for(int i=0;i<1000;i++)
		{
			for(int j=0;j<1000;j++)
			{
				answer[i][j]=-1;
			}
		}


		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				scanf("%d",&y[i][j]);
			}
		}

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				scanf("%d",&b[i][j]);
			}
		}

		int ans = getOptimal(b,y,n,m);
		cout<<ans<<endl;
		scanf("%d %d",&n,&m);
	}
}

int getOptimal(int b[][1000],int y[][1000],int row,int column)
{
	if(row==0 || column==0)
	{
		return 0;
	}
	else if(answer[row-1][column-1]>0)
	{
		//cout<<"free call!";
		return answer[row-1][column-1];
	}
	else 
	{
		int ySum=0,bSum=0;
		for(int i=row-1;i>=0;i--)
		{
			bSum = bSum + b[i][column-1];
		}
		
		for(int i=column-1;i>=0;i--)
		{
			ySum = ySum + y[row-1][i];
		}

		int temp = max(ySum+getOptimal(b,y,row-1,column),bSum+getOptimal(b,y,row,column-1));

		answer[row-1][column-1]=temp;

		return temp;
	}
}

int max(int x,int y)
{
	if(x>y)
	{
		return x;
	}
	else
	{
		return y;
	}
}