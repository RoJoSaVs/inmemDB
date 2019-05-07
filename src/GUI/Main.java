package GUI;

import server.Client;
import server.Server;

import javax.swing.JLabel;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Main {
    private static Client client = new Client();
    private static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(8081);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client getClient() {
        return client;
    }

    public static void main(String[] args) throws IOException {
       Entrar E = new Entrar();
       E.Entrar();



       client.SendMessage(Server.getServerIp(), 8000, client.getIp());
       client.listen(serverSocket);


    }
}
