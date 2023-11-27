import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
