import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Stack;
import java.util.function.Consumer;

public class Client extends Thread {
    Socket socketClient;
    ObjectOutputStream out;
    ObjectInputStream in;
    private Consumer<Serializable> callback;
    private int port;
    Client(int port, Consumer<Serializable> call){
        this.port = port;
        callback = call;
    }
    @Override
    public void run() {
        try {
            socketClient= new Socket("127.0.0.1",port);
            out = new ObjectOutputStream(socketClient.getOutputStream());
            in = new ObjectInputStream(socketClient.getInputStream());
            socketClient.setTcpNoDelay(true);
        } catch(IOException e) {
            System.out.println("Server is not available. Shutting down client.");
            return;
        }

        while(true) {
            try {
                String message = in.readObject().toString();
                callback.accept(message);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void send(String data) {

        try {
            out.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
