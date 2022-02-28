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
public class ShiftNCipher extends HelloController implements Cipher{

    //
    int shiftDirection = 1;

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

        //
        if (enc) {
            //
            for (int i = 0; i < Math.abs(shifts); i++)
                newText = encode(newText, shifts);

            return newText;
        } else {
            //
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


        //
        if (shiftDirection > 0) {
            for (int i = 0; i < plainText.length(); i++) {

                //
                charCode = plainText.charAt(i);

                //
                if (Character.isDigit(plainText.charAt(i))) {

                    //
                    if (Character.getNumericValue(plainText.charAt(i)) == 9) {
                        newChar[i] = '0';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))+1), 10);
                    }

                    //
                    newText = newText + newChar[i];

                } else {
                    //
                    if (charCode == 122) {
                        newChar[i] = (char) (97);

                    } else if (charCode == 90) { //
                        newChar[i] = (char) (65);

                    } else if (charCode >= 65 && charCode <= 122) { //
                        newChar[i] = (char) (charCode + 1);

                    } else {
                        newChar[i] = (char) (charCode); //

                    }

                    //
                    newText = newText + newChar[i];
                }
            }

        //
        } else if (shiftDirection < 0) {
            for (int i = 0; i < plainText.length(); i++) {

                //
                charCode = plainText.charAt(i);

                //
                if (Character.isDigit(plainText.charAt(i))) {

                    //
                    if (Character.getNumericValue(plainText.charAt(i)) == 0) {
                        newChar[i] = '9';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))-1), 10);
                    }

                    //
                    newText = newText + newChar[i];

                } else { //

                    //
                    if (charCode == 97) {
                        newChar[i] = (char) (122);

                    } else if (charCode == 65) { //
                        newChar[i] = (char) (90);

                    } else if (charCode >= 65 && charCode <= 122) { //
                        newChar[i] = (char) (charCode - 1);

                    } else { //
                        newChar[i] = (char) (charCode);

                    }

                    //
                    newText = newText + newChar[i];
                }
            }

        } else { //
            newText = plainText;

        }

        return newText;
    }

    /**
     *
     *
     * @param plainText the variable that holds the original text given
     * @param shifts    the variable that takes the number of shifts that then decides what direction the text
     *                  will be shifted in. It will either be shifted in the negative direction, positive directions,
     *                  or if shifts is 0 it won't preform a shift.
     * @return          the encoded string that has been shifted in the direction defined in the variable shifts
     */
    public String encode(String plainText, int shifts) {

        //
        shiftDirection = shifts;

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int charCode;


        //
        if (shiftDirection > 0) {
            for (int i = 0; i < plainText.length(); i++) {

                charCode = plainText.charAt(i);

                if (Character.isDigit(plainText.charAt(i))) {

                    if (Character.getNumericValue(plainText.charAt(i)) == 9) {
                        newChar[i] = '0';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))+1), 10);
                    }

                    newText = newText + newChar[i];

                } else {


                    if (charCode == 122) {
                        newChar[i] = (char) (97);

                    } else if (charCode == 90) {
                        newChar[i] = (char) (65);

                    } else if (charCode >= 65 && charCode <= 122) {
                        newChar[i] = (char) (charCode + 1);

                    } else {
                        newChar[i] = (char) (charCode);

                    }

                    newText = newText + newChar[i];
                }
            }
        } else if (shiftDirection < 0) {
            for (int i = 0; i < plainText.length(); i++) {

                charCode = (int) plainText.charAt(i);

                if (Character.isDigit(plainText.charAt(i))) {

                    if (Character.getNumericValue(plainText.charAt(i)) == 0) {
                        newChar[i] = '9';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))-1), 10);
                    }

                    newText = newText + newChar[i];

                } else {


                    if (charCode == 97) {
                        newChar[i] = (char) (122);

                    } else if (charCode == 65) {
                        newChar[i] = (char) (90);

                    } else if (charCode >= 65 && charCode <= 122) {
                        newChar[i] = (char) (charCode - 1);

                    } else {
                        newChar[i] = (char) (charCode);

                    }

                    newText = newText + newChar[i];
                }
            }
        } else {
            newText = plainText;
        }
        //System.out.print(newText);
        return newText;
    }


    /**
     *
     * @param plainText
     * @return
     */
    public String decode(String plainText) {

        shiftDirection = 1;

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int charCode;



        if (shiftDirection > 0) {
            for (int i = 0; i < plainText.length(); i++) {

                charCode = (int) plainText.charAt(i);

                if (Character.isDigit(plainText.charAt(i))) {

                    if (Character.getNumericValue(plainText.charAt(i)) == 0) {
                        newChar[i] = '9';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))-1), 10);
                    }

                    newText = newText + newChar[i];

                } else {


                    if (charCode == 97) {
                        newChar[i] = (char) (122);

                    } else if (charCode == 65) {
                        newChar[i] = (char) (90);

                    } else if (charCode >= 65 && charCode <= 122) {
                        newChar[i] = (char) (charCode - 1);

                    } else {
                        newChar[i] = (char) (charCode);

                    }

                    newText = newText + newChar[i];
                }
            }
        } else if (shiftDirection < 0) {
            for (int i = 0; i < plainText.length(); i++) {

                charCode = (int) plainText.charAt(i);

                if (Character.isDigit(plainText.charAt(i))) {

                    if (Character.getNumericValue(plainText.charAt(i)) == 9) {
                        newChar[i] = '0';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))+1), 10);
                    }

                    newText = newText + newChar[i];

                } else {


                    if (charCode == 122) {
                        newChar[i] = (char) (97);

                    } else if (charCode == 90) {
                        newChar[i] = (char) (65);

                    } else if (charCode >= 65 && charCode <= 122) {
                        newChar[i] = (char) (charCode + 1);

                    } else {
                        newChar[i] = (char) (charCode);

                    }

                    newText = newText + newChar[i];
                }
            }
        } else {
            newText = plainText;
        }
        return newText;
    }


    /**
     *
     * @param plainText
     * @param shifts
     * @return
     */
    public String decode(String plainText, int shifts) {

        //
        shiftDirection = shifts;

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int charCode;


        //
        if (shiftDirection < 0) {
            for (int i = 0; i < plainText.length(); i++) {

                charCode = plainText.charAt(i);

                if (Character.isDigit(plainText.charAt(i))) {

                    if (Character.getNumericValue(plainText.charAt(i)) == 9) {
                        newChar[i] = '0';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))+1), 10);
                    }

                    newText = newText + newChar[i];

                } else {


                    if (charCode == 122) {
                        newChar[i] = (char) (97);

                    } else if (charCode == 90) {
                        newChar[i] = (char) (65);

                    } else if (charCode >= 65 && charCode <= 122) {
                        newChar[i] = (char) (charCode + 1);

                    } else {
                        newChar[i] = (char) (charCode);

                    }

                    newText = newText + newChar[i];
                }
            }
        } else if (shiftDirection > 0) {
            for (int i = 0; i < plainText.length(); i++) {

                charCode = (int) plainText.charAt(i);

                if (Character.isDigit(plainText.charAt(i))) {

                    if (Character.getNumericValue(plainText.charAt(i)) == 0) {
                        newChar[i] = '9';
                    } else {
                        newChar[i] = Character.forDigit((Character.getNumericValue(plainText.charAt(i))-1), 10);
                    }

                    newText = newText + newChar[i];

                } else {


                    if (charCode == 97) {
                        newChar[i] = (char) (122);

                    } else if (charCode == 65) {
                        newChar[i] = (char) (90);

                    } else if (charCode >= 65 && charCode <= 122) {
                        newChar[i] = (char) (charCode - 1);

                    } else {
                        newChar[i] = (char) (charCode);

                    }

                    newText = newText + newChar[i];
                }
            }
        } else {
            newText = plainText;
        }

        return newText;
    }


    /**
     *
     * @param text
     * @return
     */
    protected String shiftOnce (String text) {
        return encode(text);
    }

    /**
     *
     * @param text
     * @return
     */
    protected String decodeOnce (String text) {
        return decode(text);
    }

}