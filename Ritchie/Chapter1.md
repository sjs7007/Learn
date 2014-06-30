# Chapter 1

1.Text Justification
-----

+ %kd will make the output right justified in a field k digits wide.

+ %p.qf will print as floating point, at least 6 p characters wide and q after decimal point.

2.Symbolic Constants
-----

+ A #define line defines a symbolic name or symbolic constant to be a particular string of characters.

+ ```#define name replacement list```

+ Example : #define LOWER 0, will replace "LOWER" with 0 whenever it occurs in the program.

+ Symbolic constants are conventionally written in upper case letters.

3.Character Input & Output
-----

```
Text input or output, regardless of where it originates or where it goes to, is dealt with as streams of characters.
A text stream is a sequence of characters divided into lines; each line consists of zero or more characters followed
by a newline character.
```

+ c = getchar()

	+ Each time it is called, getchar reads the next input character from a text stream and returns its value.

+ putchar(c)

	+ Prints contents of c as character.

+ [Character IO Code](CharacterIO.c)

+ ### 3.1 EOF 

	+ EOF is used to indicate end of data.
	+ char can't be used to hold EOF since it is not big enough. Hence, often int is used.
	+ EOF is an integer defined in stdio.h
	+ [EOF Code](EOF.c)

4.Functions
-----

+ Function prototype has to be declared at top before defining function.

+ e.g. : int max(int x,int y);

+ The parameter names are optional in prototype declaration so even int max(int ,int ) is a valid syntax.

+ All function arguments are passed "by value" here. (N.A. for arrays)

5.Character Arrays
----

+ A character array should end with '\0'to mark the end of characters.

+ This helps %s format of printf to understand how much to print else problems will occur.

+ [Code Demonstrating null Character](CharArray.c)

6.Global/External Variables
-----

+ External variables are globally acessible.

```
An external variable must be defined, exactly once, outside of any function; this sets aside
storage for it. The variable must also be declared in each function that wants to access it; this
states the type of the variable. The declaration may be an explicit extern statement or may be
implicit from context.
```

+ [Global/External Variables Code](global.c)

+ **NOTE*** : The above example works without declaration of variable inside main function. HOW? 

This is how :-

```
In certain circumstances, the extern declaration can be omitted. If the definition of the
external variable occurs in the source file before its use in a particular function, then there is no
need for an extern declaration in the function. 
```

+ Therefore it is common practice to define all external variables at the beginning of the source file, and then omit all extern declarations.

---------------------------




