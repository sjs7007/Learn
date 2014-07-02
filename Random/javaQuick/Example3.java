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
