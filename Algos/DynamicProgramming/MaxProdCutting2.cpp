//http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/

#include<stdio.h>
#include<iostream>
using namespace std;

int getOptimal(int n);
int optimal[1000]; //store ans for i-1th index
void initOptimal(int n);
int getMax(int x,int y);

int main()
{
	int n;

	while(cin>>n)
	{
		initOptimal(n);
		cout<<"Max. Prod. for n = "<<n<<" : "<<getOptimal(n)<<endl;
	}
}

void initOptimal(int n)
{
	for(int i=0;i<n;i++)
	{
		optimal[i]=-1;
	}
}

int getMax(int x,int y)
{
	return (x>y) ? x : y;
}

int getOptimal(int n)
{
	if(n==1)
	{
		return 1;
	}
	else if(optimal[n-1]>0)
	{
		return optimal[n-1];
	}
	else
	{
		int max = -1;
		for(int k=1;k<n;k++)
		{
			int temp = 1;
			temp=temp*k*getMax((n-k),getOptimal(n-k));
			max = getMax(temp,max);
		}
		optimal[n-1]=max;
		return max;
	}
}
