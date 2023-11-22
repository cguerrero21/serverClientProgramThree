import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Stack;
import java.util.function.Consumer;

public class Client extends Thread{

    Socket socketClient;

    ObjectOutputStream out;
    ObjectInputStream in;

    private Consumer<Serializable> callback;
    private Stage primaryStage;

    Client(Consumer<Serializable> call){

        callback = call;
    }

    public void run() {

        try {
            socketClient= new Socket("127.0.0.1",5555);
            out = new ObjectOutputStream(socketClient.getOutputStream());
            in = new ObjectInputStream(socketClient.getInputStream());
            socketClient.setTcpNoDelay(true);
        }
        catch(Exception e) {}

        while(true) {

            try {
                String message = in.readObject().toString();
                callback.accept(message);
            }
            catch(Exception e) {}
        }

    }

    public void send(String data) {

        try {
            out.writeObject(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        // This is the main method for the Client class.
//        // You can create an instance of the Client class and start it here.
//        Client client = new Client(message -> {
//            // Callback logic if needed
//            System.out.println("Callback: " + message);
//        });
//        client.start();
//    }


}
