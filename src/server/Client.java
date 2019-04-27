package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    private void SendMessage(String ip, int port, String json) throws IOException {
        Socket socket = new Socket(ip, port);
        DataOutputStream outcomming = new DataOutputStream(socket.getOutputStream());
        outcomming.writeUTF(json);
        outcomming.close();
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

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8082);

        Client client = new Client();
        client.SendMessage("192.168.100.8", 8000, "VIVA EL GUARO");
        client.SendMessage("192.168.100.8", 8000, "VIVAN LAS PUTAS");
        client.listen(serverSocket);
    }

}
