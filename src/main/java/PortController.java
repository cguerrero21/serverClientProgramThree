import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.function.Consumer;

public class PortController {
    @FXML
    private Button accept;
    @FXML
    private Label instruction;
    @FXML
    private TextField portTF;
    private Stage primaryStage;

    @FXML
    private void initialize(){
        accept.setOnAction(e ->{
            if (portTF.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please enter port in textfield.");
                alert.showAndWait();
            }else {
                startClient();
                accept.setDisable(true);
            }
        });
    }
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void startClient() {
        int port = Integer.parseInt(portTF.getText());
        Consumer<Serializable> uiUpdater = message -> updateUI(message.toString());
        Client clientThread = new Client(port, uiUpdater);
        clientThread.start();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/rules.fxml"));
            Parent root = loader.load();

            Scene newScene = new Scene(root);

            primaryStage.setScene(newScene);

            RulesController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateUI(String message) {

    }
}
