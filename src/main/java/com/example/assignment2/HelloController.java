package com.example.assignment2;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;



public class HelloController implements Initializable {
    @FXML
    public TextField inputText;

    @FXML
    public Text outputOneShiftText;


    @FXML
    protected void onTextTyped()  {
        System.out.println(inputText.getText());
        outputOneShiftText.setText(inputText.getText());
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}