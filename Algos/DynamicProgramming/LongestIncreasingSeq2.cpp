//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/

//Working - displays sequences too.

#include <stdio.h>
#include <iostream>
using namespace std;

int maxForN[100]; //store length of lis which includes a[i]
int getMaxLength(int n,int data[]);

int main()
{
	int n;
	while(cin>>n)
	{
		int data[n];
		cout<<"Enter "<<n<<" numbers : ";
		for(int i=0;i<n;i++)
		{
			scanf("%d",&data[i]);
		}
		getMaxLength(n,data);
		cout<<endl;
	}
}

int getMaxLength(int n,int data[])
{
	for(int i=0;i<n;i++)
	{
		maxForN[i]=1;
	}

	for(int i=1;i<n;i++)
	{
		int temp[100];
		for(int j=0;j<i;j++)
		{
			if(data[i]>data[j] && maxForN[i]<maxForN[j]+1)
			{
				temp[maxForN[i]-1]=data[j];	
				maxForN[i]=maxForN[j]+1;	
			}
		}
		temp[maxForN[i]-1]=data[i];

		cout<<"Longest increasing sequence including a["<<i<<"] has length " << maxForN[i] <<" and is : ";

		for(int j=0;j<maxForN[i];j++)
		{
			cout<<temp[j]<<" ";
		}
		cout<<endl;
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
