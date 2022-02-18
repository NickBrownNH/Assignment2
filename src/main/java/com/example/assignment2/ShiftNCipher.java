package com.example.assignment2;

public class ShiftNCipher implements Cipher{



    private int shifts;

    //add constructors

    public String encode(String plainText) {

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int[] newNum = new int[plainText.length()];
        int charCode;

        for (int i = 0; i < plainText.length(); i++) {

            charCode = (int)plainText.charAt(i);

            if(Character.isDigit(plainText.charAt(i))) {

                if(plainText.charAt(i) == '0') {
                    newChar[i] = '9';
                } else if (plainText.charAt(i) == '9') {
                    newChar[i] = '0';
                } else {
                    newChar[i]++;
                }

                newText = newText + newChar[i];

            } else {


                if (charCode == 97) {
                    newChar[i] = (char) (122);

                } else if (charCode == 122) {
                    newChar[i] = (char) (97);

                } else if (charCode == 64) {
                    newChar[i] = (char) (90);

                } else if (charCode == 90) {
                    newChar[i] = (char) (65);

                } else {
                    newChar[i] = (char) (charCode + 1);

                }

                newText = newText + newChar[i];
            }
        }

        //System.out.print(newText);
        return newText;
    }

    private String shiftOnce (String text) {
        return encode(text);
    }
}
