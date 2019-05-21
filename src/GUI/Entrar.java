package GUI;
import server.JsonCreator;
import server.JsonToSend;
import server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Entrar extends JFrame{

    JLabel titulo = new JLabel();
    JButton crear = new JButton();
    JComboBox opciones = new JComboBox();
    JButton recibir_JSON = new JButton();
    JButton enviar_JSON = new JButton();


    public void Entrar(){

        //TÍTULO DE VENTANA ENTRAR
        titulo = new JLabel("InmenDB");
        titulo.setBackground(Color.decode("#515285"));
        titulo.setForeground(Color.decode("#DC3318"));
        titulo.setFont(new Font("verdana", Font.BOLD, 20));
        titulo.setBounds(140, 20, 200, 30);
        add(titulo);


        //BOTÓN PARA CREAR ESQUEMA
        crear = new JButton("CREAR");
        crear.setBackground(Color.decode("#3B006A"));
        crear.setForeground(Color.decode("#B76EF1"));
        crear.setBounds(140, 60, 100, 20);
        crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ventana es = new Ventana();
                es.Ventana();
                System.out.println(Contenedor_de_esquemas.lista_de_esquemas);
                dispose();
            }});
        add(crear);

        //BOTÓN PARA RECIBIR ESQUEMA
        recibir_JSON = new JButton("RECIBIR");
        recibir_JSON.setBackground(Color.decode("#3B006A"));
        recibir_JSON.setForeground(Color.decode("#B76EF1"));
        recibir_JSON.setBounds(210, 140, 100, 20);
        recibir_JSON.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.getClient().listen(Main.getServerSocket());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println(Contenedor_de_esquemas.lista_de_esquemas);
                Entrar E = new Entrar();
                E.Entrar();
                dispose();
            }});
        add(recibir_JSON);

        //BOTÓN PARA ENVIAR ESQUEMA
        enviar_JSON = new JButton("ENVIAR");
        enviar_JSON.setBackground(Color.decode("#3B006A"));
        enviar_JSON.setForeground(Color.decode("#B76EF1"));
        enviar_JSON.setBounds(100, 140, 100, 20);
        enviar_JSON.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JsonCreator jsonCreator = new JsonCreator();
                    ArrayList<JsonToSend> listaDeEsquemas = jsonCreator.separadorDeEsquemas(Contenedor_de_esquemas.getLista_de_esquemas());
                    for (JsonToSend i: listaDeEsquemas){
                        String json = jsonCreator.serializer(i);
                        Main.getClient().SendMessage(Server.getServerIp(), Server.getPortClientSend(), json);
                        System.out.println(json);
                    }
                    Main.getClient().SendMessage(Server.getServerIp(), Server.getPortClientSend(), "ended");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }});
        add(enviar_JSON);

        //OPCIONES DE ESQUEMAS CREADOS
        opciones = new JComboBox();
        opciones.setBounds(170, 90, 50, 30);
        opciones.setBackground(Color.decode("#3B006A"));
        opciones.setForeground(Color.decode("#B76EF1"));
        for(Esquema i:Contenedor_de_esquemas.lista_de_esquemas){
            opciones.addItem(i.g_titulo);
        }
        opciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado= (String) opciones.getSelectedItem();
                for(Esquema i:Contenedor_de_esquemas.lista_de_esquemas){
                    if(i.g_titulo.equals(seleccionado)){
                        i.Esquema2(i.g_paracolumnas,i.g_parafilas,i.g_titulo,i.g_conteo);
                        System.out.println(i.g_parafilas);
                        break;
                    }
                }
            }
        });
        add(opciones);

        setLayout(null);
        setSize(400, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#060734"));
        setVisible(true);
    }

}