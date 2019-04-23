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

        ServerSocket serverSocket = new ServerSocket(8081);


        Client client = new Client();
        client.SendMessage("172.18.191.247", 8000, "hola");
        client.listen(serverSocket);

        Client client1 = new Client();
        client1.SendMessage("172.18.191.247", 8000, "adios perra");
        client1.listen(serverSocket);

        Client client2 = new Client();
        client2.SendMessage("192.168.13.111", 8000, "bye bye");
        client2.listen(serverSocket);




    }
}
