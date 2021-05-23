/*-----------------------------------------------------------------------
     *  Author:   Trishala Manandhar
     *  Email:    TMANAN21@g.holycross.edu
     *  Written:  10/24
     *  Updated:  10/26/2020 - corrected syntax errors and other mistakes on my code 
     *  Updated:  10/27/2020 - added comments
     *  
     *  This program uses two functions: huffman Decode and lookupCode function,   
     *  where through these functions it figures out the number of bits, characters
     *  read of a file and lastly prints the ASCII characters onto the output file. 
     *
     *  Example:  java Huffman 
     *------------------------------------------------------------------*/
public class Huffman {
    public static char lookupCode (String codeFilename, String target) {
        In inFile = new In(codeFilename); 

        // this loop makes sure that we read and store each string, integer and line 
        // and do the if statetment if necessary until inFile has a line in its file.
        while (inFile.hasNextLine()) { 
            String s = inFile.readString();
            int i = inFile.readInt();
            inFile.readLine();  
            
            // if the string matches with the given target in the test,
            // then the integer stored in it will be changed into the ASCII character associated with that number.
            if (s.equals(target)) {
                char ch = (char)i;
                return ch;
            } // end of if statment

        } // end of while loop

        return Character.UNASSIGNED;// if the return in the if statment doesn't happen then, this return will follow. 

    } // end of lookupCode function

    public static int [] huffmanDecode (String input, String output) {   
        In inputFile = new In(input);
        Out outputFile = new Out(output);
        String target = "";
        int count = 0;// increases by one everytime there is legal bits stored in target
        int decodedCount = 0;// increases by one everytime lookupCode return a ASCII character

        // This loop keeps running as long as there is another character in the input file
        // and does the following if statement if the character in the file is '0' or '1'
        // then it calls the lookupCode function to check if whatever is stored in the target
        // returns an ASCII character or Character.UNASSIGNED
        // If the return is a ASCII character then target empties itself else it keeps adding
        // another charter into the target string until there is a return of ASCII Character. 
        while (inputFile.hasNextChar()) {
            char ch = inputFile.readChar();
 
            // if character is '0' or '1', it is stored in target and count increases by 1. 
            if (ch == '0' || ch == '1') {
                target = target + ch; 
                count++;
            }
            char lookup = lookupCode("code-table.txt", target);

            // so if the return for the lookupCode function is not Character.UNASSIGNED
            // then the ASCII character stored in lookup will be printed in the output file
            // and then the target is emptied, and then the decodedCount is increased by 1.
            if (lookup != Character.UNASSIGNED) {
                outputFile.print(lookup);
                target = "";
                decodedCount++;
            }

       } // end of while loop

       // This stores the count for bits and characters decoded into the resultForMain array
       int [] resultForMain = new int [2];
       resultForMain[0] = count;
       resultForMain[1] = decodedCount;

       return resultForMain;

    }// end of huffmanDecode function */

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the Huffman Decompression program.");
        System.out.print("Input file: ");
        String inputPath = StdIn.readLine();
        System.out.print("Output file: ");
        String outputPath = StdIn.readLine();
        int [] finalCount = huffmanDecode(inputPath, outputPath);
        System.out.println("Number of bits read from input file: " + finalCount[0]);
        System.out.println("Number of characters decoded: " + finalCount[1]);
        double average = (finalCount[0] + 0.0) / finalCount[1];
        System.out.printf("Average bits per compressed character: %.3f \n", average);
        System.out.println("\nThank you and have a nice day!\n");

  } //end of main  
        
} // end of Huffman
         
         
