import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RulesController {
    @FXML
    private Button accept;
    @FXML
    private Label line1;
    @FXML
    private Label line2;
    @FXML
    private Label line3;
    @FXML
    private Label line4;
    @FXML
    private Label line5;
    @FXML
    private Label line6;
    @FXML
    private Label line7;
    @FXML
    private Label line8;
    @FXML
    private Label rules;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @FXML
    private void initialize(){
        accept.setOnAction(e ->{
            showNextScene();
        });
    }
    private void showNextScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/categories.fxml"));
            Parent root = loader.load();

            CategoryController controller = loader.getController();

            controller.setPrimaryStage(primaryStage);

            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
