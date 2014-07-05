//http://www.codechef.com/JULY14/problems/CSUB

#include<iostream>
using namespace std;

int main()
{
	int t;
	cin >>t;
	for(int x=0;x<t;x++)
	{
		int t2;
		cin>>t2;

		string input;
		cin >>input;
		int count=0;

		for(int i=0;i<input.length();i++)
		{
			for(int j=i;j<input.length();j++)
			{
				if(input[i]=='1' && input[j]=='1')
				{
					count++;
				}
			}
		}
		cout<<count<<endl;
	
	}
	//cout<<"Count : "<<count<<endl;
	//	cout<<input.substr(0,1);
}
