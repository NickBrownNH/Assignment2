package com.example.assignment2;

/**
 * @author Nick Brown
 * @date 2/28/2022
 *
 * The ShuffleNCipher class has methods and constructors that work to transform an input text
 * and to return a string that has its characters shuffled around a number of times.
 *
 * Ex.  abcdefghi -> afbgchdie
 *      1 shuffle
 *
 *      My name is Nick -> Naiiymsc e kn N
 *      2 shifts
 *
 *      012345678 -> 024681357
 *      5 shifts
 *
 */
public class ShuffleNCipher implements Cipher {
    int shuffles = 1;

    /**
     * This constructor takes in how many shuffles should be preformed, the inputted string, and weather the string
     * should be encoded or decoded and returns a string that is either encoded or decoded an x number of times.
     * This preforms the encoded or decode method which returns the shifted version of the original string.
     *
     * @param shuffles  the variable that states how many times the original string needs to be encoded or decoded
     * @param plainText the variable that holds the original text given
     * @param enc       the variable that decides whether the returned string is encoded or decoded
     * @return          the encoded or decoded string which has been preformed a number of times defined under the shuffles variable
     */
    String ShuffleNCipher (int shuffles, String plainText, boolean enc) {
        String newText = plainText;

        //Checks if given value should be encoded or decoded
        if (enc) {
            //Encodes the plain text the number of times defined in the variable shuffles
            for (int i = 0; i < Math.abs(shuffles); i++)
                newText = encode(newText);

            return newText;
        } else {
            //Decodes the plain text the number of times defined in the variable shifts
            for (int i = 0; i < Math.abs(shuffles); i++)
                newText = decode(newText);

            return newText;
        }

    }


    /**
     * This constructor takes in how many shuffles should be preformed.
     * This preforms the encoded or decode method which returns the shifted version of the original string.
     *
     * @param shuffles  the variable that states how many times the original string needs to be encoded or decoded
     * @return          the encoded or decoded string which has been preformed a number of times defined under the shuffles variable
     */
    String ShuffleNCipher (int shuffles) {
        String newText = "plainText";
        boolean enc = true;

        //Checks if given value should be encoded or decoded
        if (enc) {
            //Encodes the plain text the number of times defined in the variable shuffles
            for (int i = 0; i < Math.abs(shuffles); i++)
                newText = encode(newText);

            return newText;
        } else {
            //Decodes the plain text the number of times defined in the variable shifts
            for (int i = 0; i < Math.abs(shuffles); i++)
                newText = decode(newText);

            return newText;
        }

    }

    /**
     * This preforms the encoded or decode method which returns the shifted version of the original string.
     *
     * @return  the encoded or decoded string which has been preformed a number of times defined under the shuffles variable
     */
    String ShuffleNCipher () {
        shuffles = (int)Math.random()*10;
        String newText = "plainText";
        boolean enc = true;

        //Checks if given value should be encoded or decoded
        if (enc) {
            //Encodes the plain text the number of times defined in the variable shuffles
            for (int i = 0; i < Math.abs(shuffles); i++)
                newText = encode(newText);

            return newText;
        } else {
            //Decodes the plain text the number of times defined in the variable shifts
            for (int i = 0; i < Math.abs(shuffles); i++)
                newText = decode(newText);

            return newText;
        }

    }


    /**
     * This method takes in the plainText and shuffles the characters by splitting up the string in
     * half and merging the two halves together and then return the new shuffled string.
     *
     * Ex.  abcdefghi -> afbgchdie
     *       1 shuffle
     *
     * @param plainText the variable that holds the original text given
     * @return          the encoded string
     */
    public String encode(String plainText) {

        String newText = "";
        char[] newChar = new char[plainText.length()];
        char[] firstHalf = new char[(int)Math.floor(plainText.length()/2)+1];
        char[] secondHalf = new char[((int)Math.floor(plainText.length()/2))];

        //These are placeholder variables used for counting
        int j = 0;
        int x = 0;
        int y = 0;


            for (int i = 0; i < plainText.length(); i++) {

                if (i < firstHalf.length && plainText.length()%2 != 0) { //sets the first half of the string to the character array firstHalf
                    firstHalf[i] = plainText.charAt(i);

                } else if (i >= firstHalf.length && plainText.length()%2 != 0) { //sets the second half of the string to the character array secondHalf
                    secondHalf[x] = plainText.charAt(i);
                    x++;
                }

                if (i < firstHalf.length-1 && plainText.length()%2 == 0) { //sets the first half of the string to the character array firstHalf
                    firstHalf[i] = plainText.charAt(i);

                } else if (i >= firstHalf.length-1 && plainText.length()%2 == 0) { //sets the second half of the string to the character array secondHalf
                    secondHalf[x] = plainText.charAt(i);
                    x++;
                }

            }


        for (int i = 0; i < plainText.length(); i++) {

                if (i%2 == 0) { //sets the new character equal to first half at j when i is even
                    newChar[i] = firstHalf[j];
                    j++;
                } else {  //sets the new character equal to second half at j when i is odd
                    newChar[i] = secondHalf[y];
                    y++;
                }

            //Sets newText to the current newText plus the new character given
            newText = newText + newChar[i];
        }

        return newText;
    }



    /**
     * This method takes in the encodedText and shuffles the characters by splitting up the string in
     * half and merging the two halves together and then return the new unshuffled string.
     *
     * Ex.   afbgchdie -> abcdefghi
     *       1 shuffle
     *
     * @param plainText the variable that holds the original text given
     * @return          the encoded string
     */
    public String decode(String plainText) {

        String newText = "";
        char[] firstHalf = new char[(int)Math.floor(plainText.length()/2)+1];
        char[] secondHalf = new char[((int)Math.floor(plainText.length()/2))];

        //These are placeholder variables used for counting
        int j = 0;
        int x = 0;
        int y = 0;


        for (int i = 0; i < plainText.length(); i++) {

            if (i%2 == 0) { //sets the new character equal to first half at j when i is even
                firstHalf[j] = plainText.charAt(i);
                j++;
            } else if (i%2 != 0) {  //sets the new character equal to second half at j when i is odd
                secondHalf[y] = plainText.charAt(i);
                y++;

            }

        }

        for (int i = 0; i < plainText.length()+1; i++) {

            if (i < firstHalf.length) {     //sets the newString to the newString plus the firstHalf characters
                newText = newText + firstHalf[i];
            } else {    //sets the newString to the newString plus the secondHalf characters
                newText = newText + secondHalf[x];
                x++;
            }

        }


        return newText;
    }

    /**
     * Runs the encode method once for the text given
     *
     * @param text  inputs into encode method
     * @return      the encoded text that was shuffled once in the encoded method
     */
    protected String shuffleOnce (String text) {
        return encode(text);
    }

    /**
     * Runs the decode method once for the text given
     *
     * @param text  inputs into decode method
     * @return      the decoded text that was shuffled once in the decode method
     */
    protected String decodeOnce (String text) {
        return decode(text);
    }
}
