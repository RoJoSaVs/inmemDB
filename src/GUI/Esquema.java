package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Esquema extends JFrame {

    String obtener = " ";
    int aumento = -1;
    ArrayList<String> filas = new ArrayList<String>();
    private static String[] ftotal = null;

    //guarda las entradas del metodo esquema2
    Object[] g_paracolumnas;
    String[] g_parafilas;
    String g_titulo;
    int g_conteo;


    // Constructor
    public void Esquema2(Object[] paracolumnas, String[] parafilas, String titulo, int conteo)
    {

        JFrame frame = new JFrame(titulo);
        JTable esquema = new JTable();

        //Object[] columnas = {"1","2","3","4"};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(paracolumnas);
        esquema.setModel(modelo);

        esquema.setBackground(Color.decode("#80837F"));
        esquema.setForeground(Color.blue);
        Font font = new Font("", 1,22);
        esquema.setFont(font);
        esquema.setRowHeight(30);

        JTextField texto1 = new JTextField();
        JTextField texto_busqueda = new JTextField();//00000000000000000000000000000000000000000000000000000

        JComboBox combo = new JComboBox(paracolumnas);

        JButton b1 = new JButton("AGREGAR");
        JButton b2 = new JButton("FILA");
        JButton b3 = new JButton("BUSCAR");//00000000000000000000000000000000000000000000000000000

        texto1.setBounds(150,220,100,25);
        texto_busqueda.setBounds(20,280,100,25);//00000000000000000000000000000000000000000000000000000

        b1.setBounds(270,220,100,25);
        b2.setBounds(400,220,100,25);
        b3.setBounds(150,280,100,25);//00000000000000000000000000000000000000000000000000000
        combo.setBounds(20,220,100,25);

        Object[] fila = new Object[1];

        //SECCION DE ACCIONES PARA LOS BOTONES REQUERIDOS
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtener = texto1.getText();
                filas.add(obtener);
                aumento++;
                //fila[0] = combo.getSelectedItem();
            }
        });

        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(combo.getSelectedItem());
                //System.out.println(combo.getSelectedIndex());
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(filas);
                System.out.println(aumento);
                ftotal = filas.toArray(new String[filas.size()]);
                System.out.println(ftotal[0]);
                if (aumento+1 == conteo) {
                    for (int i = 0; i < aumento - 1; i++) {
                        System.out.println(i);
                        System.out.println(ftotal[i]);
                        fila[i] = ftotal[i];
                    }
                    modelo.addRow(ftotal);
                }
                else {
                    System.out.println("ERROR EN CANTIDAD");
                }
            }

        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        JScrollPane pane = new JScrollPane(esquema);
        pane.setBounds(0,0,880,200);



        frame.setLayout(null);

        frame.add(pane);

        frame.add(combo);

        frame.add(texto1);

        frame.add(texto_busqueda);//00000000000000000000000000000000000000000000000000000


        frame.add(b1);
        frame.add(b2);
        frame.add(b3);//00000000000000000000000000000000000000000000000000000

        frame.setSize(900,400);
        frame.getContentPane().setBackground(Color.decode("#060734"));
        frame.setTitle(titulo);
        frame.setLocationRelativeTo(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
