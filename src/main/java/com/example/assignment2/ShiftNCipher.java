package com.example.assignment2;

public class ShiftNCipher implements Cipher{



    private int shifts;

    //add constructors

    public String encode(String plainText) {

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int charCode;

        for (int i = 0; i < plainText.length(); i++) {
            charCode = (int)plainText.charAt(i);
            newChar[i] = (char)(charCode+1);
            newText = newText + newChar[i];
        }

        //System.out.print(newText);
        return newText;
    }

    private String shiftOnce (String text) {
        return "";
    }

}
