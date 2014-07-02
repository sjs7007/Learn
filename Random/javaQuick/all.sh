for line in `find . -iname '*.java'`; do 
     make all f=`basename $line .java`
done