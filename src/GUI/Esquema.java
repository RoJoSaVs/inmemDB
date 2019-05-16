package GUI;

import Logic.AA.AA;
import Logic.AA.AA_container;
import Logic.AVL.AVLTree;
import Logic.B_Tree.B_tree;
import Logic.BinaryTree.BinaryTree;
import Logic.List.LinkedList;
import Logic.RedBlack.RedBlackTree;
import Logic.Splay.SplayTree;
import server.JsonCreator;
import server.JsonToSend;
import server.Server;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Esquema extends JFrame {

    public String obtener = " ";
    public String dato;
    public int aumento = 0;
    public int indice = 0;

    public JLabel eliminar,agregar, modificar = new JLabel();

    public ArrayList<String> filas = new ArrayList<String>();
    public ArrayList<ArrayList> lista_de_filas = new ArrayList<ArrayList>();
    public ArrayList<ArrayList<String>> g_parafilas;
    public ArrayList<String> tipos = new ArrayList<String>();
    public ArrayList<String> agregard = new ArrayList<String>();
    public ArrayList<ArrayList<String>> todasfilas = new ArrayList<ArrayList<String>>();
    public String[] estructuras={"AA","AVL","B","Binario","Lista","Rojo-Negro","Splay"};
    public ArrayList<Object[]> Lista_de_columnas = null;

    private static String[] ftotal = null;
    private static String[] fauxiliar = null;
    private static String[] ftodas = null;

    //Guarda las entradas del método Esquema2
    public Object[] g_paracolumnas;
    public String g_titulo;
    public int g_conteo;
    public String tipo;

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
        JButton b7 = new JButton("BORRAR");//////////////////

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

        b6.setBounds(630,280,100,25);//////////////////
        b6.setBackground(Color.decode("#3B006A"));///////////////////
        b6.setForeground(Color.decode("#B76EF1"));

        b7.setBounds(270,280,100,25);//////////////////
        b7.setBackground(Color.decode("#3B006A"));///////////////////
        b7.setForeground(Color.decode("#B76EF1"));

        escoger_estructuras.setBounds(520,280,100,25);;//(400,280,100,25);//////////////////
        escoger_estructuras.setBackground(Color.decode("#3B006A"));///////////////////
        escoger_estructuras.setForeground(Color.decode("#B76EF1"));
        crear_indice.setSelectedIndex(-1);

        combo.setBounds(20,220,100,25);
        combo.setBackground(Color.decode("#3B006A"));
        combo.setForeground(Color.decode("#B76EF1"));
        combo.setSelectedIndex(-1);

        crear_indice.setBounds(400,280,100,25);///////////////
        crear_indice.setBackground(Color.decode("#3B006A"));/////////////////
        crear_indice.setForeground(Color.decode("#B76EF1"));
        crear_indice.setSelectedIndex(-1);

        Object[] fila = new Object[1];
        Object[] filast = new Object[1];

        //SECCION DE ACCIONES PARA LOS BOTONES REQUERIDOS
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(filas);
                tipo = tipos.get(combo.getSelectedIndex());

                //VALIDACIÓN DEL TIPO INT
                if (tipo == "int"){
                    try {
                        dato = texto1.getText();
                        Integer.parseInt(dato);

                        obtener = texto1.getText();
                        filas.add(obtener);
                        aumento++;
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
                    }
                    catch (Exception E){
                    }
                }
            }
        });

        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //COPIAR TODO LO DE ESTE BOTÓN DESDE AQUÍ
                filas.add(" ");
                ftotal = filas.subList(indice*paracolumnas.length+indice,filas.size()-1).toArray
                        (new String[filas.subList(indice*paracolumnas.length+indice,filas.size()-1).size()]);

                //La comparación se hace entre la cantidad de columnas creadas y los datos agregados a columnas
                if (aumento == paracolumnas.length) {
                    for (int i = 0; i > aumento ; i++) {
                        fila[i] = ftotal[i];
                    }
                    modelo.addRow(ftotal);
                    aumento=0;
                    indice++;
                }
                //HASTA AQUÍ, LO DEMÁS QUEDA IGUAL
                else {
                    UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                    UIManager.put("OptionPane.background", Color.decode("#060734"));
                    UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                    UIManager.put("Panel.background", Color.decode("#060734"));
                    JOptionPane.showMessageDialog(b1, "Faltan agregar datos en columnas");
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DEBEN AGREGAR TODO LO DE ESTE BOTON YA QUE ES NUEVO
                for (int ii = 0; ii < filas.size(); ii++){
                    ftotal = filas.subList(ii*paracolumnas.length+ii,filas.size()-1).toArray
                            (new String[filas.subList(ii*paracolumnas.length+ii,filas.size()-1).size()]);
                    Object[] o = ftotal;
                    modelo.addRow(o);
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        b5.addActionListener(new ActionListener() {/////////////////////////
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JsonCreator jsonCreator = new JsonCreator();
                    ArrayList<JsonToSend> listaDeEsquemas = jsonCreator.separadorDeEsquemas(Contenedor_de_esquemas.getLista_de_esquemas());
                    for (JsonToSend i: listaDeEsquemas){
                        String json = jsonCreator.serializer(i);
                        Main.getClient().SendMessage(Server.getServerIp(), Server.getPortClientSend(), json);
                        System.out.println(json);
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String por_buscar =texto_busqueda.getText();
                int numero_de_columna=crear_indice.getSelectedIndex();
                Object[] busqueda_sobre_esta_columna=Lista_de_columnas.get(numero_de_columna);
                boolean habia_algo=false;
                for(Object i: busqueda_sobre_esta_columna){
                    if(i!=null){
                        habia_algo=true;
                        if (i instanceof AA){
                            AA_container contenedor_del_valor=new AA_container();

                            ((AA) i).existe(por_buscar,contenedor_del_valor);
                            if(contenedor_del_valor.value_del_nodo!=null){
                                JOptionPane.showMessageDialog(null,(lista_de_filas.get((Integer) contenedor_del_valor.value_del_nodo)).toString());
                                System.out.println(lista_de_filas.get((Integer) contenedor_del_valor.value_del_nodo));
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"no se encontró ");
                            }

                        }
                        if (i instanceof AVLTree){
                            Integer resultado = (Integer) ((AVLTree) i).search(por_buscar);
                            if(resultado!=null) {
                                JOptionPane.showMessageDialog(null, lista_de_filas.get(resultado).toString());
                                System.out.println(lista_de_filas.get(resultado));
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"no se encontró ");
                            }

                        }
                        if (i instanceof B_tree){
                            Integer resultado = (Integer) ((B_tree) i).get(por_buscar);
                            if(resultado!=null) {
                                JOptionPane.showMessageDialog(null, lista_de_filas.get(resultado).toString());
                                System.out.println(lista_de_filas.get(resultado));
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"no se encontró ");
                            }
                        }
                        if (i instanceof BinaryTree){
                            Integer resultado = (Integer) ((BinaryTree) i).containsNode(por_buscar, 0).value;
                            if(resultado!=null) {
                                JOptionPane.showMessageDialog(null, lista_de_filas.get(resultado).toString());
                                System.out.println(lista_de_filas.get(resultado));
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"no se encontró ");
                            }
                        }
                        if (i instanceof LinkedList){
                            Integer resultado = (Integer) ((LinkedList) i).find(por_buscar);
                            if(resultado!=null) {
                                JOptionPane.showMessageDialog(null, lista_de_filas.get(resultado).toString());
                                System.out.println(lista_de_filas.get(resultado));
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"no se encontró ");
                            }
                        }
                        if (i instanceof RedBlackTree){
                            Integer resultado = (Integer) ((RedBlackTree) i).buscar(por_buscar);
                            if(resultado!=null) {
                                JOptionPane.showMessageDialog(null, lista_de_filas.get(resultado).toString());
                                System.out.println(lista_de_filas.get(resultado));
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"no se encontró ");
                            }
                        }
                        if (i instanceof SplayTree){
                            Integer resultado = (Integer) ((SplayTree) i).searchTree(por_buscar,0).value;
                            if(resultado!=null) {
                                JOptionPane.showMessageDialog(null, lista_de_filas.get(resultado).toString());
                                System.out.println(lista_de_filas.get(resultado));
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"no se encontró");
                            }
                        }

                    }
                }
                if(habia_algo==false){
                    JOptionPane.showMessageDialog(null,"No se encontró ninguna estructura en esta columna");
                }
            }
        });
        b6.addActionListener(new ActionListener() {////////////////////////////////
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Lista_de_columnas==null){
                    for(Object i:paracolumnas){
                        Lista_de_columnas=new ArrayList<Object[]>();
                        Object[] lista_de_estructuras_sobre_una_columna={null,null,null,null,null,null,null};
                        Lista_de_columnas.add(lista_de_estructuras_sobre_una_columna);
                    }
                }
                int indice=escoger_estructuras.getSelectedIndex();
                int cont_para_por_meter_a_arbol=0;
                int numero_de_columna=crear_indice.getSelectedIndex();
                ArrayList<String> por_meter_a_arbol=new ArrayList<String>();
                ArrayList<String> tmp=new ArrayList<String>();
                if(lista_de_filas.isEmpty()) {
                    for (String i : filas) {
                        if (!i.equals(" ")) {
                            tmp.add(i);
                        }
                        else {
                            lista_de_filas.add(tmp);
                            tmp = new ArrayList<String>();
                        }
                    }
                }
                for(String i:filas){
                    if(cont_para_por_meter_a_arbol==numero_de_columna){
                        por_meter_a_arbol.add(i);
                    }
                    if(i.equals(" ")){
                        cont_para_por_meter_a_arbol=-1;//deberia reiniciar el contador, es -1 para que cuando se le suma 1 se reinicie
                    }
                    cont_para_por_meter_a_arbol+=1;
                }
                //meter en los arboles
                if(indice==0){//AA
                    AA<String, Integer> indice_AA = new AA<>();//el string es el elemento a buscar, el Integer es un indice de la lista lista_de_filas que indica en cual fila esta el elemento
                    int cont_para_meter_en_arbol=0;
                    for(String i:por_meter_a_arbol){
                        indice_AA.insertar(i,cont_para_meter_en_arbol);
                        cont_para_meter_en_arbol+=1;
                    }
                    Lista_de_columnas.get(numero_de_columna)[0]=indice_AA;
                }
                if(indice==1){//AVL
                    AVLTree<String, Integer> indice_AVL = new AVLTree<>();//el string es el elemento a buscar, el Integer es un indice de la lista lista_de_filas que indica en cual fila esta el elemento
                    int cont_para_meter_en_arbol=0;
                    for(String i:por_meter_a_arbol){
                        indice_AVL.insert(i,cont_para_meter_en_arbol);
                        cont_para_meter_en_arbol+=1;
                    }
                    Lista_de_columnas.get(numero_de_columna)[indice]=indice_AVL;
                }
                if(indice==2) {//B
                    B_tree<String, Integer> indice_B = new B_tree<>();//el string es el elemento a buscar, el Integer es un indice de la lista lista_de_filas que indica en cual fila esta el elemento
                    int cont_para_meter_en_arbol=0;
                    for(String i:por_meter_a_arbol){
                        indice_B.put(i,cont_para_meter_en_arbol);
                        cont_para_meter_en_arbol+=1;
                    }
                    Lista_de_columnas.get(numero_de_columna)[indice]=indice_B;
                }
                if(indice==3){//binario
                    BinaryTree<String, Integer> indice_Binario = new BinaryTree<>();//el string es el elemento a buscar, el Integer es un indice de la lista lista_de_filas que indica en cual fila esta el elemento
                    int cont_para_meter_en_arbol=0;
                    for(String i:por_meter_a_arbol){
                        indice_Binario.add(i,cont_para_meter_en_arbol);
                        cont_para_meter_en_arbol+=1;
                    }
                    Lista_de_columnas.get(numero_de_columna)[indice]=indice_Binario;
                }
                if(indice==4){//lista
                    LinkedList<String, Integer> indice_lista = new LinkedList<>();//el string es el elemento a buscar, el Integer es un indice de la lista lista_de_filas que indica en cual fila esta el elemento
                    int cont_para_meter_en_arbol=0;
                    for(String i:por_meter_a_arbol){
                        indice_lista.addLast(i,cont_para_meter_en_arbol);
                        cont_para_meter_en_arbol+=1;
                    }
                    Lista_de_columnas.get(numero_de_columna)[indice]=indice_lista;
                }
                if(indice==5){//Rojo-negro
                    RedBlackTree<String, Integer> indice_Red_black = new RedBlackTree<>();//el string es el elemento a buscar, el Integer es un indice de la lista lista_de_filas que indica en cual fila esta el elemento
                    int cont_para_meter_en_arbol=0;
                    for(String i:por_meter_a_arbol){
                        indice_Red_black.insert(i,cont_para_meter_en_arbol);
                        cont_para_meter_en_arbol+=1;
                    }
                    Lista_de_columnas.get(numero_de_columna)[indice]=indice_Red_black;
                }
                if(indice==6){//splay
                    SplayTree<String, Integer> indice_splay = new SplayTree<>();//el string es el elemento a buscar, el Integer es un indice de la lista lista_de_filas que indica en cual fila esta el elemento
                    int cont_para_meter_en_arbol=0;
                    for(String i:por_meter_a_arbol){
                        indice_splay.insert(i,cont_para_meter_en_arbol);
                        cont_para_meter_en_arbol+=1;
                    }
                    Lista_de_columnas.get(numero_de_columna)[indice]=indice_splay;
                }
            }

        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice=escoger_estructuras.getSelectedIndex();
                int numero_de_columna=crear_indice.getSelectedIndex();
                Lista_de_columnas.get(numero_de_columna)[indice]=null;

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
        frame.add(b7);
        frame.add(escoger_estructuras);


        frame.setSize(900,400);
        frame.getContentPane().setBackground(Color.decode("#060734"));
        frame.setTitle(titulo);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}