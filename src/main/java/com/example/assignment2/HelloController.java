package com.example.assignment2;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;




public class HelloController implements Initializable {
    @FXML
    public TextField inputText;

    @FXML
    public Text outputOneShiftText;

    @FXML
    public TextField inputShifts;

    @FXML
    public Text outputMultipleShiftsText;

    @FXML
    protected void onTextTyped()  {
        System.out.println(inputText.getText());
       // outputOneShiftText.setText(inputText.getText());

        ShiftNCipher nC = new ShiftNCipher();

        setOutputText(nC.encode(getInputText()));
    }

    @FXML
    protected void onShiftsTyped()  {
        System.out.println(inputShifts.getText());
        // outputOneShiftText.setText(inputText.getText());

        ShiftNCipher nC = new ShiftNCipher();

        setOutputTextTwo(nC.ShiftNCipher(Character.getNumericValue(getInputTextTwo().charAt(0)),getInputText()));
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

    }


}