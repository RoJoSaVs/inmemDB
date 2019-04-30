package GUI;


import javax.swing.*;
import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;


public class Ventana extends JFrame {

    //COMPONENTES
    static JTextField esquema_nombre, columna_nombre,llavenombre,valornombre, seleccion_atributo;

    static JComboBox seleccion_tipo;

    static JButton agregar_esquema, agregar_c, agregar_t, mostrar_tabla = new JButton();

    JLabel fondo, titulo, esquema, columna, combo_tipo, item, llave, valor = new JLabel();


    public static JTable[] tablas = new JTable[1];

    static JTable tabla = new JTable();


    //VARAIABLES DE CONTROL
    private static  int contador,indice = 0;
    private static String texto,esquema_titulo,tipo, llavevalor, valorvalor, llavejson, valorjson, parajson,pos = " ";

    //VARIABLES PARA EL CONTROL DE TIPOS DE DATOS DE CADA COLUMNA
    private static int dato1 = 0;
    private static double dato2  = 0;
    private static float dato3  =0;
    private static long dato4 = 0;
    private static String dato5 = "";

    //ARREGLOS
    String tipos[] = {"int", "string","float","long","double","join"};
    String espacio = " ";
    private static String vacio[] = {};

    private static String[] paracolumnas = null;
    private static String[] parafilas = null;
    private static String[] contenedor = null;
    private static String[] opciones = null;
    private static String[] tiposv = null;

    ArrayList<String> columnas = new ArrayList<String>();
    ArrayList<String> filas = new ArrayList<String>();
    ArrayList<String> tiposva = new ArrayList<String>();



    public void Ventana () {



        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        //TÍTULO DE LA APLICACIÓN
        titulo = new JLabel("BASE   DE    DATOS  NoSQL");
        titulo.setBackground(Color.decode("#515285"));
        titulo.setForeground(Color.decode("#FB802F"));
        titulo.setBounds(180, 10, 200, 10);
        add(titulo);



        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        //ESQUEMA
        esquema = new JLabel("ESQUEMA");
        esquema.setBackground(Color.decode("#515285"));
        esquema.setForeground(Color.decode("#FB802F"));
        esquema.setBounds(20, 50, 60, 10);
        add(esquema);

        //ESPACIO PARA EL NOMBRE DEL ESQUEMA
        esquema_nombre = new JTextField("Ingresar", 16);
        esquema_nombre.setBackground(Color.decode("#FB802F"));
        esquema_nombre.setBounds(100, 50, 70, 20);
        add(esquema_nombre);

        //BOTÓN PARA AGREGAR TÍTULO DEL ESQUEMA
        agregar_esquema = new JButton("CREAR");
        agregar_esquema.setBackground(Color.decode("#1CE92B"));
        agregar_esquema.setBounds(190, 50, 100, 20);
        agregar_esquema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                esquema_titulo = esquema_nombre.getText();
                System.out.println(esquema_titulo);
            }
        });
        add(agregar_esquema);


        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        //COLUMNAS
        columna = new JLabel("COLUMNA");
        columna.setBackground(Color.decode("#515285"));
        columna.setForeground(Color.decode("#FB802F"));
        columna.setBounds(20, 110, 200, 10);
        add(columna);

        //ESPACIO PARA EL NOMBRE DE LA COLUMNA
        columna_nombre = new JTextField("Agregar", 16);
        columna_nombre.setBackground(Color.decode("#FB802F"));
        columna_nombre.setBounds(100, 110, 70, 20);
        add(columna_nombre);

        //BOTÓN PARA AGREGAR COLUMNA
        agregar_c = new JButton("AÑADIR");
        agregar_c.setBackground(Color.decode("#1CE92B"));
        agregar_c.setBounds(280, 110, 100, 20);
        agregar_c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                texto = columna_nombre.getText();

                //Validar que el dato que se este agregando sea diferente de null
                if (tipo == null){
                    System.out.println("Favor agregar un dato válido");
                }
                else{
                    //Agregar valores a listas
                    columnas.add(texto);
                    filas.add(espacio);
                    tiposva.add(tipo);
                }

                //Contador para el aumento de filas
                contador++;

                //Creación de los array para columnas y tipos de varaibles de cada una
                paracolumnas = columnas.toArray(new String[columnas.size()]);
                parafilas = filas.toArray(new String[filas.size()]);
                tiposv = tiposva.toArray(new String[tiposva.size()]);
                vacio = paracolumnas;


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
        combo_tipo.setForeground(Color.decode("#FB802F"));
        combo_tipo.setBounds(210, 90, 200, 10);
        add(combo_tipo);

        //SELECCIÓN DEL TIPO DE DATO A GUARDAR
        seleccion_tipo = new JComboBox(tipos);
        seleccion_tipo.setBounds(200, 110, 50, 30);
        seleccion_tipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(seleccion_tipo.getSelectedItem().toString());
                tipo = seleccion_tipo.getSelectedItem().toString();
            }
        });
        add(seleccion_tipo);


        /*
        confirmar = new JButton("CONFIRMAR");
        confirmar.setBackground(Color.decode("#1CE92B"));
        confirmar.setBounds(340, 80, 130, 20);
        confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(confirmar);

*/
        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //****************************************************************************************


        //AGREGAR LLAVE Y VALOR
        item = new JLabel("AGREGAR LLAVE Y VALOR");
        item.setBackground(Color.decode("#515285"));
        item.setForeground(Color.decode("#FB802F"));
        item.setBounds(170, 165, 170, 10);
        add(item);


        llave = new JLabel("LLAVE");
        llave.setBackground(Color.decode("#515285"));
        llave.setForeground(Color.decode("#FB802F"));
        llave.setBounds(20, 200, 50, 10);
        add(llave);



        seleccion_atributo = new JTextField("Llave");
        seleccion_atributo.setBackground(Color.decode("#FB802F"));
        seleccion_atributo.setBounds(80, 200, 50, 20);
        seleccion_atributo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(seleccion_tipo.getSelectedItem().toString());
            }
        });
        add(seleccion_atributo);

        valor = new JLabel("VALOR");
        valor.setBackground(Color.decode("#515285"));
        valor.setForeground(Color.decode("#FB802F"));
        valor.setBounds(150, 200, 50, 10);
        add(valor);

        valornombre = new JTextField("Valor ", 16);
        valornombre.setBackground(Color.decode("#FB802F"));
        valornombre.setBounds(200, 200, 70, 20);
        add(valornombre);

        agregar_t = new JButton("AGREGAR");
        agregar_t.setBackground(Color.decode("#1CE92B"));
        agregar_t.setBounds(290, 200, 100, 20);
        agregar_t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Esto solo está para ver que la columnas se hayan formado de la manera adecuada
                System.out.println(columnas);
                System.out.println(tiposva);

                //Toma de los valores de la llave y el valor
                llavevalor = seleccion_atributo.getText();
                valorvalor = valornombre.getText();

                System.out.println(columnas.indexOf(llavevalor));

                //Valida que la llave esté dentro de las columnas creadas previamente
                if (columnas.contains(llavevalor)) {
                    indice = columnas.indexOf(llavevalor);       //Tomo es valor del índice de la llave con respecto a la lista creada
                    pos = tiposva.get(indice);                   //Tomo el valor creado del indice de la lista de los tipos creados para cada columna

                    //Posibles tipos de valores de las llaves
                    if (pos == "int"){                  //Si el valor es un int
                        dato1 = Integer.parseInt(valorvalor);
                        System.out.println(dato1);
                    }
                    if (pos == "string"){               //Si el valor es un string
                        dato5 = valorvalor;
                        System.out.println(dato5);
                    }
                    if (pos == "double"){               //Si el valor es un double
                        dato2 = Double.parseDouble(valorvalor);
                        System.out.println(dato2);
                    }
                    if (pos == "long"){                 //Si el valor es un long
                        dato4 = Long.parseLong(valorvalor);
                        System.out.println(dato4);
                    }
                    if (pos == "float"){                ////Si el valor es un float
                        dato3 = Float.parseFloat(valorvalor);
                        System.out.println(dato3);
                    }

                    //System.out.println("Valor dentro de las columnas creadas previamente ");
                } else {
                    System.out.println("No está dentro de las columanas vuelva ingresar el valor");
                }
            }
        });
        add(agregar_t);


        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        mostrar_tabla = new JButton("MOSTRAR ESQUEMA CREADO");
        mostrar_tabla.setBackground(Color.decode("#1CE92B"));
        mostrar_tabla.setBounds(120, 250, 240, 20);
        mostrar_tabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("PRESIONADO");
                System.out.println(esquema_titulo);
                Esquema E = new Esquema();


                E.Esquema2(paracolumnas, parafilas, esquema_titulo);
            }
        });
        add(mostrar_tabla);


        //*****************************************************************************************
        //-----------------------------------------------------------------------------------------
        //*****************************************************************************************

        //FONDO DE LA APLICACIÓN

        fondo = new JLabel();
        fondo.setOpaque(true);
        fondo.setBackground(Color.decode("#060734"));
        fondo.setBounds(0, 0, 500, 500);
        add(fondo);




        setLayout(null);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setVisible(true);
    }

    }




