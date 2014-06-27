//Minimum Cost Path : http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
//Working

#include <iostream>
using namespace std;
#include <limits.h> //for INT_MAX

int DP[100][100];
int getMCPCost(int cost[3][3],int m,int n);
int min(int x,int y,int z);

int main()
{
	int cost[3][3]={{1,2,3},{4,8,2},{1,5,3}};
	cout<<getMCPCost(cost,2,2)<<endl;
}

void initCosts(int m,int n)
{
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
			DP[i][j]=-1;
		}
	}
}

int getMCPCost(int cost[3][3],int m,int n)
{
	initCosts(m,n);

	if(m==0 && n==0)
	{
		return cost[0][0];
	}
	else if(m<0 || n<0)
	{
		return INT_MAX;
	}
	else if(DP[m][n]>0)
	{
		return DP[m][n];
	}
	else
	{
		int temp = cost[m][n]+min(getMCPCost(cost,m-1,n),getMCPCost(cost,m,n-1),getMCPCost(cost,m-1,n-1));
		DP[m][n]=temp;
		return temp;
	}
}

int min(int x,int y,int z)
{
	if(x<y && x<z)
	{
		return x;
	}
	else if(y<x && y<z)
	{
		return y;
	}
	else
	{
		return z;
	}
}