//http://www.spoj.com/problems/MIXTURES/

//not yet done as of now

#include <iostream>
#include <stdio.h>
using namespace std;

int getOptimal(int i,int j, int potions[]);
int answers[100][100];

//int potions[100];

int main()
{
	int n;
	scanf("%d",&n);

	int potions[n];

	for(int i=0;i<n;i++)
	{
		scanf("%d",&potions[i]);
	}

	for(int i=0;i<100;i++)
	{
		for(int j=0;j<100;j++)
		{
			answers[i][j]=-1;
		}
	}

	getOptimal(0,n-1,potions);

}

int getOptimal(int i,int j,int potions[])
{
	if(i==j)
	{
		return 0;
	}
	else if(answers[i][j]>0)
	{
		cout<<"Free Call!"<<endl;
		return answers[i][j];
	}
	else 
	{
		int min=-1;
		for(int k=i;k<j;k++)
		{
			int temp = getOptimal(i,k,potions)+getOptimal(k+1,j,potions);
			int left=0,right=0;
			for(int l=i;l<=k;l++)
			{
				left = left + potions[l];
			}
			for(int l=k+1;l<=j;l++)
			{
				right = right + potions[l];
			}
			left = left % 100;
			right = right % 100;
			cout<<left<<" "<<right<<endl;
			temp = temp + left * right;
			if(min==-1 || temp<min)
			{
				min=temp;
			}
		}
		//cout<<"returning : "<<min<<endl;
		answers[i][j]=min;
		return min;
	}
}

