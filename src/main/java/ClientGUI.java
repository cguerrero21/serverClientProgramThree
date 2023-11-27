import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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

import java.io.IOException;
import java.io.Serializable;
import java.util.function.Consumer;

public class ClientGUI extends Application {
        private Stage primaryStage;
        public void start(Stage primaryStage) {
                this.primaryStage = primaryStage;
                showInitialScene();
        }
        private void showInitialScene() {
                try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/port.fxml"));
                        Parent root = loader.load();

                        PortController controller = loader.getController();

                        controller.setPrimaryStage(primaryStage);

                        primaryStage.setScene(new Scene(root));
                        primaryStage.show();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        public static void main(String[] args) {
            launch(args);
        }
}
