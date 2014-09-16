//http://www.codechef.com/JULY14/problems/CSUB
// answer only depends on number of 1s in the string
// pattern 1 3 6 10 15 : triangular number 
// for n --> n*(n+1)/2
//ACCEPTED!


#include<iostream>
using namespace std;
#include<stdio.h> //getchar
 
int main()
{
	int t;
	cin >>t;
	for(int x=0;x<t;x++)
	{
		int t2;
		scanf("%d\n",&t2);
		 
		unsigned long long int oneCount=0;
		unsigned long long int answer=0; //answer = n(
 
		for(int i=0;i<t2;i++)
		{
			char c;
			if((c=getchar())=='1')
			{
				oneCount++;
			}
		}
		//cout<<oneCount<<"d s"<<endl;
		answer = oneCount * (oneCount+1) /2 ;
		cout<<answer<<endl;
	}
	//cout<<"Count : "<<count<<endl;
	//	cout<<input.substr(0,1);
}
 
