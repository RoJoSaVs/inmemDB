package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        String[] ips = new String[3];
        ips[0] = "192.168.100.12";
        ips[1] = "192.168.100.11";
        ips[2] = "192.168.100.13";
        while (true) {
            listen(serverSocket);
            for (String i: ips){
                SendMessage(i, 8081, "grr");
            }
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