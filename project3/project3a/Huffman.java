/*-----------------------------------------------------------------------
     *  Author:   Trishala Manandhar
     *  Email:    TMANAN21@g.holycross.edu
     *  Written:  10/17/2020
     *  Updated:  10/20/2020 - corrected mistakes on my code 
     *  Updated:  10/21/2020 - added comments
     *  
     *  This program uses the test function, where it uses the lookupCode function to
     *  check the given target in a given file, where it will return the ASCII character
     *  related to the integer, if not then it will return Character.UNASSIGNED. 
     *
     *  Example:  java Huffman code-table-small.txt Ada
     *------------------------------------------------------------------*/
public class Huffman {
    public static char lookupCode (String codeFilename, String target) {
        In inFile = new In(codeFilename); 

        while (inFile.hasNextLine()) { // this loop makes sure that we read and store each string, integer and line and do the if statetment if necessary until inFile has a line in its file.
            String s = inFile.readString();
            int i = inFile.readInt();
            inFile.readLine();  

            if (s.equals(target)) {// if the string matches with the given target in the test, then the integer stored in i will be changed into the ASCII character associated with that number.
                char ch = (char)i;
                return ch;
            } // end of if statment

        } // end of while loop

        return Character.UNASSIGNED;// if the return in the if statment doesn't happen then, this return will follow. 

    } // end of lookupCode function

    private static void test() {
        if (lookupCode("code-table-small.txt", "Ada") == 'L') {
            System.out.println("Ada was looked up correctly");
        } else {
            System.err.println("Ada was not looked up correctly");
        }
        if (lookupCode("code-table-small.txt", "Alan") == 'T') {
            System.out.println("Alan was looked up correctly");
        } else {
            System.err.println("Alan was not looked up correctly");
        }
        if (lookupCode("code-table-small.txt", "A") == Character.UNASSIGNED) {
            System.out.println("A was looked up correctly");
        } else {
            System.err.println("A was not looked up correctly");
        }
    } //end of test
    
    public static void main(String[] args) {
        test();
    } // end of main

} // end of Huffman
         
