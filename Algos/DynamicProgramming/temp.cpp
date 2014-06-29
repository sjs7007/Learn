//http://www.spoj.com/problems/MINUS/

#include<iostream>
using namespace std;

int DP[100][100];

int main()
{
	memset(DP,-1,sizeof(DP)); //SET all values of DP to -1

	int required = 4, n=5;
	int data[] = {12,10,4,3,5};

	cout<<isPos(0,n-1,data,required);
}


