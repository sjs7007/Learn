.PHONY: all

compile: 
	javac $(f).java

run: 
	cp $(f).java combinedText/$(f).txt #copy java program to text file
	cat ../common/oBegins.txt >> combinedText/$(f).txt  #append output begins string 
	java $(f) | tee -a combinedText/$(f).txt #append output to above text file
	cat ../common/end.txt >> combinedText/$(f).txt #append dashes which signify end of output

clean: 
	rm *.class

all: createDirectory compile run clean

createDirectory:
	mkdir -p combinedText #create directory if not present
