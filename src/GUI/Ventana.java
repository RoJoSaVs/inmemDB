package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.UIManager;

public class Ventana extends JFrame {

    //COMPONENTES
    static JTextField esquema_nombre, columna_nombre;
    static JComboBox seleccion_tipo;
    static JButton agregar_esquema, agregar_c, mostrar_tabla, regresar = new JButton();
    JLabel fondo, titulo, esquema, columna, combo_tipo = new JLabel();

    //VARAIABLES DE CONTROL
    private static  int contador = 0;
    private static String texto,esquema_titulo,tipo = " ";

    //ARREGLOS
    String tipos[] = {"int", "string","float","long","double","join"};

    private static String[] paracolumnas = null;
    private static String[] tiposv = null;

    public static String[] getParacolumnas() {
        return paracolumnas;
    }

    ArrayList<String> columnas = new ArrayList<String>();
    ArrayList<String> tiposva = new ArrayList<String>();
    public ArrayList<ArrayList<String>> parafilas = new ArrayList<ArrayList<String>>();

    //VARIABLE QUE CONTIENE EL ESQUEMA
    public Esquema E;

    public void Ventana () {

        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        //TÍTULO DE LA APLICACIÓN
        titulo = new JLabel("BASE   DE    DATOS  NoSQL");
        titulo.setFont(new Font("verdana", Font.BOLD, 20));
        titulo.setBackground(Color.decode("#515285"));
        titulo.setForeground(Color.decode("#DC3318"));
        titulo.setBounds(80, 10, 500, 30);
        add(titulo);

        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        //ESQUEMA
        esquema = new JLabel("ESQUEMA");
        esquema.setBackground(Color.decode("#515285"));
        esquema.setForeground(Color.decode("#DC3318"));
        esquema.setBounds(20, 50, 60, 10);
        add(esquema);

        //ESPACIO PARA EL NOMBRE DEL ESQUEMA
        esquema_nombre = new JTextField("Ingresar", 16);
        esquema_nombre.setBackground(Color.decode("#B76EF1"));
        esquema_nombre.setBounds(100, 50, 70, 20);
        add(esquema_nombre);

        //BOTÓN PARA AGREGAR TÍTULO DEL ESQUEMA
        agregar_esquema = new JButton("CREAR");
        agregar_esquema.setBackground(Color.decode("#3B006A"));
        agregar_esquema.setForeground(Color.decode("#B76EF1"));
        agregar_esquema.setBounds(190, 50, 100, 20);
        agregar_esquema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                E= new Esquema();
                Contenedor_de_esquemas.lista_de_esquemas.add(E);
                esquema_titulo = esquema_nombre.getText();
            }
        });
        add(agregar_esquema);

        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        //COLUMNAS
        columna = new JLabel("COLUMNA");
        columna.setBackground(Color.decode("#515285"));
        columna.setForeground(Color.decode("#DC3318"));
        columna.setBounds(20, 110, 200, 10);
        add(columna);

        //ESPACIO PARA EL NOMBRE DE LA COLUMNA
        columna_nombre = new JTextField("Agregar", 16);
        columna_nombre.setBackground(Color.decode("#B76EF1"));
        columna_nombre.setBounds(100, 110, 70, 20);
        add(columna_nombre);

        //BOTÓN PARA AGREGAR COLUMNA
        agregar_c = new JButton("AÑADIR");
        agregar_c.setBackground(Color.decode("#3B006A"));
        agregar_c.setForeground(Color.decode("#B76EF1"));
        agregar_c.setBounds(280, 110, 100, 20);
        agregar_c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                texto = columna_nombre.getText();

                //Validar que el dato que se este agregando sea diferente de null
                if (tipo == " "){
                    System.out.println("Favor agregar un dato válido");
                    UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                    UIManager.put("OptionPane.background", Color.decode("#060734"));
                    UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                    UIManager.put("Panel.background", Color.decode("#060734"));
                    JOptionPane.showMessageDialog(agregar_c, "Favor agregar un dato válido");
                    contador = 0;
                }
                else{
                    //Agregar valores a listas
                    columnas.add(texto);
                    tiposva.add(tipo);
                    //Contador para el aumento de filas
                    contador++;
                }

                //Creación de los array para columnas y tipos de varaibles de cada una
                paracolumnas = columnas.toArray(new String[columnas.size()]);
                tiposv = tiposva.toArray(new String[tiposva.size()]);

                //Monitoreo de las variables
                System.out.println(columnas + "   " + contador + "   " + tiposva);
            }
        });
        add(agregar_c);

        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //****************************************************************************************

        //TIPO
        combo_tipo = new JLabel("TIPO");
        combo_tipo.setBackground(Color.decode("#515285"));
        combo_tipo.setForeground(Color.decode("#DC3318"));
        combo_tipo.setBounds(210, 90, 200, 10);
        add(combo_tipo);

        //SELECCIÓN DEL TIPO DE DATO A GUARDAR
        seleccion_tipo = new JComboBox(tipos);
        seleccion_tipo.setBackground(Color.decode("#B76EF1"));
        seleccion_tipo.setSelectedIndex(-1);
        seleccion_tipo.setBounds(200, 110, 50, 30);
        seleccion_tipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(seleccion_tipo.getSelectedItem().toString());
                tipo = seleccion_tipo.getSelectedItem().toString();
            }
        });
        add(seleccion_tipo);

        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        mostrar_tabla = new JButton("MOSTRAR ESQUEMA CREADO");
        mostrar_tabla.setBackground(Color.decode("#3B006A"));
        mostrar_tabla.setForeground(Color.decode("#B76EF1"));
        mostrar_tabla.setBounds(120, 170, 240, 20);
        mostrar_tabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esquema_titulo == null){
                    UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                    UIManager.put("OptionPane.background", Color.decode("#060734"));
                    UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                    UIManager.put("Panel.background", Color.decode("#060734"));
                    JOptionPane.showMessageDialog(agregar_c, "Favor agregar un título al esquema");
                }
                else {
                    if (paracolumnas == null) {
                        UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                        UIManager.put("OptionPane.background", Color.decode("#060734"));
                        UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                        UIManager.put("Panel.background", Color.decode("#060734"));
                        JOptionPane.showMessageDialog(agregar_c, "Favor agregar una columna");
                    }
                    else {
                        Esquema E = new Esquema();// NO SE ESTA MOSTRANDO EL ESQUEMA, SINO QUE SE ESTA CREANDO UNO NUEVO
                        E.Esquema2(paracolumnas, parafilas, esquema_titulo, contador);
                        E.g_paracolumnas = paracolumnas;
                        E.g_parafilas = E.todasfilas;
                        E.g_titulo = esquema_titulo;
                        E.tipos = tiposva;
                        E.g_conteo = contador;
                        System.out.println(Contenedor_de_esquemas.lista_de_esquemas.size());
                    }
                }
            }
        });
        add(mostrar_tabla);

        regresar = new JButton("REGRESAR");
        regresar.setBackground(Color.decode("#3B006A"));
        regresar.setForeground(Color.decode("#B76EF1"));
        regresar.setBounds(120, 220, 240, 20);
        regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("PRESIONADO");
                System.out.println(esquema_titulo);
                Entrar E = new Entrar();
                E.Entrar();
                dispose();
            }
        });
        add(regresar);

        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        //FONDO DE LA APLICACIÓN
        fondo = new JLabel();
        fondo.setOpaque(true);
        fondo.setBackground(Color.decode("#060734"));
        fondo.setBounds(0, 0, 500, 300);
        add(fondo);

        setLayout(null);
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setVisible(true);
    }
}

