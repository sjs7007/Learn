//basic file operations : http://www.cplusplus.com/doc/tutorial/files/

#include <iostream>
#include <fstream>
using namespace std;

void outWrite(ofstream x);

int main()
{
	ofstream testFile;
	
	testFile.open("test2.txt");
	testFile <<"this is from a c++ program.\n";
	testFile.close();
	testFile.open("test3.txt",std::ios_base::app);
	testFile <<"this too is from a c++ program.\n";
//outWrite(testFile);
	testFile.close();
}

void outWrite(ofstream x)
{
	x << "Hello\n";
}


