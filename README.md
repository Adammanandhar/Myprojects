The Grayscale program works to open an existing image in jpg format (the name of the file will be given as a command line argument to the program), convert the image from full color to grayscale, and then save the modified image in a file named grayscale.jpg.

The colorbars program generates a reproduction of an Emmy award-winning (Engineering 2001-2002) work developed forty or so years ago, specifically, an approximation of the SMPTE Color Bars test pattern. The Colorbars program will be invoked with three command-line inputs: the name of the image file to create, how many pixels wide they the color bars pattern should be, and whether the pattern should be dim or bright. When executed, the image the program creates will display via the image.show() method and be saved in the working directory via the image.save(filename) method, but there will be virtually no Console output of the program unless there is an error with the inputs or the intended width. An example of program invocation: radius$ java Colorbars  smpte.png  240  dim

Contributors: My professor had provided a template code on how to modify and save image in PNG format.

