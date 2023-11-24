import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClientGUI extends Application {

    private Label messageLabel = new Label("Messages will appear here");
    private TextField portTF = new TextField();

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        HBox topTab = new HBox();

        Button startButton = new Button("Start Client");
        startButton.setOnAction(e -> startClient());
        topTab.getChildren().addAll(portTF, startButton);
        root.setTop(topTab);
        root.setCenter(messageLabel);

        root.setStyle("-fx-background-color: #EEE8AA");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setTitle("Client GUI");
        primaryStage.show();
    }

    private void startClient() {
        int port = Integer.parseInt(portTF.getText());
        Client clientThread = new Client(port, messageLabel);
        clientThread.start();
    }

    public void updateUI(String message) {
        messageLabel.setText(message);
    }
    public static void main(String[] args) {
        launch(args);
    }
}