package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            listen(serverSocket);
            SendMessage("localhost", 8081, "gudbai");
        }

    }

    private void listen(ServerSocket server) throws IOException {
        Socket socket;
        socket = server.accept();

        DataInputStream incomming = new DataInputStream(socket.getInputStream());

        String message;
        message = incomming.readUTF();
        System.out.println(message);
        socket.close();
    }

    private void SendMessage(String ip, int port, String json) throws IOException {
        Socket socket = new Socket(ip, port);
        DataOutputStream outcomming = new DataOutputStream(socket.getOutputStream());
        outcomming.writeUTF(json);
        outcomming.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();

    }
}