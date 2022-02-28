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
 *
 */
public class HelloController implements Initializable {

    //
    public String publicChoice = "";

    //
    @FXML
    private ChoiceBox<String> myChoiceBox;

    //
    @FXML
    private Button encodeOneShift;

    //
    @FXML
    private Button encodeMultiShift;

    //
    @FXML
    public TextField inputText;

    //
    @FXML
    public Text outputOneShiftText;

    //
    @FXML
    public TextField inputShifts;

    //
    @FXML
    public Text outputMultipleShiftsText;

    //
    public String[] choices = {"Shift Cipher", "Shuffle Cipher", "Unicode Sum Cipher",
                                "Decode Shift Cipher", "Decode Shuffle Cipher", "Decode Unicode Sum Cipher"};

    /**
     *
     */
    @FXML
    protected void onTextTyped()  {
        //System.out.println(inputText.getText());

        ShiftNCipher nC = new ShiftNCipher();

        ShuffleNCipher fC = new ShuffleNCipher();

        //
        if (publicChoice == "Shift Cipher") {

            setOutputText(nC.shiftOnce(getInputText()));

        } else if (publicChoice == "Shuffle Cipher") {

            setOutputText(fC.shuffleOnce(getInputText()));

        } else if (publicChoice == "Unicode Sum Cipher") {



        } else if (publicChoice == "Decode Shift Cipher") {

            setOutputText(nC.decodeOnce(getInputText()));

        } else if (publicChoice == "Decode Shuffle Cipher") {

            setOutputText(fC.decodeOnce(getInputText()));

        } else if (publicChoice == "Decode Unicode Sum Cipher") {



        } else {

            setOutputText(nC.shiftOnce(getInputText()));

        }

    }

    /**
     *
     */
    EventHandler<ActionEvent> eventTop = new EventHandler<ActionEvent>() {
        /**
         *
         * @param e
         */
        public void handle(ActionEvent e)
        {
            //System.out.println(inputText.getText());

            ShiftNCipher nC = new ShiftNCipher();

            ShuffleNCipher fC = new ShuffleNCipher();


            //
            if (publicChoice == "Shift Cipher") {

                setOutputText(nC.shiftOnce(getInputText()));

            } else if (publicChoice == "Shuffle Cipher") {

                setOutputText(fC.shuffleOnce(getInputText()));

            } else if (publicChoice == "Unicode Sum Cipher") {



            } else if (publicChoice == "Decode Shift Cipher") {

                setOutputText(nC.decodeOnce(getInputText()));

            } else if (publicChoice == "Decode Shuffle Cipher") {

                setOutputText(fC.decodeOnce(getInputText()));

            } else if (publicChoice == "Decode Unicode Sum Cipher") {



            } else {

                setOutputText(nC.shiftOnce(getInputText()));

            }
        }
    };



    /**
     *
     */
    EventHandler<ActionEvent> eventBottom = new EventHandler<ActionEvent>() {
        /**
         *
         * @param e
         */
        public void handle(ActionEvent e)
        {

            ShiftNCipher nC = new ShiftNCipher();

            ShuffleNCipher fC = new ShuffleNCipher();

            //
            if (publicChoice == "Shift Cipher") {

                setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));

            } else if (publicChoice == "Shuffle Cipher") {

                setOutputTextTwo(fC.ShuffleNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));

            } else if (publicChoice == "Unicode Sum Cipher") {



            } else if (publicChoice == "Decode Shift Cipher") {

                setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),false));

            } else if (publicChoice == "Decode Shuffle Cipher") {

                setOutputTextTwo(fC.ShuffleNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),false));

            } else if (publicChoice == "Decode Unicode Sum Cipher") {



            } else {

                setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));        }

        }
    };

    /**
     *
     */
    @FXML
    protected void onShiftsTyped()  {
        //System.out.println(inputShifts.getText());

        ShiftNCipher nC = new ShiftNCipher();

        ShuffleNCipher fC = new ShuffleNCipher();


        //
        if (publicChoice == "Shift Cipher") {

            setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));

        } else if (publicChoice == "Shuffle Cipher") {

            setOutputTextTwo(fC.ShuffleNCipher((Integer.parseInt(getInputTextTwo())),getInputText(), true));

        } else if (publicChoice == "Unicode Sum Cipher") {



        } else if (publicChoice == "Decode Shift Cipher") {

            setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),false));

        } else if (publicChoice == "Decode Shuffle Cipher") {

            setOutputTextTwo(fC.ShuffleNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),false));

        } else if (publicChoice == "Decode Unicode Sum Cipher") {



        } else {

            setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText(),true));

        }
    }


    /**
     *
     * @return
     */
    @FXML
    public String getInputText() {
        return inputText.getText();
    }

    /**
     *
     * @return
     */
    @FXML
    public String getInputTextTwo() {
        return inputShifts.getText();
    }

    /**
     *
     * @param newText
     */
    @FXML
    public void setOutputText(String newText) {
        outputOneShiftText.setText(newText);
    }

    /**
     *
     * @param newText
     */
    @FXML
    public void setOutputTextTwo (String newText) { outputMultipleShiftsText.setText(newText);}

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(choices);
        myChoiceBox.setOnAction(this::getChoice);
        encodeOneShift.setOnAction(eventTop);
        encodeMultiShift.setOnAction(eventBottom);
    }

    /**
     *
     * @param event
     */
    public void getChoice(ActionEvent event) {
        String myChoice = myChoiceBox.getValue();
        publicChoice = myChoice;
        //System.out.println(publicChoice);
    }

}