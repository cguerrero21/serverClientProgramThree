import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.function.Consumer;

public class ClientGUI extends Application {

        private Label messageLabel = new Label("Messages will appear here");
        private TextField portTF = new TextField();

        public void start(Stage primaryStage) {

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
