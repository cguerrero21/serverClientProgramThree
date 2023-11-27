import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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

    @FXML
    private void initialize(){
        category1.setOnAction(e ->{
            showNextScene();
        });
    }

    private void showNextScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/GameScenario.fxml"));
            Parent root = loader.load();

            ScenarioController controller = loader.getController();

            controller.setPrimaryStage(primaryStage);

            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
