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
        ArrayList<Esquema> nueva_memoria = new ArrayList<>();

       // while (running){
            DataInputStream incomming = new DataInputStream(socket.getInputStream());
            String message;
            message = incomming.readUTF();

        if (message == "ended"){
                running = false;
                //break;
            } else {
                System.out.println("Recibi el mensaje");

                JsonCreator jsonCreator = new JsonCreator();
                JsonToSend data = jsonCreator.unSerializer(message);
                Esquema nuevoEsquema = new Esquema();
                nuevoEsquema.filas = data.getG_parafilas();
                nuevoEsquema.g_paracolumnas = data.getG_paracolumnas();
                nuevoEsquema.g_conteo = data.getG_conteo();
                nuevoEsquema.g_titulo = data.getG_titulo();
                nuevoEsquema.tipos = data.getTipos();
                for(Esquema i: Contenedor_de_esquemas.getLista_de_esquemas()){
                    if(i.g_titulo.equals(nuevoEsquema.g_titulo)){
                        Contenedor_de_esquemas.getLista_de_esquemas().remove(i);
                        break;
                    }
                }
                Contenedor_de_esquemas.getLista_de_esquemas().add(nuevoEsquema);
                //Contenedor_de_esquemas.setLista_de_esquemas(nueva_memoria);
                System.out.println("El cliente recibio el mensaje y seteo lo debido");




        }

        //}
        socket.close();

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
    }
}