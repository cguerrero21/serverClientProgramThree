import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ScenarioController {

    @FXML
    private Label attempts;
    @FXML
    private Label char1;
    @FXML
    private Label char2;
    @FXML
    private Label char3;
    @FXML
    private Label char4;
    @FXML
    private HBox charBox;
    @FXML
    private TextField charGuess;
    @FXML
    private Button guess;
    @FXML
    private Label letGuess;
    @FXML
    private Label text1;
    @FXML
    private Label tries;
    private Stage primaryStage;

    int wordGuesses = 3;
    int charGuesses = 6;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    private String word = "Java";
    private StringBuilder guessedWord = new StringBuilder("    ");

    public void initialize(){
        updateLabels();
        guess.setOnAction(e ->{
            guessButtonClicked();
        });
    }
    private void guessButtonClicked() {
        String guess = charGuess.getText().toUpperCase(); // Convert to uppercase for case-insensitivity

        if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
            updateGuessedWord(guess.charAt(0));
            updateLabels();
        }else{
            charGuesses = charGuesses - 1;
        }
        updateLabels();
        charGuess.clear();
    }
    private void updateGuessedWord(char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toUpperCase(word.charAt(i)) == Character.toUpperCase(guess)) {
                guessedWord.setCharAt(i, guess);
            }
        }
    }
    private void updateLabels() {
        char1.setText(String.valueOf(guessedWord.charAt(0)));
        char2.setText(String.valueOf(guessedWord.charAt(1)));
        char3.setText(String.valueOf(guessedWord.charAt(2)));
        char4.setText(String.valueOf(guessedWord.charAt(3)));

        tries.setText("Remaining Guesses: " + charGuesses);
    }

}
