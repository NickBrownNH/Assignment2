package com.example.assignment2;

/**
 * The ShiftNCipher class has methods and constructors that work to transform an input text
 * and to return a string that has its characters shifted a number of times.
 *
 * Ex.  a -> b
 *      1 shift
 *
 *      a -> f
 *      5 shifts
 *
 *      a -> z
 *      -1 shift
 */
public class ShiftNCipher implements Cipher{

    /**
     * This constructor takes in how many shifts should be preformed, the inputted string, and weather the string
     * should be encoded or decoded and returns a string that is either encoded or decoded an x number of times.
     * This preforms the encode method which returns the shifted version of the original string.
     *
     * @param shifts    the variable that states how many times the original string needs to be encoded or decoded
     * @param plainText the variable that holds the original text given
     * @param enc       the variable that decides whether the returned string is encoded or decoded
     * @return          the encoded or decoded string which has been preformed a number of times defined under the shifts variable
     */
    String ShiftNCipher (int shifts, String plainText, boolean enc) {
        String newText = plainText;

        //Checks if given value should be encoded or decoded
        if (enc) {
            //Encodes the plain text the number of times defined in the variable shifts
            for (int i = 0; i < Math.abs(shifts); i++)
                newText = encode(newText, shifts);

            return newText;
        } else {
            //Decodes the plain text the number of times defined in the variable shifts
            for (int i = 0; i < Math.abs(shifts); i++)
                newText = decode(newText, shifts);

            return newText;
        }
    }

    /**
     * This method takes in the plainText and shifts the characters once in the positive direction and then
     * returns the new shifted string.
     *
     * Ex.  a -> b
     *      1 -> 2
     *      z -> a
     *      9 -> 0
     *
     * @param plainText the variable that holds the original text given
     * @return          the encoded string
     */
    public String encode(String plainText) {

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int charCode;


            for (int i = 0; i < plainText.length(); i++) {

                //Gets the character code of the string at the index i
                charCode = plainText.charAt(i);

                //Checks if the character at index i is a number or not
                if (Character.isDigit(plainText.charAt(i))) {

                    //Checks if the number is at the rollover point, but if it isn't it shifts the character to the right
                    if (Character.getNumericValue(plainText.charAt(i)) == 9) {
                        newChar[i] = '0';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))+1), 10);
                    }

                    //Sets newText to the current newText plus the new number given
                    newText = newText + newChar[i];

                } else {
                    //Checks if the character is at the rollover point (z -> a)
                    if (charCode == 122) {
                        newChar[i] = (char) (97);

                    } else if (charCode == 90) { //Checks if the character is at the rollover point (Z -> A)
                        newChar[i] = (char) (65);

                    } else if (charCode >= 65 && charCode <= 122) { //Checks if the character is a valid letter and if so, shifts it to the right
                        newChar[i] = (char) (charCode + 1);

                    } else {
                        newChar[i] = (char) (charCode); //If the character isn't a letter then it stays the same

                    }

                    //Sets newText to the current newText plus the new character given
                    newText = newText + newChar[i];
                }
            }


        return newText;
    }

    /**
     * This method takes in the plainText and shifts the characters once in the direction specified in the variable shifts
     * and then returns the new shifted string.
     *
     * Ex.  shifts = 5 (shifts to the right)
     *      shifts = -7 (shifts to the left)
     *      shifts = 0 (stays the same)
     *
     * @param plainText the variable that holds the original text given
     * @param shifts    the variable that takes the number of shifts that then decides what direction the text
     *                  will be shifted in. It will either be shifted in the negative direction, positive directions,
     *                  or if shifts is 0 it won't preform a shift.
     * @return          the encoded string that has been shifted in the direction defined in the variable shifts
     */
    public String encode(String plainText, int shifts) {

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int charCode;


        //If the number of shifts are positive then it shifts to the right
        if (shifts > 0) {
            for (int i = 0; i < plainText.length(); i++) {

                //Gets the character code of the string at the index i
                charCode = plainText.charAt(i);

                //Checks if the character at index i is a number or not
                if (Character.isDigit(plainText.charAt(i))) {

                    //Checks if the number is at the rollover point, but if it isn't it shifts the character to the right
                    if (Character.getNumericValue(plainText.charAt(i)) == 9) {
                        newChar[i] = '0';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))+1), 10);
                    }

                    //Sets newText to the current newText plus the new number given
                    newText = newText + newChar[i];

                } else {
                    //Checks if the character is at the rollover point (z -> a)
                    if (charCode == 122) {
                        newChar[i] = (char) (97);

                    } else if (charCode == 90) { //Checks if the character is at the rollover point (Z -> A)
                        newChar[i] = (char) (65);

                    } else if (charCode >= 65 && charCode <= 122) { //Checks if the character is a valid letter and if so, shifts it to the right
                        newChar[i] = (char) (charCode + 1);

                    } else { // If the character isn't a letter then it stays the same
                        newChar[i] = (char) (charCode);

                    }

                    //Sets newText to the current newText plus the new character given
                    newText = newText + newChar[i];
                }
            }
        } else if (shifts < 0) {
            for (int i = 0; i < plainText.length(); i++) {

                //Gets the character code of the string at the index i
                charCode = plainText.charAt(i);

                //Checks if the character at index i is a number or not
                if (Character.isDigit(plainText.charAt(i))) {

                    //Checks if the number is at the rollover point, but if it isn't it shifts the character to the left
                    if (Character.getNumericValue(plainText.charAt(i)) == 0) {
                        newChar[i] = '9';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))-1), 10);
                    }

                    //Sets newText to the current newText plus the new number given
                    newText = newText + newChar[i];

                } else {
                    //Checks if the character is at the rollover point (a -> z)
                    if (charCode == 97) {
                        newChar[i] = (char) (122);

                    } else if (charCode == 65) { //Checks if the character is at the rollover point (A -> Z)
                        newChar[i] = (char) (90);

                    } else if (charCode >= 65 && charCode <= 122) { //Checks if the character is a valid letter and if so, shifts it to the left
                        newChar[i] = (char) (charCode - 1);

                    } else {
                        newChar[i] = (char) (charCode); //If the character isn't a letter then it stays the same

                    }

                    //Sets newText to the current newText plus the new character given
                    newText = newText + newChar[i];
                }
            }
        } else { //Sets the plainText equal to itself because the shifts entered is zero
            newText = plainText;
        }
        return newText;
    }


    /**
     * This method takes in the encodedText and shifts the characters once to the left
     *
     * @param encodedText   the variable that holds the encoded text given
     * @return              the decoded string that has been shifted to the left
     */
    public String decode(String encodedText) {


        String newText = "";
        char[] newChar = new char[encodedText.length()];
        int charCode;


            for (int i = 0; i < encodedText.length(); i++) {

                //Gets the character code of the string at the index i
                charCode = encodedText.charAt(i);

                //Checks if the character at index i is a number or not
                if (Character.isDigit(encodedText.charAt(i))) {

                    //Checks if the number is at the rollover point, but if it isn't it shifts the character to the left
                    if (Character.getNumericValue(encodedText.charAt(i)) == 0) {
                        newChar[i] = '9';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(encodedText.charAt(i))-1), 10);
                    }

                    //Sets newText to the current newText plus the new number given
                    newText = newText + newChar[i];

                } else {
                    //Checks if the character is at the rollover point (a -> z)
                    if (charCode == 97) {
                        newChar[i] = (char) (122);

                    } else if (charCode == 65) { //Checks if the character is at the rollover point (A -> Z)
                        newChar[i] = (char) (90);

                    } else if (charCode >= 65 && charCode <= 122) { //Checks if the character is a valid letter and if so, shifts it to the left
                        newChar[i] = (char) (charCode - 1);

                    } else {
                        newChar[i] = (char) (charCode); //If the character isn't a letter then it stays the same

                    }

                    //Sets newText to the current newText plus the new character given
                    newText = newText + newChar[i];
                }
            }

        return newText;
    }


    /**
     * This method takes in the encodedText and shifts the characters once in the direction specified in the variable shifts
     * and then returns the new shifted string.
     *
     * @param encodedText   the variable that holds the encoded text given
     * @param shifts        the variable that takes the number of shifts that then decides what direction the text
     *                      will be shifted in. It will either be shifted in the negative direction, positive directions,
     *                      or if shifts is 0 it won't preform a shift.
     * @return              the decoded string that has been shifted in the direction defined in the variable shifts
     */
    public String decode(String encodedText, int shifts) {

        String newText = "";
        char[] newChar = new char[encodedText.length()];
        int charCode;


        //If the number of shifts are negative then it shifts to the right
        if (shifts < 0) {
            for (int i = 0; i < encodedText.length(); i++) {

                //Gets the character code of the string at the index i
                charCode = encodedText.charAt(i);

                //Checks if the character at index i is a number or not
                if (Character.isDigit(encodedText.charAt(i))) {

                    //Checks if the number is at the rollover point, but if it isn't it shifts the character to the right
                    if (Character.getNumericValue(encodedText.charAt(i)) == 9) {
                        newChar[i] = '0';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(encodedText.charAt(i))+1), 10);
                    }

                    //Sets newText to the current newText plus the new number given
                    newText = newText + newChar[i];

                } else {
                    //Checks if the character is at the rollover point (z -> a)
                    if (charCode == 122) {
                        newChar[i] = (char) (97);

                    } else if (charCode == 90) { //Checks if the character is at the rollover point (Z -> A)
                        newChar[i] = (char) (65);

                    } else if (charCode >= 65 && charCode <= 122) { //Checks if the character is a valid letter and if so, shifts it to the right
                        newChar[i] = (char) (charCode + 1);

                    } else {
                        newChar[i] = (char) (charCode); //If the character isn't a letter then it stays the same

                    }

                    //Sets newText to the current newText plus the new character given
                    newText = newText + newChar[i];
                }
            }
        } else if (shifts > 0) {
            for (int i = 0; i < encodedText.length(); i++) {

                //Gets the character code of the string at the index i
                charCode = encodedText.charAt(i);

                //Checks if the character at index i is a number or not
                if (Character.isDigit(encodedText.charAt(i))) {

                    //Checks if the number is at the rollover point, but if it isn't it shifts the character to the left
                    if (Character.getNumericValue(encodedText.charAt(i)) == 0) {
                        newChar[i] = '9';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(encodedText.charAt(i))-1), 10);
                    }

                    //Sets newText to the current newText plus the new number given
                    newText = newText + newChar[i];

                } else {
                    //Checks if the character is at the rollover point (a -> z)
                    if (charCode == 97) {
                        newChar[i] = (char) (122);

                    } else if (charCode == 65) { //Checks if the character is at the rollover point (A -> Z)
                        newChar[i] = (char) (90);

                    } else if (charCode >= 65 && charCode <= 122) { //Checks if the character is a valid letter and if so, shifts it to the left
                        newChar[i] = (char) (charCode - 1);

                    } else {
                        newChar[i] = (char) (charCode); //If the character isn't a letter then it stays the same

                    }

                    //Sets newText to the current newText plus the new character given
                    newText = newText + newChar[i];
                }
            }
        } else { //Sets the encodedText equal to itself because the shifts entered is zero
            newText = encodedText;
        }

        return newText;
    }


    /**
     * Runs the encode method once for the text given
     *
     * @param text  inputs into encode method
     * @return      the encoded text that was shifted once in the encoded method
     */
    protected String shiftOnce (String text) {
        return encode(text);
    }

    /**
     * Runs the decode method once for the text given
     *
     * @param text  inputs into decode method
     * @return      the decoded text that was shifted once in the decode method
     */
    protected String decodeOnce (String text) {
        return decode(text);
    }

}