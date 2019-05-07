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
    private static int portClientSend = 8000;
    private static int getPortClientHear = 8081;

    public static int getPortClientSend() {
        return portClientSend;
    }

    public static int getGetPortClientHear() {
        return getPortClientHear;
    }

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

        checkIp(message);

        socket.close();
    }

    /**
     * Checks if the message is an IP so it can be added to the Ip's list
     * and that's how the Server manages the clients.
     * @param message
     */
    public void checkIp(String message) throws IOException {
        if (message.startsWith("192")){
            ips.add(message);
            System.out.println(ips.toString());
        } else {
            JsonCreator jsonCreator = new JsonCreator();
            String[][] data = jsonCreator.unSerializer(message);
        }
    }

    /**
     *sends a message
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
    }
}