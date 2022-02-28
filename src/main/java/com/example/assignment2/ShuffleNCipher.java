package com.example.assignment2;

/**
 *
 */
public class ShuffleNCipher implements Cipher{
    /**
     *
     * @param shuffles
     * @param plainText
     * @param enc
     * @return
     */
    String ShuffleNCipher (int shuffles, String plainText, boolean enc) {
        String newText = plainText;

        if (enc) {
            for (int i = 0; i < Math.abs(shuffles); i++) {
                newText = encode(newText);
            }
            return newText;
        } else {
            for (int i = 0; i < Math.abs(shuffles); i++) {
                newText = decode(newText);
            }
            return newText;
        }

    }

    /**
     *
     * @param plainText
     * @return
     */
    public String encode(String plainText) {

        String newText = "";
        char[] newChar = new char[plainText.length()];
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

        return newText;
    }

    /**
     *
     * @param plainText
     * @return
     */
    public String decode(String plainText) {

        String newText = "";
        char[] firstHalf = new char[(int)Math.floor(plainText.length()/2)+1];
        char[] secondHalf = new char[((int)Math.floor(plainText.length()/2))];

        //
        int j = 0;
        int x = 0;
        int y = 0;


        for (int i = 0; i < plainText.length(); i++) {

            if (i%2 == 0) {
                firstHalf[j] = plainText.charAt(i);
                j++;
                System.out.println(1);
            } else if (i%2 != 0) {
                secondHalf[y] = plainText.charAt(i);
                y++;
                System.out.println(2);

            }

        }

        for (int i = 0; i < plainText.length(); i++) {

            if (i < firstHalf.length) {
                newText = newText + firstHalf[i];
            } else {
                newText = newText + secondHalf[x];
                x++;
            }



        }


        return newText;
    }

    /**
     *
     * @param text
     * @return
     */
    protected String shuffleOnce (String text) {
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
