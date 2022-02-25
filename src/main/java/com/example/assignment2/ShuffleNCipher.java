package com.example.assignment2;

public class ShuffleNCipher extends HelloController implements Cipher{

    int shuffleDirection = 1;

    String ShuffleNCipher (int shuffles, String plainText) {
        String newText = plainText;
        for (int i = 0; i < Math.abs(shuffles); i++) {
            newText = encode(newText, shuffles);
        }
        return newText;
    }

    public String encode(String plainText) {

        shuffleDirection = 1;

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int[] newNum = new int[plainText.length()];
        int charCode;
        char[] firstHalf = new char[(int)Math.floor(plainText.length()/2)+1];
        char[] secondHalf = new char[((int)Math.floor(plainText.length()/2))];
        int j = 0;
        int x = 0;
        int y = 0;


            for (int i = 0; i < plainText.length(); i++) {

                if (i < firstHalf.length) {
                    firstHalf[i] = plainText.charAt(i);

                } else if (i >= firstHalf.length) {
                    secondHalf[x] = plainText.charAt(i);
                    x++;
                }

            }


        for (int i = 0; i < plainText.length(); i++) {

                if (i%2 == 0) {
                    newChar[i] = firstHalf[j];
                    j++;
                    System.out.println(1);
                } else if (i%2 != 0) {
                    newChar[i] = secondHalf[y];
                    y++;
                    System.out.println(2);
                }
            newText = newText + newChar[i];
        }



        //System.out.print(newText);
        return newText;
    }

    public String encode(String plainText, int shifts) {

        shuffleDirection = shifts;

        String newText = "";
        char[] newChar = new char[plainText.length()];
        int[] firstHalf = new int[(int)Math.floor(plainText.length()/2)+1];
        int[] secondHalf = new int[((int)Math.floor(plainText.length()/2))];
        int j = 0;
        int charCode;



        if (shuffleDirection > 0) {
            for (int i = 0; i < plainText.length(); i++) {

                if (i == 0) {
                    newChar[i] = plainText.charAt(i);
                } else if (i < firstHalf.length) {
                    newChar[i] = plainText.charAt(i+i);
                } else if (i > firstHalf.length && i < plainText.length()) {
                    newChar[i] = plainText.charAt(((i-firstHalf.length)+1)+j);
                    j++;
                } else {
                    newChar[i] = plainText.charAt(i);
                }

                newText = newText + newChar[i];

            }
            j=0;



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

                    } else {
                        newChar[i] = (char) (charCode);

                    }

                    newText = newText + newChar[i];
                }
            }
        } else if (shuffleDirection < 0) {
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


    protected String shuffleOnce (String text) {
        return encode(text);
    }

}
