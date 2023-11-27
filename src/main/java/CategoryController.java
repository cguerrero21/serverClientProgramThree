import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CategoryController {

    @FXML
    private Label catLab;

    @FXML
    private Button category1;

    @FXML
    private Button category2;

    @FXML
    private Button category3;

    @FXML
    private Label text1;

    @FXML
    private Label text2;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

}
