package com.example.assignment2;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;




public class HelloController implements Initializable {

    public String publicChoice = "";

    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    public TextField inputText;

    @FXML
    public Text outputOneShiftText;

    @FXML
    public TextField inputShifts;

    @FXML
    public Text outputMultipleShiftsText;

    public String[] choices = {"Shift Cipher", "Shuffle Cipher", "Unicode Sum Cipher"};


    @FXML
    protected void onTextTyped()  {
        System.out.println(inputText.getText());
       // outputOneShiftText.setText(inputText.getText());

        ShiftNCipher nC = new ShiftNCipher();
        ShuffleNCipher fC = new ShuffleNCipher();
        if (publicChoice == "Shift Cipher") {

            setOutputText(nC.shiftOnce(getInputText()));

        } else if (publicChoice == "Shuffle Cipher") {

            setOutputText(fC.shuffleOnce(getInputText()));

        } else if (publicChoice == "Unicode Sum Cipher") {

        } else {
            setOutputText(nC.shiftOnce(getInputText()));
        }

    }

    @FXML
    protected void onShiftsTyped()  {
        System.out.println(inputShifts.getText());
        // outputOneShiftText.setText(inputText.getText());

        ShiftNCipher nC = new ShiftNCipher();

        setOutputTextTwo(nC.ShiftNCipher((Integer.parseInt(getInputTextTwo())),getInputText()));
    }

    @FXML
    public String getInputText() {
        return inputText.getText();
    }

    @FXML
    public String getInputTextTwo() {
        return inputShifts.getText();
    }

    @FXML
    public void setOutputText(String newText) {
        outputOneShiftText.setText(newText);
    }

    @FXML
    public void setOutputTextTwo (String newText) { outputMultipleShiftsText.setText(newText);}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(choices);
        myChoiceBox.setOnAction(this::getChoice);
    }

    public void getChoice(ActionEvent event) {
        String myChoice = myChoiceBox.getValue();
        publicChoice = myChoice;
        System.out.println(publicChoice);
    }

}