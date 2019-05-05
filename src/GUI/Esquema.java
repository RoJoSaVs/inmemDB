package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Esquema extends JFrame {

    String obtener = " ";
    String dato;
    int aumento = -1;
    ArrayList<String> filas = new ArrayList<String>();
    private static String[] ftotal = null;

    //Guarda las entradas del método Esquema2
    Object[] g_paracolumnas;
    String[] g_parafilas;
    String[] tipos;
    String g_titulo;
    int g_conteo;
    String tipo;


    // Constructor
    public void Esquema2(Object[] paracolumnas, String[] parafilas, String titulo, int conteo)
    {

        JFrame frame = new JFrame(titulo);
        JTable esquema = new JTable();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(paracolumnas);
        esquema.setModel(modelo);

        esquema.setBackground(Color.decode("#80837F"));
        esquema.setForeground(Color.blue);
        //esquema.setEnabled(false);
        Font font = new Font("", 1,22);
        esquema.setFont(font);
        esquema.setRowHeight(30);

        JTextField texto1 = new JTextField();
        JTextField texto_busqueda = new JTextField();

        JComboBox combo = new JComboBox(paracolumnas);
        JComboBox crear_indice = new JComboBox(paracolumnas);

        JButton b1 = new JButton("AGREGAR");
        JButton b2 = new JButton("FILA");
        JButton b3 = new JButton("REGRESAR");
        JButton b4 = new JButton("BUSCAR");
        JButton b5 = new JButton("CREAR INDICE");

        texto1.setBounds(150,220,100,25);
        texto1.setBackground(Color.decode("#3B006A"));
        texto1.setForeground(Color.decode("#B76EF1"));

        texto_busqueda.setBounds(20,280,100,25);
        texto_busqueda.setBackground(Color.decode("#3B006A"));
        texto_busqueda.setForeground(Color.decode("#B76EF1"));

        b1.setBounds(270,220,100,25);
        b1.setBackground(Color.decode("#3B006A"));
        b1.setForeground(Color.decode("#B76EF1"));

        b2.setBounds(400,220,100,25);
        b2.setBackground(Color.decode("#3B006A"));
        b2.setForeground(Color.decode("#B76EF1"));

        b3.setBounds(520,220,100,25);
        b3.setBackground(Color.decode("#3B006A"));
        b3.setForeground(Color.decode("#B76EF1"));

        b4.setBounds(150,280,100,25);
        b4.setBackground(Color.decode("#3B006A"));
        b4.setForeground(Color.decode("#B76EF1"));

        b5.setBounds(400,280,100,25);
        b5.setBackground(Color.decode("#3B006A"));
        b5.setForeground(Color.decode("#B76EF1"));

        combo.setBounds(20,220,100,25);
        combo.setBackground(Color.decode("#3B006A"));
        combo.setForeground(Color.decode("#B76EF1"));
        combo.setSelectedIndex(-1);

        crear_indice.setBounds(270,280,100,25);
        crear_indice.setBackground(Color.decode("#3B006A"));
        crear_indice.setForeground(Color.decode("#B76EF1"));
        crear_indice.setSelectedIndex(-1);

        Object[] fila = new Object[1];

        //SECCION DE ACCIONES PARA LOS BOTONES REQUERIDOS
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tipo = tipos[combo.getSelectedIndex()];
                System.out.println(tipo);

                //VALIDACIÓN DEL TIPO INT
                if (tipo == "int"){
                    try {
                        dato = texto1.getText();
                        Integer.parseInt(dato);
                        System.out.println("SI SE AGREGA UN INT");

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
                        System.out.println("SI SE AGREGA UN FLOAT");

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
                        System.out.println("SI SE AGREGA UN LONG");

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
                        System.out.println("SI SE AGREGA UN DOUBLE");

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
                        System.out.println("SI SE AGREGA UN STRING");
                        aumento++;
                    }
                    catch (Exception E){
                        System.out.println("SE ESPERABA UN STRING");
                    }
                }
            }

        });

        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(combo.getSelectedIndex());
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ftotal = filas.toArray(new String[filas.size()]);
                //La comparación se hace entre la cantidad de columnas creadas y los datos agregados a columnas
                if (aumento+1 == conteo) {
                    for (int i = 0; i > aumento ; i++) {
                        System.out.println(i);
                        System.out.println(ftotal[i]);
                        fila[i] = ftotal[i];
                    }
                    modelo.addRow(ftotal);
                }
                else {
                    UIManager.put("OptionPane.messageForeground", Color.decode("#B76EF1"));
                    UIManager.put("OptionPane.background", Color.decode("#060734"));
                    UIManager.put("OptionPane.messagebackground", Color.decode("#060734"));
                    UIManager.put("Panel.background", Color.decode("#060734"));
                    JOptionPane.showMessageDialog(b1, "Faltan agregar datos en columnas");
                }
            }

        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              dispose();
                System.out.println(esquema.getSelectedRow());
            }
       });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String por_buscar =texto_busqueda.getText();
                String tipo_del_dato_por_buscar=Logic.get_data_type.get_type(por_buscar);
                if( tipo_del_dato_por_buscar.equals("string")){
                    //llama binario de string
                }
                else{
                    //llama binario normal
                }
            }
        });



        JScrollPane pane = new JScrollPane(esquema);
        pane.setBounds(0,0,880,200);

        frame.setLayout(null);
        frame.add(pane);
        frame.add(combo);
        frame.add(crear_indice);
        frame.add(texto1);
        frame.add(texto_busqueda);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);

        frame.setSize(900,400);
        frame.getContentPane().setBackground(Color.decode("#060734"));
        frame.setTitle(titulo);
        frame.setLocationRelativeTo(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}