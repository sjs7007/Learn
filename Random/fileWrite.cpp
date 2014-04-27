//basic file operations : http://www.cplusplus.com/doc/tutorial/files/

#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	ofstream testFile;
	testFile.open("test.txt");
	testFile <<"this is from a c++ program.\n";
	testFile.close();
}
