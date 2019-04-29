package com.company;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Esquema extends JPanel {


    JFrame f;
    JTable j;
    JButton b;

    private static String[] paracolumnas = null;
    private static String[] parafilas = null;
    private static String titulo = "";

    // Constructor
    public void Esquema2(String[] paracolumnas, String[] parafilas, String titulo)
    {
        //System.out.println(columnasdatos[0]);
        // Frame initiallization
        f = new JFrame();

        // Frame Title
        f.setTitle("JTable Example");

        // Data to be displayed in the JTable
        String[][] data = {};

        // Column Names
        //String[] columnNames = { "Name", "Roll Number", "Department" };


        // Initializing the JTable
        j = new JTable(data, paracolumnas);
        j.setBounds(30, 40, 200, 300);


        //b.setBounds(50,300,50,50);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        sp.setBorder(BorderFactory.createTitledBorder (titulo));

        f.add(sp);


        // Frame Size
        f.setSize(1000, 200);
        // Frame Visible = true
        f.setVisible(true);
    }
}
