package com.example.assignment2;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Button;


/**
 * @author Nick Brown
 * @date 2/28/2022
 *
 * This class puts together all of the other classes and FXML code into one concise class,
 * which allows the user to interact with the Cipher classes and their inputs.
 *
 *
 * Expected Values For All Testing
 *
 * 1 shift:
 *
 * Aibohphobia   --->   Bjcpiqipcjb
 * Hello, World!!   --->   Ifmmp, Xpsme!!
 * Was it a cat I saw?   --->   Xbt ju b dbu J tbx?
 * A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!   --->
 *
 *
 * 3 shifts:
 *
 * Aibohphobia   --->   Dlerkskreld
 * Hello, World!!   --->   Khoor, Zruog!!
 * Was it a cat I saw?   --->   Zdv lw d fdw L vdz?
 * A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!   --->
 *
 *
 * 6 shifts:
 *
 * Aibohphobia   --->   Gohunvnuhog
 * Hello, World!!   --->   Nkrru, Cuxrj!!
 * Was it a cat I saw?   --->   Cgy oz g igz O ygc?
 * A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!   --->
 *
 *
 * -2 shifts:
 *
 * Aibohphobia   --->  Ygzmfnfmzgy
 * Hello, World!!   --->   Fcjjm, Umpjb!!
 * Was it a cat I saw?   --->   Uyq gr y ayr G qyu?
 * A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!   --->
 *
 *
 *
 *
 * 1 shuffle:
 *
 * Aibohphobia   --->   Ahiobboihap
 * Hello, World!!   --->   HWeolrllod,! !
 * Was it a cat I saw?   --->   Waats  li ts aaw ?c
 * A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!   --->
 *
 *
 * 3 shuffles:
 *
 * Aibohphobia   --->   Aooahbipibh
 * Hello, World!!   --->   H,llW!ore dlo!
 * Was it a cat I saw?   --->   W twa s al ?tiacs a
 * A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!   --->
 *
 *
 * 6 shuffles:
 *
 * Aibohphobia   --->   Apahiobboih
 * Hello, World!!   --->   H!dlroW ,olle
 * Was it a cat I saw?   --->   Wt   wca isa?aslta
 * A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!   --->
 *
 *
 * -2 shuffles:
 *
 * Aibohphobia   --->   Aohiihoabpb
 * Hello, World!!   --->   HlWoedo,l!r l!
 * Was it a cat I saw?   --->   Wtasa tasa w  l?ic
 * A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!   --->
 *
 *
 *
 *
 *
 */
public class HelloController implements Initializable {

    public String publicChoice = "";

    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private Button encodeOneShift;

    @FXML
    private Button encodeMultiShift;

    @FXML
    public TextField inputText;

    @FXML
    public Text outputOneShiftText;

    @FXML
    public TextField inputShifts;

    @FXML
    public Text outputMultipleShiftsText;

    public String[] choices = {"Shift Cipher", "Shuffle Cipher", "Decode Shift Cipher", "Decode Shuffle Cipher"};

    /**
     * This is a method that gets called when ever anyone presses enter after clicking
     * on the Text Field inputText. It gets what cipher or cipher decoder was selected
     * and then displays the translated text that was encoded or decoded once.
     */
    @FXML
    protected void onTextTyped()  {

        ShiftNCipher nC = new ShiftNCipher();

        ShuffleNCipher fC = new ShuffleNCipher();

        //gets the ChoiceBox's value and sets the encoding or decoding method to be printed out on screen
        if (publicChoice == "Shift Cipher") {

            setOutputText(nC.shiftOnce(getInputText()));

        } else if (publicChoice == "Shuffle Cipher") {

            setOutputText(fC.shuffleOnce(getInputText()));

        }  else if (publicChoice == "Decode Shift Cipher") {

            setOutputText(nC.decodeOnce(getInputText()));

        } else if (publicChoice == "Decode Shuffle Cipher") {

            setOutputText(fC.decodeOnce(getInputText()));

        } else {    //If none are selected then it defaults to encoding by using the ShiftNCipher and displays it

            setOutputText(nC.shiftOnce(getInputText()));

        }

    }

    /**
     * This is the Event Handler for the top button that holds the method that gets what cipher or cipher
     * decoder that was selected and then sets it so that the input gets translated into the desired text.
     */
    EventHandler<ActionEvent> eventTop = new EventHandler<ActionEvent>() {

        /**
         * The handle method gets what cipher or cipher decoder was selected
         * and then sets it so that the input gets translated into the desired text.
         *
         * @param e is the ActionEvent that is connected to the first encode button
         */
        public void handle(ActionEvent e)
        {

            ShiftNCipher nC = new ShiftNCipher();

            ShuffleNCipher fC = new ShuffleNCipher();


            //gets the ChoiceBox's value and sets the encoding or decoding method to be printed out on screen
            if (publicChoice == "Shift Cipher") {

                setOutputText(nC.shiftOnce(getInputText()));

            } else if (publicChoice == "Shuffle Cipher") {

                setOutputText(fC.shuffleOnce(getInputText()));

            }  else if (publicChoice == "Decode Shift Cipher") {

                setOutputText(nC.decodeOnce(getInputText()));

            } else if (publicChoice == "Decode Shuffle Cipher") {

                setOutputText(fC.decodeOnce(getInputText()));

            } else {    //If none are selected then it defaults to encoding by using the ShiftNCipher and displays it

                setOutputText(nC.shiftOnce(getInputText()));

            }
        }
    };



    /**
     * This is the Event Handler for the bottom button that holds the method that gets what cipher or cipher
     * decoder that was selected and then sets it so that the input gets translated into the desired text.
     */
    EventHandler<ActionEvent> eventBottom = new EventHandler<ActionEvent>() {

        /**
         * The handle method gets what cipher or cipher decoder was selected
         * and then sets it so that the input gets translated into the desired text.
         *
         * @param e is the ActionEvent that is connected to the second encode button
         */
        public void handle(ActionEvent e)
        {

            ShiftNCipher nC = new ShiftNCipher();

            ShuffleNCipher fC = new ShuffleNCipher();

            //gets the ChoiceBox's value and sets the encoding or decoding method to be printed out on screen
            if (publicChoice == "Shift Cipher") {

                setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));

            } else if (publicChoice == "Shuffle Cipher") {

                setOutputTextTwo(fC.ShuffleNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));

            } else if (publicChoice == "Decode Shift Cipher") {

                setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),false));

            } else if (publicChoice == "Decode Shuffle Cipher") {

                setOutputTextTwo(fC.ShuffleNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),false));

            } else {    //If none are selected then it defaults to encoding by using the ShiftNCipher and displays it

                setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));
            }

        }
    };

    /**
     * This is a method that gets called when ever anyone presses enter after clicking
     * on the Text Field inputShifts. It gets what cipher or cipher decoder was selected
     * and then displays the inputText that's been encoded or decoded the number of times
     * that was specified in TextField inputShifts.
     */
    @FXML
    protected void onShiftsTyped()  {

        ShiftNCipher nC = new ShiftNCipher();

        ShuffleNCipher fC = new ShuffleNCipher();


        //gets the ChoiceBox's value and sets the encoding or decoding method to be printed out on screen
        if (publicChoice == "Shift Cipher") {

            setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));

        } else if (publicChoice == "Shuffle Cipher") {

            setOutputTextTwo(fC.ShuffleNCipher((Integer.parseInt(getInputTextTwo())),getInputText(), true));

        } else if (publicChoice == "Decode Shift Cipher") {

            setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),false));

        } else if (publicChoice == "Decode Shuffle Cipher") {

            setOutputTextTwo(fC.ShuffleNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),false));

        } else {    //If none are selected then it defaults to encoding by using the ShiftNCipher and displays it

            setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));

        }
    }


    /**
     * This method gets the text that has been typed in the first textField.
     *
     * @return  the text that has been typed in TextField inputText
     */
    @FXML
    public String getInputText() {
        return inputText.getText();
    }

    /**
     * This method gets the text that has been typed in the second textField.
     *
     * @return  the text that has been typed in the TextField inputShifts
     */
    @FXML
    public String getInputTextTwo() {
        return inputShifts.getText();
    }

    /**
     * This method takes the newText and displays it on the first text object
     * that displays the once encoded or decoded string.
     *
     * @param newText   is a variable that holds the new translated text
     */
    @FXML
    public void setOutputText(String newText) {
        outputOneShiftText.setText(newText);
    }

    /**
     * This method takes the newText and displays it on the second text object
     * that displays the string that has been encoded or decoded a number of times
     * defined by the user.
     *
     * @param newText   is a variable that holds the new translated text
     */
    @FXML
    public void setOutputTextTwo (String newText) { outputMultipleShiftsText.setText(newText);}

    /**
     * This method is here to Initialize some basic stuff for the JavaFX portion
     * of this project. This just consists of setting up the ChoiceBox.
     *
     * @param url               This is a basic variable that initialize uses, but I don't know what for
     * @param resourceBundle    This is a basic variable that initialize uses, but I don't know what for
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(choices);
        myChoiceBox.setOnAction(this::getChoice);
        encodeOneShift.setOnAction(eventTop);
        encodeMultiShift.setOnAction(eventBottom);
    }

    /**
     * The getChoice method gets the choice selected in the choice box and sets the
     * publicChoice variable equal to the ChoiceBox value.
     *
     * @param event is the ActionEvent that is connected to the ChoiceBox and activates when a
     *              choice has been selected.
     */
    public void getChoice(ActionEvent event) {
        String myChoice = myChoiceBox.getValue();
        publicChoice = myChoice;
    }

}