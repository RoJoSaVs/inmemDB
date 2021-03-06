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

    public static ServerSocket getServerSocket() {
        return serverSocket;
    }

    static {
        try {
            serverSocket = new ServerSocket(Server.getGetPortClientHear());
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

        String port = Integer.toString(Server.getGetPortClientHear());
        client.SendMessage(Server.getServerIp(), Server.getPortClientSend(), (client.getIp() + "," + port));
        System.out.println(Client.getIp() + port);


    }
}
