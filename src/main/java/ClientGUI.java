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
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.function.Consumer;

public class ClientGUI extends Application {

    private Label messageLabel = new Label("Messages will appear here");
    private TextField portTF = new TextField();
    private Scene rules;
    public void start(Stage primaryStage) {
        Label label = new Label("Please insert your port number");
        BorderPane root = new BorderPane();
        VBox topTab = new VBox();

        createRules();

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
                primaryStage.setScene(rules);
            }
        });
        topTab.getChildren().addAll(label, portTF, startButton);
        topTab.setAlignment(Pos.CENTER);
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

    private void createRules(){
        BorderPane rulesRoot = new BorderPane();
        VBox holder = new VBox();
        Button accept = new Button("Accept");
        accept.setPrefSize(150, 50);
        Label header = new Label("RULES");
        header.setFont(new Font(40));
        Label rules1 = new Label("Welcome to our word guessing game.\nThe rules are fairly simple.\n" +
                "To win you have to guess words from three different categories.\n " +
                "Within each category you have a total of three attempts to guess a word.\n" +
                "If you do not guess a word in the category in three attempts its Game Over!\n" +
                "Within each word you have a total of 6 guesses before you fail.\n " +
                "Correct guesses do not count towards your 6 guesses.\n" +
                "To win you need to correctly guess one word in each category!\n" +
                "GOOD LUCK AND HAVE FUN!");
        rules1.setFont(new Font(20));
        rules1.setAlignment(Pos.CENTER);
        holder.setAlignment(Pos.CENTER);
        holder.getChildren().addAll(header, rules1, accept);
        rulesRoot.setCenter(holder);
        rulesRoot.setStyle("-fx-background-color: #EEE8AA");
        rules = new Scene(rulesRoot, 700, 500);
    }
}