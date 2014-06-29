//test maps of STL

// http://stackoverflow.com/questions/1939953/how-to-find-if-a-given-key-exists-in-a-c-stdmap
//http://www.yolinux.com/TUTORIALS/LinuxTutorialC++STL.html

#include <iostream>
using namespace std;
#include <map>

int main()
{
	map <string,char> grade_list;

	grade_list["john"]='B';
	cout<<grade_list["john"];
	cout<<grade_list.count("joh");
}
