import javafx.application.Application;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            //create server socekt
            ServerSocket serverSocket = new ServerSocket(4000);
            //accept and create new socket
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String message = dataInputStream.readUTF();
            System.out.println(message);
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
