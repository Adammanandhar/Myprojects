/*----------------------------------------------------------------
     *  Author:   Trishala Manandhar
     *  Email:    TMANAN21@g.holycross.edu
     *  Written:  9/28/2020
     *  Updated:  9/30/2020 - added comments and the error message at the beginning
     *
     *  This program allows for one to change any image to a grayscale by 
     *  manipulating the RGB components of each pixel.
     *
     *  Example: java Gray Nolan.jpg
     *----------------------------------------------------------------*/
import java.awt.Color;// this allows us to use shorthand Color instead of the whole name throughout the program.
public class Gray {
    public static void main (String args[]) {
        if(args.length!=1) { // this notifies and gives directions to the user if they don't write the command line properly.
            System.out.println("You forgot to give an argument in the command line");
            System.out.println("Example:java Gray Nolan.jpg");
            System.exit(0);
        }
        Picture image = new Picture(args[0]); // This stores the image given by the argument.

        for (int x=0; x<image.width(); x++) { // At each width, the following "for" loop will happen until x = image.width().
            for (int y=0; y<image.height(); y++) { // In this loop, all 3 intesity is calculated for every pixel at height,Y, and width, x, to provide the new luminance, which is the new color gray. 
                Color pixel = image.get(x,y);
                int redIntensity = (int) pixel.getRed();
                int greenIntensity = (int) pixel.getGreen();
                int blueIntensity = (int) pixel.getBlue();
                int luminance = (int)((0.299*redIntensity) +(0.587*greenIntensity) +(0.114*blueIntensity));
                Color gray = new Color (luminance, luminance, luminance); 
                image.set(x, y, gray);// setting the image to the new color gray 
            }
        }         

          image.save("grayscale.jpg");// This saves the image provided at args[0] at grayscale.jpg.
          image.show();// This allows the image to be shown when we run the program.
    } // end of main
}// end of Gray
