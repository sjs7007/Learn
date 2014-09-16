# Octave Basics 

1. [Plotting](http://www.obihiro.ac.jp/~suzukim/masuda/octave/html3/octave_90.html)

+ Basic 

```
x = -10:0.1:10;
plot (x, sin (x));
```

+ fplot

The function fplot also generates two-dimensional plots with linear axes using a function name and limits for the range of the x-coordinate instead of the x and y data. For example,

``` 	
fplot (@sin, [-10, 10], 201);
```

produces a plot that is equivalent to the one above, but also includes a legend displaying the name of the plotted function.

+ Printing

After plot is displayed, give following command

```
print <fileName.fileFormat>
```

[1000 coins probability](http://math.stackexchange.com/questions/274633/if-you-toss-1000-fair-coins-10-times-each-what-is-the-probability-the-some)