//http://www.spoj.com/problems/MIXTURES/

#include <iostream>
#include <stdio.h>
using namespace std;

int getOptimal(int start,int n, int potions[]);
int max(int x,int y);

//int potions[100];
int answers[100]; //store answer for index i+1

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
		answers[i]=-1;
	}

	cout<<getOptimal(1,n,potions)<<endl;

}

int getOptimal(int i,int n,int potions[])
{
	int potionsLeft[n],potionsRight[n];

	for(int j=0;j<n;j++)
	{
		potionsLeft[j]=potions[j];
		potionsRight[j]=potions[j];
	}

	if(i==n-1)
	{
		return potions[i]*potions[i-1];
	}
	else if(answers[i]>0)
	{
		cout<<"free call!"<<endl;
		return answers[i];
	}
	else
	{
		int tempLeft = potionsLeft[i]*potionsLeft[i-1];
		potionsLeft[i] = tempLeft % 100;
		tempLeft = tempLeft + getOptimal(i+1,n,potionsLeft);

		int tempRight = potionsRight[i]*potionsRight[i+1];
	    potionsRight[i+1] = tempRight % 100;
	    potionsRight[i]=potionsRight[i-1];
	    tempRight = tempRight + getOptimal(i+1,n,potionsRight);

	    if(tempLeft>tempRight)
	    {
	    	answers[i]=tempLeft;
	    	return tempLeft;
	    }
	    else
	    {
	    	answers[i]=tempRight;
	    	return tempRight;
	    }
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