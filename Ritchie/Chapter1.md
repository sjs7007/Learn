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
Text input or output, regardless of where it originates or where it goes to, is dealt with as streams of characters. A text stream is a sequence of characters 
divided into lines; each line consists of zero or more characters followed by a newline character.
```

+ c = getchar()

	+ Each time it is called, getchar reads the next input character from a text stream and returns its value.

+ putchar(c)

	+ Prints contents of c as character.

+ [Example Code](CharacterIO.c)


