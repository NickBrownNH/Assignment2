package com.example.assignment2;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;



public class HelloController implements Initializable {
    @FXML
    private TextField inputText;

    @FXML
    private TextField inputNumber;

    @FXML
    public TextField getInputNumber() {
        return inputNumber;
    }

    @FXML
    public TextField getInputText() {
        System.out.println(inputNumber);
        return inputNumber;
    }


    @FXML
    protected void onTextTyped()  {
        System.out.println(inputNumber);
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.onTextTyped();

    }

    public void Main(String[] args) {
        onTextTyped();
    }


}