package GUI;

import server.JsonCreator;
import server.Server;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Esquema extends JFrame {

    String obtener = " ";
    String dato;
    int aumento = -1;

    JLabel eliminar,agregar, modifciar = new JLabel();

    ArrayList<String> filas = new ArrayList<String>();
    ArrayList<ArrayList<String>> todasfilas = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> g_parafilas = new ArrayList<ArrayList<String>>();
    ArrayList<String> tipos = new ArrayList<String>();
    String[] estructuras={"AA","AVL","B","Binario","Lista","Rojo-Negro","Splay"};

    private static String[] ftotal = null;
    private static String[] ftodas = null;

    //Guarda las entradas del método Esquema2
    Object[] g_paracolumnas;
    String g_titulo;
    int g_conteo;
    String tipo;

    // Constructor
    public void Esquema2(Object[] paracolumnas,ArrayList<ArrayList<String>> parafilas, String titulo, int conteo)
    {
        JFrame frame = new JFrame(titulo);
        JTable esquema = new JTable();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(paracolumnas);
        esquema.setModel(modelo);

        esquema.setBackground(Color.decode("#80837F"));
        esquema.setForeground(Color.blue);
        Font font = new Font("", 1,22);
        esquema.setFont(font);
        esquema.setRowHeight(30);

        JTextField texto1 = new JTextField();
        JTextField texto_busqueda = new JTextField();//////////////////////////////

        JComboBox combo = new JComboBox(paracolumnas);
        JComboBox crear_indice = new JComboBox(paracolumnas);//////////////////////////
        JComboBox escoger_estructuras =new JComboBox(estructuras);

        JButton b1 = new JButton("AGREGAR");
        JButton b2 = new JButton("FILA");
        JButton b3 = new JButton("ELIMINAR");
        JButton b4 = new JButton("MOSTRAR");
        JButton b5 = new JButton("BUSCAR");//////////////////////
        JButton b6 = new JButton("CREAR INDICE");//////////////////

        texto1.setBounds(150,220,100,25);
        texto1.setBackground(Color.decode("#3B006A"));
        texto1.setForeground(Color.decode("#B76EF1"));

        texto_busqueda.setBounds(20,280,100,25);////////////
        texto_busqueda.setBackground(Color.decode("#3B006A"));////////
        texto_busqueda.setForeground(Color.decode("#B76EF1"));////////////

        b1.setBounds(270,220,100,25);
        b1.setBackground(Color.decode("#3B006A"));
        b1.setForeground(Color.decode("#B76EF1"));

        b2.setBounds(400,220,100,25);
        b2.setBackground(Color.decode("#3B006A"));
        b2.setForeground(Color.decode("#B76EF1"));

        b3.setBounds(520,220,100,25);
        b3.setBackground(Color.decode("#3B006A"));
        b3.setForeground(Color.decode("#B76EF1"));

        b4.setBounds(630,220,100,25);
        b4.setBackground(Color.decode("#3B006A"));
        b4.setForeground(Color.decode("#B76EF1"));

        b5.setBounds(150,280,100,25);/////////////
        b5.setBackground(Color.decode("#3B006A"));/////////
        b5.setForeground(Color.decode("#B76EF1"));

        b6.setBounds(520,280,100,25);//////////////////
        b6.setBackground(Color.decode("#3B006A"));///////////////////
        b6.setForeground(Color.decode("#B76EF1"));

        escoger_estructuras.setBounds(400,280,100,25);//////////////////
        escoger_estructuras.setBackground(Color.decode("#3B006A"));///////////////////
        escoger_estructuras.setForeground(Color.decode("#B76EF1"));

        combo.setBounds(20,220,100,25);
        combo.setBackground(Color.decode("#3B006A"));
        combo.setForeground(Color.decode("#B76EF1"));
        combo.setSelectedIndex(-1);

        crear_indice.setBounds(270,280,100,25);///////////////
        crear_indice.setBackground(Color.decode("#3B006A"));/////////////////
        crear_indice.setForeground(Color.decode("#B76EF1"));
        crear_indice.setSelectedIndex(-1);

        Object[] fila = new Object[1];
        Object[] filast = new Object[1];

        //SECCION DE ACCIONES PARA LOS BOTONES REQUERIDOS
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //tipo = tipos[combo.getSelectedIndex()];
                tipo = tipos.get(combo.getSelectedIndex());
                System.out.println(tipo);

                //VALIDACIÓN DEL TIPO INT
                if (tipo == "int"){
                    try {
                        dato = texto1.getText();
                        Integer.parseInt(dato);

                        obtener = texto1.getText();
                        filas.add(obtener);
                        aumento++;
                        System.out.println(aumento);
                    }
                    catch (Exception E){
                        UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                        UIManager.put("OptionPane.background", Color.decode("#060734"));
                        UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                        UIManager.put("Panel.background", Color.decode("#060734"));
                        JOptionPane.showMessageDialog(b1, "Se esparaba un int en la columna  " + paracolumnas[combo.getSelectedIndex()]);
                    }
                }

                //VALIDACIÓN DEL TIPO FLOAT
                if (tipo == "float"){
                    try {
                        dato = texto1.getText();
                        Float.parseFloat(dato);

                        obtener = texto1.getText();
                        filas.add(obtener);
                        aumento++;
                        System.out.println(aumento);
                    }
                    catch (Exception E){
                        UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                        UIManager.put("OptionPane.background", Color.decode("#060734"));
                        UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                        UIManager.put("Panel.background", Color.decode("#060734"));
                        JOptionPane.showMessageDialog(b1, "Se esparaba un float en la columna  " + paracolumnas[combo.getSelectedIndex()]);
                    }
                }

                //VALIDACIÓN DEL TIPO LONG
                if (tipo == "long"){
                    try {
                        dato = texto1.getText();
                        Long.parseLong(dato);

                        obtener = texto1.getText();
                        filas.add(obtener);
                        aumento++;
                        System.out.println(aumento);
                    }
                    catch (Exception E){
                        UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                        UIManager.put("OptionPane.background", Color.decode("#060734"));
                        UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                        UIManager.put("Panel.background", Color.decode("#060734"));
                        JOptionPane.showMessageDialog(b1, "Se esparaba un long en la columna  " + paracolumnas[combo.getSelectedIndex()]);
                    }
                }

                //VALIDACIÓN DEL TIPO DOUBLE
                if (tipo == "double"){
                    try {
                        dato = texto1.getText();
                        Double.parseDouble(dato);

                        obtener = texto1.getText();
                        filas.add(obtener);
                        aumento++;
                        System.out.println(aumento);
                    }
                    catch (Exception E){
                        UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                        UIManager.put("OptionPane.background", Color.decode("#060734"));
                        UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                        UIManager.put("Panel.background", Color.decode("#060734"));
                        JOptionPane.showMessageDialog(b1, "Se esparaba un double en la columna  " + paracolumnas[combo.getSelectedIndex()]);
                    }
                }

                //VALIDACIÓN DEL TIPO STRING
                if (tipo == "string"){
                    try {
                        obtener = texto1.getText();
                        filas.add(obtener);
                        aumento++;
                        System.out.println(aumento);
                    }
                    catch (Exception E){
                    }
                }
            }
        });

        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(combo.getSelectedIndex());
                System.out.println(combo.getSelectedItem());
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ftotal = filas.toArray(new String[filas.size()]);
                //La comparación se hace entre la cantidad de columnas creadas y los datos agregados a columnas
                if (aumento != paracolumnas.length) {
                    for (int i = 0; i > aumento ; i++) {
                        fila[i] = ftotal[i];
                    }
                    modelo.addRow(ftotal);
                    todasfilas.add(filas);
                }
                else {
                    UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                    UIManager.put("OptionPane.background", Color.decode("#060734"));
                    UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                    UIManager.put("Panel.background", Color.decode("#060734"));
                    JOptionPane.showMessageDialog(b1, "Faltan agregar datos en columnas");
                }
                System.out.println(filas);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(esquema.getSelectedRow());
                int fila = esquema.getSelectedRow();
                if (fila >=0){
                    modelo.removeRow(fila);
                    aumento--;
                }
                else{
                    UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                    UIManager.put("OptionPane.background", Color.decode("#060734"));
                    UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                    UIManager.put("Panel.background", Color.decode("#060734"));
                    JOptionPane.showMessageDialog(b1, "Seleccione un fila para eliminar");
                }
            }
       });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(todasfilas);
                System.out.println(todasfilas.size());
                int a = 0;
                for (int i = 0; i < todasfilas.size(); i++){
                    ftodas =  todasfilas.get(i).toArray(new String[todasfilas.get(i).size()]);
                    Object[] o = todasfilas.get(i).toArray();
                    modelo.addRow(o);
                }
            }
        });

        b5.addActionListener(new ActionListener() {/////////////////////////
            @Override
            public void actionPerformed(ActionEvent e) {
                String por_buscar =texto_busqueda.getText();
                String tipo_del_dato_por_buscar=Logic.get_data_type.get_type(por_buscar);


                try {
                    JsonCreator jsonCreator = new JsonCreator();
                    String json = jsonCreator.serializer(Contenedor_de_esquemas.getLista_de_esquemas());

                    Main.getClient().SendMessage(Server.getServerIp(), Server.getPortClientSend(), json);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if( tipo_del_dato_por_buscar.equals("string")){
                    //llama binario de string
                }
                else{
                    //llama binario normal
                }
            }
        });
        b6.addActionListener(new ActionListener() {////////////////////////////////
            String prueba[]={"das","ds"};//este array no es necesario, solo es lo que se supone que se va a meter en la estructura
            /*indices del escoger_estructuras:
            AA=0
            AVL=1
            B=2
            Binario=3
            Lista=4
            Rojo-Negro=5
            Splay=6
             */
            public void actionPerformed(ActionEvent e) {
                int indice=escoger_estructuras.getSelectedIndex();
                System.out.println(escoger_estructuras.getSelectedIndex());
                if(indice==0){
                   if(Logic.get_data_type.get_type(prueba[0])=="string"){
                       //llamar AA string
                   }
                   else{
                       //llamar AA
                   }
                }
                if(indice==1){
                    if(Logic.get_data_type.get_type(prueba[0])=="string"){
                        //llamar AVL string
                    }
                    else{
                        //llamar AVL
                    }
                }
                if(indice==2){
                    if(Logic.get_data_type.get_type(prueba[0])=="string"){
                        //llamar B string
                    }
                    else{
                        //llamar B string binario

                    }
                }
                if(indice==3){
                    if(Logic.get_data_type.get_type(prueba[0])=="string"){
                        //llamar Binario string
                    }
                    else{
                        //llamar binario
                        if(Logic.get_data_type.get_type(prueba[0])=="int"){


                        }

                    }
                }
                if(indice==4){
                    if(Logic.get_data_type.get_type(prueba[0])=="string"){
                        //llamar Lista string
                    }
                    else{
                        //llamar Lista
                    }
                }
                if(indice==5){
                    if(Logic.get_data_type.get_type(prueba[0])=="string"){
                        //llamar Rojo-negro string
                    }
                    else{
                        //llamar Rojo-negro
                    }
                }
                if(indice==6){
                    if(Logic.get_data_type.get_type(prueba[0])=="string"){
                        //llamar Splay string
                    }
                    else{
                        //llamar Splay
                    }
                }
            }
        });

        JScrollPane pane = new JScrollPane(esquema);
        pane.setBounds(0,0,880,200);

        frame.setLayout(null);
        frame.add(pane);
        frame.add(crear_indice);
        frame.add(combo);
        frame.add(texto1);
        frame.add(texto_busqueda);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(escoger_estructuras);


        frame.setSize(900,400);
        frame.getContentPane().setBackground(Color.decode("#060734"));
        frame.setTitle(titulo);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}