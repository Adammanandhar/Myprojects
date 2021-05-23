/*----------------------------------------------------------------
     *  Author:   Trishala Manandhar
     *  Email:    TMANAN21@g.holycross.edu
     *  Written:  10/05/2020 
     *  Updated:  10/06/2020 - wrote comments & added case for args[2].
     *
     *  This program allows for one to create dim and bright SMPTE  
     *  color bars.
     *
     *  Example: java Colorbars colors.png 400 bright
     *----------------------------------------------------------------*/
import java.awt.Color;
public class Colorbars {
    public static void main (String[] args) {
        if(args.length!=3) {
            System.out.println("You forgot to give 3 argument in the command line");
            System.out.println("Example:java Colorbars colors.png 400 bright");
            System.exit(0);
        } // this notifies and gives directions to the user if they don't write the command line properly.

        int imageWidth = Integer.parseInt(args[1]);
        int imageHeight =(int)((3.0/4.0)*imageWidth);
        Picture image = new Picture(imageWidth,imageHeight);// This creates the image in the width that user has provided and the height calculated above.
        boolean brightness =(args[2]).equalsIgnoreCase("bright");// This compares two strings to see if it equals or not while ignoring the case.

        if (imageWidth <= 0 || imageWidth % 16 != 0) {
            System.out.println("Your width is not within the bounds");
            System.out.println("The width needs to be greater than 0 and a multiple of 16");
            System.exit(1);
        } // This if statement makes sure that the program provides an error message if the width that the user provided is a negative number or not a multiple of 16.
        int top = (int)((2.0/3.0)*imageHeight);// this calculate the height of the top of the SMPTE Bars.
        int bottom = imageHeight;// I equal this to the height of the picture because this is the first layer I include in the for loop hence, if I calculate the middle and the top height I don't need to calculate the bottom height.
        int middle = imageHeight-((int)((1.0/4.0)*imageHeight));// This is the second layer of my for loop down below and since, the bottom layer is suppose be 1/4 the image's height, I can just subtract the bottom's height from the regualr image height.
        int topWidth = (int)(imageWidth/7.0);// Calculate the width of each of the smpte bars on the top row. 
        int middleWidth = topWidth; // same amount of division as the top row so equal each other.
        int bottomWidth = (int)(imageWidth/6.0);// Same process as finding the width as the top one;just the amount of columns are different
        
          
        Color white = new Color(255, 255, 255);
        Color black = new Color(0, 0, 0);
        Color darkblue = new Color(0, 33, 76);
        Color darkpurple = new Color(50, 0, 106);
        Color gray = new Color(192, 192, 192);
        Color yellow = new Color(192, 192, 0);
        Color cyan = new Color(0, 192, 192);
        Color green = new Color(0, 192, 0);
        Color magenta = new Color(192, 0, 192);
        Color red = new Color(192, 0, 0);
        Color blue = new Color(0, 0, 192);
            
       
        if (brightness) {
            gray = new Color(255, 255, 255);
            yellow = new Color(255, 255, 0);
            cyan = new Color(0, 255, 255);
            green = new Color(0, 255, 0);
            magenta = new Color(255, 0, 255);
            red = new Color(255, 0, 0);
            blue = new Color(0, 0, 255);
        }    
            
        for (int y=0; y<bottom; y++) {
            for (int x=0; x<imageWidth; x++) {    
                image.set(x,y,black);
            }
            for (int x=0; x<(imageWidth-bottomWidth); x++) {
                image.set(x,y,black);
            }
            for (int x=0; x<(imageWidth-(2*bottomWidth)); x++) {
                image.set(x,y,black);
            }
            for (int x=0; x<(imageWidth-(3*bottomWidth)); x++) {
                image.set(x,y,darkpurple);
            }
            for (int x=0; x<(imageWidth-(4*bottomWidth)); x++) {
                image.set(x,y,white);
            }
            for (int x=0; x<(imageWidth-(5*bottomWidth)); x++) {
                image.set(x,y,darkblue);
            }// for the width, similar with the height, I color everything black first, and the next black will overlap minus the width calculated at the top.

        }// This for loop will color the whole smpte bars with the colors from the bottom quarter from right to left, which is why the width start with image setting to black.

        for (int y=0; y<middle; y++) {
            for (int x=0; x<imageWidth; x++) {    
                image.set(x,y,gray);
            }
            for (int x=0; x<(imageWidth-middleWidth); x++) {
                image.set(x,y,black);
            }
            for (int x=0; x<(imageWidth-(2*middleWidth)); x++) {
                image.set(x,y,cyan);
            }
            for (int x=0; x<(imageWidth-(3*middleWidth)); x++) {
                image.set(x,y,black);
            }
            for (int x=0; x<(imageWidth-(4*middleWidth)); x++) {
                image.set(x,y,magenta);
            }
            for (int x=0; x<(imageWidth-(5*middleWidth)); x++) {
                image.set(x,y,black);
            }
            for (int x=0; x<(imageWidth-(6*middleWidth)); x++) {
                image.set(x,y,blue);
            }
        }// This for loop will color all the smpte bars with the middle colors from right to left, except the bottom quarter. 

        for (int y=0; y<top; y++) {
            for (int x=0; x<imageWidth; x++) {    
                image.set(x,y,blue);
            }
            for (int x=0; x<(imageWidth-topWidth); x++) {
                image.set(x,y,red);
            }
            for (int x=0; x<(imageWidth-(2*topWidth)); x++) {
                image.set(x,y,magenta);
            }
            for (int x=0; x<(imageWidth-(3*topWidth)); x++) {
                image.set(x,y,green);
            }
            for (int x=0; x<(imageWidth-(4*topWidth)); x++) {
                image.set(x,y,cyan);
            }
            for (int x=0; x<(imageWidth-(5*topWidth)); x++) {
                image.set(x,y,yellow);
            }
            for (int x=0; x<(imageWidth-(6*topWidth)); x++) {
                image.set(x,y,gray);
            }
        }// This for loop will color the top 2/3 of the height from right to left with the colors provided for the top.

                
        image.save(args[0]);// This saves this image in the name that is given on the command line by the user.
        image.show();// This allows the program to show the image.

    } //end of main
}// end of Colorbars.



        
