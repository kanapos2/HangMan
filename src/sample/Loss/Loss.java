package sample.Loss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Hang_man.Hangman;

import java.io.IOException;

public class Loss {

    @FXML
    private Button tryAgain ;

    @FXML
    private Text show ;

    @FXML
    public void showWord(String s) {
        show.setText(s) ;
    }

    @FXML
    public void setTryAgain(ActionEvent event) {
        Button tryAgain = (Button) event.getSource();
        Stage stage = (Stage) tryAgain.getScene().getWindow();

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
