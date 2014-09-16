//http://www.codechef.com/JULY14/problems/RETPO

#include <iostream>
using namespace std;

#include <string.h>

string turnLeft(string current);
string turnRight(string current);
int getNewX(string direction,int currentX);
int getNewY(string direction,int currentY);
int getOptimal(int i,int j,int endX,int endY,string direction,int currentVisited[100][100]);

int DP[100][100];
int visited[100][100];

int main()
{
	//cout<<turnLeft("x")<<endl;
	//cout<<turnRight("x")<<endl;
	memset(DP,-1,sizeof(DP));
	memset(visited,-1,sizeof(visited));
	visited[0][0]=1;
	cout<<getOptimal(0,0,3,3,"x",visited);
		/*int i=2,j=3;
		string direction="-y";	
		string direction1=turnRight(direction);
		int x1=getNewX(direction1,i);
		int y1=getNewY(direction1,j);	
		cout<<x1<<" "<<y1<<endl;*/
}

string turnRight(string current)
{
	if(current=="x")
	{
		return "y";
	}
	else if(current=="y")
	{
		return "-x";
	}
	else if(current=="-x")
	{
		return "-y";
	}
	else 
	{
		return "x";
	}
}

string turnLeft(string current)
{
	if(current=="x")
	{
		return "-y";
	}
	else if(current=="-y")
	{
		return "-x";
	}
	else if(current=="-x")
	{
		return "y";
	}
	else
	{
		return "x";
	}
}

int getNewX(string direction,int currentX)
{
	if(direction=="x")
	{
		return(currentX+1);
	}
	else if(direction=="-x")
	{
		return(currentX-1);
	}
	else
	{
		return(currentX);
	}
}

int getNewY(string direction,int currentY)
{
	if(direction=="y")
	{
		return(currentY+1);
	}
	else if(direction=="-y")
	{
		return(currentY-1);
	}
	else
	{
		return(currentY);	
	}
}

int getOptimal(int i,int j,int endX,int endY,string direction,int currentVisited[100][100])
{
	//cout<<i<<" "<<j<<" "<<direction<<endl;
	if(i<0 ||j<0)
	{
		return 10000;
	}
	else if(i>endX || j>endY)
	{
		return 1000;
	}	
	else if(i==endX && j==endY)
	{
		return 0;
	}
	else if(DP[i][j]>=0)
	{
		return DP[i][j];
	}
	else
	{
		
		//cout<<"Call for "<<i<<" "<<j<<" starts."<<endl;
		
		string direction1=turnLeft(direction);
		int x1=getNewX(direction1,i);
		int y1=getNewY(direction1,j);

		int currentVisited1[100][100];
		for(int x=0;x<endX;x++)
		{
			for(int y=0;y<endY;y++)
			{
				currentVisited1[x][y]=currentVisited[x][y];
			}
		}
		int temp1=1000;
		if(currentVisited[x1][y1]!=1 && visited[x1][y1]!=1)
		{
			
			cout<<"("<<i<<","<<j<<") "<<direction<<" --> "<<"("<<x1<<","<<y1<<") "<<direction1<<endl;
			currentVisited1[x1][y1]=1;
		//	cout<<"Turn Left"<<endl;
			temp1=1+getOptimal(x1,y1,endX,endY,direction1,currentVisited1);
		}
		else
		{
			cout<<"Can't visit "<<x1<<" "<<y1<<endl;
		}

		cout<<endl;

		string direction2=turnRight(direction);
		int x2=getNewX(direction2,i);
		int y2=getNewY(direction2,j);	
		
		int currentVisited2[100][100];
		for(int x=0;x<endX;x++)
		{
			for(int y=0;y<endY;y++)
			{
				currentVisited2[x][y]=currentVisited[x][y];
			}
		}
		int temp2=1000;
		if(currentVisited[x2][y2]!=1 && visited[x2][y2]!=1)
		{
			
			cout<<"("<<i<<","<<j<<") "<<direction<<" --> "<<"("<<x2<<","<<y2<<") "<<direction2<<endl;
			currentVisited2[x2][y2]=1;
			//cout<<"Turn Right"<<endl;
			temp2=1+getOptimal(x2,y2,endX,endY,direction2,currentVisited2);
		}
		else
		{
			cout<<"Can't visit "<<x2<<" "<<y2<<endl;
		}

			
		//cout<<"Call for "<<i<<" "<<j<<" ends."<<endl;

		if(temp1<temp2)
		{
		//	cout<<"Here "<<i<<" "<<j<<" "<<temp1<<endl;
			DP[i][j]=temp1;
			//cout<<"Set "<<x1<<" "<<y1<<endl;
			//visited[x1][y1]=1;
			return temp1;
		}
		else
		{
		//	cout<<"Here "<<i<<" "<<j<<" "<<temp2<<endl; 
			DP[i][j]=temp2;
			//cout<<"Set "<<x2<<" "<<y2<<endl;
			//visited[x2][y2]=1;
			return temp2;
		}

	}

}
