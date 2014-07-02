//Java arrays with Abstract Data Types + demonstrate this keyword

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

class Example4
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
