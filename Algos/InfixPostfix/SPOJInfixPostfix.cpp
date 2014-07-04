// Convert infix expression to postfix expression
//currently only fot +,-,*,/ without brackets
//adding brackets

//SPOJ : http://www.spoj.com/problems/ONP/

#include<iostream>
#include<stack> //for stack STL

using namespace std;

string infixPostfix(string input); //convert infix to postfix
bool isOperand(char c);
bool isOperator(char c);
int getPriority(char op);
bool higherPriority(char op1,char op2); //check if op1 has higher priority than op2

int main()
{
	int t;
	cin >>t;
	for(int i=0;i<t;i++)
	{
		string input;
		cin >>input;
		string output;
		output = infixPostfix(input);
	//	cout<<"Postfix Expression is : "<<output<<endl;
		cout<<output<<endl;
	}
}

bool isOperand(char c)
{
	if((c>='0' && c<='9') ||(c>='a' && c<='z'))
	{
		return true;
	}
	else
	{
		return false;
	}
}

bool isOperator(char c)
{
	if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^')
	{
		return true;
	}
	else
	{
		return false;
	}
}

int getPriority(char op)
{
	int priority=-1;
	switch(op)
	{
		case '+':
		case '-':
					priority=1;
					break;
		case '*':
		case '/':	priority=2;
					break;

		case '^':
					priority=3;
					break;
	}
	return priority;
}

bool higherPriority(char op1,char op2)
{
	int x=getPriority(op1);
	int y=getPriority(op2);
	if(x>=y)
	{
		return true;
	}
	else
	{
		return false;
	}
}

string infixPostfix(string input)
{
	string temp;
	stack <char> s;
	for(int i=0;i<input.length();i++)
	{
		if(isOperand(input[i]))
		{
			temp = temp + input[i];
		}
		else if(isOperator(input[i]))
		{
			while(!s.empty() && s.top()!='(' && higherPriority(s.top(),input[i]))
			{
				temp = temp + s.top();
				s.pop();
			}
			s.push(input[i]);
		}
		else if(input[i]=='(')
		{
			s.push('(');
		}
		else if(input[i]==')')
		{
			while(!s.empty() && s.top()!='(')
			{
				temp = temp + s.top();
				s.pop();
			}
			s.pop(); //to remove the open paren
		}
	}
	while(!s.empty())
	{
		temp = temp + s.top();
		s.pop();
	}
	return temp;
}
