package sample.Login;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Hang_man.Hangman;

import java.io.IOException;

public class Username {

    @FXML
    protected Button start ;

    @FXML
    protected TextField username;


    @FXML
    public void startHangman(ActionEvent event) {
        Button start = (Button) event.getSource();
        Stage stage = (Stage) start.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Hang_man/HangMan.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 386, 334));

            Hangman controller = (Hangman) loader.getController();
            controller.yourName(username.getText());


            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
