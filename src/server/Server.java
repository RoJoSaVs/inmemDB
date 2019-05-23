package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ArrayList<String> ips = new ArrayList<>();
    private ArrayList<Integer> ports = new ArrayList<>();

    public ArrayList<Integer> getPorts() {
        return ports;
    }



    private boolean enviar = true;
    private static String serverIp = "192.168.43.77";
    private static int portClientSend = 8001;
    private static int getPortClientHear = 8083;

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
        ServerSocket serverSocket = new ServerSocket(8001);
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
        if (message.startsWith("192") || message.startsWith("127")){
            ArrayList<String> adresses = split(message);
            ips.add(adresses.get(0));
            ports.add(new Integer(adresses.get(1)));
            System.out.println(ips);
            System.out.println(ports);
        } else {
            int cont = 0;
            for (String ip: ips){
                SendMessage(ip, ports.get(cont), message);
                System.out.println("El server recibio el mensaje y lo envio a " + ip + "al puerto" + ports.get(cont));
                cont += 1;
            }
        }
    }

    public ArrayList<java.lang.String> split(String message){
        String ip;
        String port;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < message.length(); i++){
            char letter = message.charAt(i);
            if (letter == ','){
                ip = message.substring(0, i);
                port = message.substring(i+1);
                list.add(ip);
                list.add(port);
            }
        }
        return list;

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