package sample.Congratulation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Hang_man.Hangman;

import java.io.IOException;

public class Congratulation {

    @FXML
    private Button newGame ;

    @FXML
    public void Newgame(ActionEvent event) {
        Button newGame = (Button) event.getSource() ;
        Stage stage = (Stage) newGame.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Hang_man/HangMan.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 386, 334));

            Hangman controller = (Hangman) loader.getController();
            controller.yourName("");


            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
