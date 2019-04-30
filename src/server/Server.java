package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Server {

    private ArrayList<String> ips = new ArrayList<>();
    private boolean enviar = true;
    private static String serverIp = "192.168.100.8";

    public static String getServerIp() {
        return serverIp;
    }

    /**
     * runs the server
     * @throws IOException
     */
    private void run() throws IOException{
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            listen(serverSocket);
        }
    }

    /**
     * let the server to listen for messages
     * @param server serversocket
     * @throws IOException
     */
    private void listen(ServerSocket server) throws IOException {
        Socket socket;
        socket = server.accept();

        DataInputStream incomming = new DataInputStream(socket.getInputStream());

        String message;
        message = incomming.readUTF();
        System.out.println(message);

        if (message.startsWith("192")){
            ips.add(message);
        }
        socket.close();
    }

    /**
     *
     * @param ip
     * @param port
     * @param json
     * @throws IOException
     */
    private void SendMessage(String ip, int port, String json) throws IOException {
        Socket socket = new Socket(ip, port);
        DataOutputStream outcomming = new DataOutputStream(socket.getOutputStream());
        outcomming.writeUTF(json);
        outcomming.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
//        while (true) {
//            listen(serverSocket);
//            for (String i: ips){
//                SendMessage("192.168.100.11", 8081, "https://stackoverflow.com/questions/3403909/get-generic-type-of-class-at-runtime");
//                //SendMessage("192.168.100.12", 8081, "https://stackoverflow.com/questions/3403909/get-generic-type-of-class-at-runtime");
//                SendMessage("192.168.100.13", 8081, "https://stackoverflow.com/questions/3403909/get-generic-type-of-class-at-runtime");
//            }
//        }
//    }

    }
}