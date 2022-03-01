package com.example.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Nick Brown
 * @date 2/28/2022
 *
 *
 * The HelloApplication Class sets up and launches the window
 * and all the JavaFX connected to it.
 */
public class HelloApplication extends Application {

    /**
     * This method holds the code that sets up the FXML loader and scene.
     * It also sets the window's size and title.
     *
     * @param stage         is the variable that sets where the window should be projected to
     * @throws IOException  if there is something that doesn't allow the window to run
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Encoder: Cipher Creator");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * The main method only stands to launch the window.
     *
     * @param args  is a basic variable placeholder that isn't used for any functionality
     */
    public static void main(String[] args) {
        launch();
    }

}