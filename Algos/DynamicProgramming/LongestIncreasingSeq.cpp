//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/

//Working

#include <stdio.h>
#include <iostream>
using namespace std;

int maxForN[100]; //store length of lis which includes a[i]
int getMaxLength(int n,int data[]);

int main()
{
	int data[]={10,22,9,33,21,50,41,60,80};
	int n = sizeof(data)/sizeof(int);
	cout<<getMaxLength(n,data)<<endl;
}

int getMaxLength(int n,int data[])
{
	for(int i=0;i<n;i++)
	{
		maxForN[i]=1;
	}

	for(int i=1;i<n;i++)
	{
		for(int j=0;j<i;j++)
		{
			if(data[i]>data[j] && maxForN[i]<maxForN[j]+1)
			{
				maxForN[i]=maxForN[j]+1;				
			}
		}
	}

	int max=-1;

	for(int i=0;i<n;i++)
	{
		if(max<maxForN[i])
		{
			max=maxForN[i];
		}
	}

	return max;
}
