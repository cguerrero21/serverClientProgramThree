import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.function.Consumer;

public class ClientGUI extends Application {

    private Label messageLabel = new Label("Messages will appear here");
    private TextField portTF = new TextField();

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox topTab = new VBox();

        Button startButton = new Button("Start Client");
        startButton.setOnAction(e -> {
            if (portTF.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please enter port in textfield.");
                alert.showAndWait();
            }else {
                startClient();
                startButton.setDisable(true);
            }
        });
        topTab.getChildren().addAll(portTF, startButton);
        root.setCenter(topTab);

        root.setStyle("-fx-background-color: #EEE8AA");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setTitle("Client GUI");
        primaryStage.show();
    }

    private void startClient() {
        int port = Integer.parseInt(portTF.getText());
        Consumer<Serializable> uiUpdater = message -> updateUI(message.toString());
        Client clientThread = new Client(port, uiUpdater);
        clientThread.start();
    }

    public void updateUI(String message) {
        messageLabel.setText(message);
    }
    public static void main(String[] args) {
        launch(args);
    }
}