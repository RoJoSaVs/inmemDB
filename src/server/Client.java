package server;

import GUI.Contenedor_de_esquemas;
import GUI.Esquema;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client {

    /**
     *
     * @param ip
     * @param port
     * @param json
     * @throws IOException
     */
    public void SendMessage(String ip, int port, String json) throws IOException {
        Socket socket = new Socket(ip, port);
        DataOutputStream outcomming = new DataOutputStream(socket.getOutputStream());
        outcomming.writeUTF(json);
        outcomming.close();
    }

    /**
     *
     * @param server serversocket
     * @throws IOException
     */
    public void listen(ServerSocket server) throws IOException {
        boolean running = true;

        Socket socket;
        socket = server.accept();

        while (running){
            DataInputStream incomming = new DataInputStream(socket.getInputStream());

            String message;
            message = incomming.readUTF();
            if (message == "ended"){
                running = false;
                break;
            } else {
                System.out.println("Recibi el mensaje");
                socket.close();

                JsonCreator jsonCreator = new JsonCreator();
                ArrayList<Esquema> nueva_memoria = new ArrayList<>();
                JsonToSend data = jsonCreator.unSerializer(message);
                Esquema nuevoEsquema = new Esquema();
                nuevoEsquema.ftotal = data.getG_parafilas();
                nuevoEsquema.g_paracolumnas = data.getG_paracolumnas();
                nuevoEsquema.g_conteo = data.getG_conteo();
                nuevoEsquema.g_titulo = data.getG_titulo();
                nuevoEsquema.tipos = data.getTipos();
                nueva_memoria.add(nuevoEsquema);
                Contenedor_de_esquemas.setLista_de_esquemas(nueva_memoria);
                System.out.println("El cliente recibio el mensaje y seteo lo debido");
            }

        }

    }

    /**
     *
     * @return the ip of the client
     * @throws UnknownHostException
     */
    public static String getIp() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String ip = inetAddress.getHostAddress();
        return ip;
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