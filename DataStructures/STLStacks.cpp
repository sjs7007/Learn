//http://www.dreamincode.net/forums/topic/57497-stl-stack/
//http://www.cplusplus.com/reference/stack/stack/

#include<iostream>
#include<stack>

using namespace std;

int main()
{
	stack <int> numbers;
	numbers.push(1);
	numbers.push(2);
	numbers.push(3);
	cout<<"Stack top : "<<numbers.top()<<endl;
	//cout<<"Popped element : "<<numbers.pop()<<endl; NOTE : pop doesn't return anything so this causes errors.
	numbers.pop(); 
	cout<<"New stack top : "<<numbers.top()<<endl;
	cout<<"Size of stack : "<<numbers.size()<<endl;
}
