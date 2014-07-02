# "Prologue"

A basic introduction to get you started with Java. It is a purely object oriented language which is just a fancy way to say everything has to be put inside a class here. So, all programs need to have at least one class which should be same as the name of your program. Otherwise it will cause a problem when you try to run it. This class should always have a main method with which the program execution begins. So here is your first example of a simple hello world :-

[Link](Example1.java)

Compilation inst : javac Example1.java ; java Example1

``` Java
//First exmaple : Hello World

class Example1
{
	public static void main(String args[])
	{
		System.out.println("Hello World!");
	}
}
```

+ public indicates that this method can be accessed by others.

+ static belongs to class instead of a specific instance. Hence there's no need to instantiate an object to use this method.

+ void : return type

+ main : indicating called first

+ String args[] : used to store command line arguments of string type

# 1.Input

1.1 Using Scanner
-------

+ It is a class present inside util package.
+ Two options here : 
	+ Import only scanner : ```import java.util.Scanner;```
	+ Import all classes inside the package util : ```import java.util.*;```
+ Other than import you'll have to instantiate an object of it inside the class/method which you want to use it.
+ Syntax : ```Scanner <objectName> = new Scanner(System.in);```

### 1.1.2 String user input

+ ```String temp = ip.next();```

### 1.1.3 Integer input

+ ```int temp = ip.nextInt();```

1.2 Using Buffered Reader
-----

+ Google. You can do just fine using Scanner in most cases. At least worked well for me till now. :P

# 2.Arrays
----



