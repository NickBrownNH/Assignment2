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


    protected String shuffleOnce (String text) {
        return encode(text);
    }

}
