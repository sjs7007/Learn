//http://www.spoj.com/problems/MIXTURES/

#include <iostream>
#include <stdio.h>
using namespace std;

int getOptimal(int potions[]);

int potions[100];

int main()
{
	int n;
	scanf("%d",&n);

//	int potions[n];

	for(int i=0;i<n;i++)
	{
		scanf("%d",&potions[i]);
	}

	getOptimal(potions);

	for(int i=0;i<100;i++)
	{
		cout<<potions[i];
	}
}

int getOptimal(int potions[])
{
	for(int i=0;i<100;i++)
	{
		potions[i]=20;
	}
}