package com.example.assignment2;

public class ShiftNCipher extends HelloController implements Cipher{
    int shiftDirection = 1;

    String ShiftNCipher (int shifts, String plainText) {
        String newText = plainText;
        for (int i = 0; i < Math.abs(shifts); i++) {
            newText = encode(newText, shifts);
        }
        return newText;
    }

    public String encode(String plainText) {

        shiftDirection = 1;

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int[] newNum = new int[plainText.length()];
        int charCode;



        if (shiftDirection > 0) {
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

    public String encode(String plainText, int shifts) {

        shiftDirection = shifts;

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int[] newNum = new int[plainText.length()];
        int charCode;



        if (shiftDirection > 0) {
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


    protected String shiftOnce (String text) {
        return encode(text);
    }
}