package sample.Hang_man;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Congratulation.Congratulation;
import sample.Loss.Loss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Hangman {

    private String[] WordVocab = {"about","always","answer","black","build","happy","run","play","complete",
    "clock" ,"family" ,"follow","give","hand","help","idea","water","large","love","number"} ;

    private String defultWord = "" ;
    private String underScore = "" ;
    private int checkUncorrect = 1 ;
    private String ans = "" ;

    private int con = 0 ;
    private int ran = 0 ;
    private int count = 0 ;


    private ArrayList<String> space = new ArrayList<>() ;
    private ArrayList<String> vocabList = new ArrayList<>() ;



    @FXML
    private Text text , correct , predict;

    @FXML
    private Text head,body,aLeft,aRight,lLeft,lRight ;

    @FXML
    private TextField vocab;

    @FXML
    private Button send , hint ;

    @FXML
    private Label show ;

    @FXML
    private TextArea textArea ;


    public void yourName(String t) {
        Random random = new Random() ;
        ran = random.nextInt(20);

        this.text.setText(t);
        defultWord = WordVocab[ran];

//        System.out.println(defultWord);

        for (int i=0 ; i<defultWord.length() ; i++ ) {
            underScore += "_ " ;
            space.add("_");
        }

        predict.setText(underScore);
    }


    @FXML
    public void hintWord(ActionEvent event) {
        textArea.setDisable(true);
        Button hint = (Button) event.getSource();
        for (int i=0 ; i<defultWord.length() ; i++ ){
            String xVocab = "" + defultWord.charAt(i) ;
            vocabList.add(xVocab) ;
        }

        Random r = new Random();
        count = r.nextInt(defultWord.length());
        show.setText(vocabList.get(count));
        hint.setDisable(true);
    }

    @FXML
    public void checkVocab(ActionEvent event) {

        int numberCheck = 0 ;


        Button send = (Button) event.getSource() ;
        String stringVocab = "" + vocab.getText() ;
        for (int i=0 ; i<defultWord.length() ; i++) {

            String stringWord = "" + defultWord.charAt(i) ;
            if (stringVocab.equals(stringWord)) {
                numberCheck += 1 ;
                stringWord = "" ;

                space.set(i,stringVocab);
            }
        }

        if (numberCheck >= 1 ) {
            correct.setFill(Color.GREEN);
            correct.setText("Correct");
//            System.out.println(space);
            predict.setText("");


            for (String s : space) {
                ans = ans + s + " " ;

            }



            for (String a : space) {
//                System.out.println(a);
                if ("_" == a) {
                    con += 1 ;
                }
            }

            predict.setText(ans);
            ans = "" ;


            if (con == 0) {
                Stage stage = (Stage) send.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Congratulation/Congratulation.fxml"));
                try {
                    stage.setScene(new Scene(loader.load(), 386, 334));

                    Congratulation controller = (Congratulation) loader.getController();



                    stage.show();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            con = 0 ;
//

        }
        else {
            correct.setFill(Color.RED);
            correct.setText("Uncorrect");
//            System.out.println(checkUncorrect);
            if (checkUncorrect == 1) {
                head.setText("O");
            }else if (checkUncorrect == 2) {
                body.setText("|");
            }else if (checkUncorrect == 3) {
                aLeft.setText("/");
            }else if (checkUncorrect == 4) {
                aRight.setText("\\") ;
            }else if (checkUncorrect == 5) {
                lLeft.setText("/");
            }else if (checkUncorrect == 6) {
                lRight.setText("\\");

                Stage stage = (Stage) send.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Loss/Loss.fxml"));
                try {
                    stage.setScene(new Scene(loader.load(), 386, 334));

                    Loss controller = (Loss) loader.getController();
                    controller.showWord('"' + defultWord + '"');

                    stage.show();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }



            }
            checkUncorrect += 1 ;
        }
        vocab.clear();


    }

}
