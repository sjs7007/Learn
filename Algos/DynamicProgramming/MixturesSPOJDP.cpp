//http://www.spoj.com/problems/MIXTURES/

//not yet done as of now

#include <iostream>
#include <stdio.h>
using namespace std;

int getOptimal(int start,int n, int potions[]);

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
	else
	{
		int tempLeft = potionsLeft[i]*potionsLeft[i-1];
		potionsLeft[i] = (potionsLeft[i]+potionsLeft[i-1]) % 100;
		tempLeft = tempLeft + getOptimal(i+1,n,potionsLeft);

		int tempRight = potionsRight[i]*potionsRight[i+1];
	    potionsRight[i+1] = (potionsRight[i]+potionsRight[i+1]) % 100;
	    potionsRight[i]=potionsRight[i-1];
	    tempRight = tempRight + getOptimal(i+1,n,potionsRight);

	    if(tempLeft<tempRight)
	    {
	    	return tempLeft;
	    }
	    else
	    {
	    	return tempRight;
	    }
	}
}

