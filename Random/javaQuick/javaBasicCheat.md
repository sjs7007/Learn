# Prologue

A basic introduction to get you started with Java. It is a purely object oriented language which is just a fancy way to say everything has to be put inside a class here. So, all programs need to have at least one class which should be same as the name of your program. Otherwise it will cause a problem when you try to run it. This class should always have a main method with which the program execution begins. 

Java code is machine independent. That is, once you have compiled your code on machine you can use the class files obtained as output to run it on some other machine which has the java interpreter. The class files contain code for the java virtual machine. Different systems may have different compiler and virtual machine implementations. However since the machine on which code is finally executed is still the "Java Virtual Machine", machine independency is obtained.

So here is your first example of a simple hello world :-

[Obligatory Hello World!](Example1.java)

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

+ System.out.println( ) <-- println = print line, equal to adding "\n"

+ Else just use, System.out.print()

+ [Some More Print Examples](Example1_1.java)

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

+ **Note** : ip is the object name here.

### 1.1.3 Integer input

+ ```int temp = ip.nextInt();```

1.2 Using Buffered Reader
-----

+ Google. You can do just fine using Scanner in most cases. At least worked well for me till now. :P

# 2.Arrays

+ ```int temp[]={3,4,5};```
+ ```int temp[]=new int[size];```
+ Array indexes are 0 based.
+ Array metadata : <arrayName>.length variable has length of array stored, not actual number of variables present. Size declared during initialization. 
+ [Array Code Link](Example2.java)

```
// Example 2 : Java arrays

class Example2
{
	public static void main(String args[])
	{
		int temp[]={1,2,3,4,5};
		for(int i=0;i<temp.length;i++)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
```

Now, here I'll just sort of jump ahead and create an Abstract Data Type to show you how to handle array of objects.

[Abstract Data Type Arrays](Example3.java)

```Java
//Java arrays with Abstract Data Types

class Student
{
	String name;
	int ID;

	Student(String x,int y) // <--1.Constructor. Read in doc.
	{
		name = x;
		ID = y;
	}

	void display()
	{
		System.out.println("Name : "+name+", ID : "+ID);
	}
}

class Example3
{
	public static void main(String args[])
	{
		//Before we go to arrays of ADT, example of using simple ADT

		Student S = new Student("shin",7); 
		S.display();
		
		Student StudentArray[] = new Student[5];
		for(int i=0;i<StudentArray.length;i++)
		{
			StudentArray[i]=new Student("test",i);
		}

		for(int i=0;i<StudentArray.length;i++)
		{
			StudentArray[i].display();
		}
		

	}
}
```

+ Constructor 

	+ Used to create instance of class.
	+ Is declared without any return type. Not even void.
	+ [More Info if needed.](http://www.javaworld.com/article/2076204/core-java/understanding-constructors.html)

+ **this** keyword

	It refers to the current class inside which you are. You can use it in situations like [this](Example4.java)

	```Java
	class Student
	{
		String name;
		int ID;

		Student(String name,int ID) // <--1.Constructor. Read in doc.
		{
			this.name = name; // <-- Note usage of this keyword.
			this.ID = ID;
		}

		void display()
		{
			System.out.println("Name : "+name+", ID : "+ID);
		}
	}

	```

# 3.Strings

+ User Input : Covered above.

+ ```String input = "blah";```
+ ```String input = new String("blah");```
+ Methods :-

	+ length() : returns length. Methods of a class can be accessed by the syntax <objectName>.method()

	 If the method is static then <className>.method() will also work.
				 
	[More info here if interested which I haven't read](http://www.intertech.com/Blog/a-static-method-should-be-accessed-in-a-static-way/)
		
	+ toUpperCase()

	+ toLowerCase()

	+ charAt(i) : return character at position i. 

	+ substring(i,j) : return substring [i,j) <-- i.e., jth index not included

	+ replace(char x,char y) : replace all occurances of x with y and return modified string

+ You can combine two strings by using "+" operator directly.

	```String temp = "hello"+" world\n";```

+ [String Example Code](Example5.java)

```Java
//Example 5 : Strings

class Example5
{
	public static void main(String args[])
	{
		String test = "hello";
		System.out.println(test.toUpperCase());
		System.out.println(test.toLowerCase());
		System.out.println("Replace all e with u : "+test.replace('e','u'));
		System.out.println("substring : "+test.substring(0,3));
	}
}
```

# 4.Various Conversions

[Various Conversions](Example6.java)

```Java
class Example6
{
	public static void main(String args[])
	{
		String s="10";

		//String to Integer Conversions

		//String to integer
		int n = Integer.parseInt(s); 
		System.out.println(s+ " in base 10 is : "+n);
		//String to integer by default has base 10 but you can give other bases like 2 for e.g.
		n = Integer.parseInt(s,2);
		System.out.println(s+" in base 2 is : "+n);


		//Character to string
		char c='A';
		s = Character.toString(c);

		//type casting 
		int cAscii = (int)(c);
		System.out.println(c+" typecasted to int : "+cAscii);

		//Integer to string
		String temp=Integer.toString(n);
		System.out.println(n+" in base 10 as string : "+temp);
		
		temp=Integer.toString(n,2);
		System.out.println(n+" in base 2 as string : "+temp);
	}
}
```

	
# 5.Random Basic Stuff

+ For math operations, Math class objects are normally used. It is present inside lang package which is automatically imported in every java program hence no explicit imports are necessary.

	+ Math.pow(x,y) : return x^y
	+ Math.sqrt(x)
	+ Math.floor()
	+ Math.ceil()

+ String splitting 

	+ String array[] = <stringName>.split("splitting spearator")

[Random](Example7.java)

```Java
//Random stuff. Example 7

class Example7
{
	public static void main(String args[])
	{
		//Math stuff 

		int k=2;

		int n = (int)Math.pow(k,3); //actually returns double data type. Howevver typecasted to int to avoid precision error message.
		System.out.println(k+" raised to 3 is : "+n);

		double d = Math.sqrt(k);
		System.out.println("Square root of "+k+" is : "+d);

		//Say you only want to print 3 decimal points use below syntax
		System.out.printf("Square root of "+k+" is %.3f \n",d);

		d=Math.random();
		System.out.println("Random decimal in range [0,1) : "+d);

		System.out.println("Floor and ceil : "+Math.floor(d)+" "+Math.ceil(d));

		//String split
		String temp = "hello this is a string.";
		String tempArray[] = temp.split(" "); //split based on spaces and store in string array

		for(int i=0;i<tempArray.length;i++)
		{
			System.out.println(tempArray[i]);			
		}
	}
}
```
# 6.More Things you need to look into

+ Inheritance.
+ Exception Handling.
+ Destructors.
+ Read up on how Java does garbage collection.



