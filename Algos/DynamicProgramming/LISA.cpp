//http://www.spoj.com/problems/LISA/
// 18:48 - 19:26 max done,memoize it

#include<iostream>
using namespace std;
#include<string.h> //forstrcpy

int getOptimalMax(char inputArray[],int i,int j);

int main()
{
	string input;
	cin >>input;
	char inputArray[input.length()+1];
	strcpy(inputArray,input.c_str());
	cout<<getOptimalMax(inputArray,0,input.length()-1);
}

int getOptimalMax(char inputArray[],int i,int j)
{
	if(i==j)
	{
		int temp = inputArray[i]-'0';
		return temp;
	}
	else
	{
		int max = -1;
		int min = -1;

		for(int k=i+1;k<=j-1;k=k+2)
		{	
			
		//	cout<<"Calling "<<i<<" "<<(k-1)<<" and "<<(k+1)<<" "<<j<<endl;
			int temp1 = getOptimalMax(inputArray,i,k-1);
			int temp2 = getOptimalMax(inputArray,k+1,j);
			int temp3=-1;
			
		//	int temp1=2,temp2=4,temp3;
			if(inputArray[k]=='+')
			{
				temp3 = temp1+temp2;
			}
			else if(inputArray[k]=='*')
			{
				temp3 = temp1*temp2;
			}

			if(temp3>max)
			{
				max=temp3;
			}
			//cout<<"test";
		}
		return max;
	}
}
