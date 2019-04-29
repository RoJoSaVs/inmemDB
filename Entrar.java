package com.company;

import javax.swing.*;
import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Entrar extends JFrame{

    JLabel titulo = new JLabel();

    JButton crear = new JButton();

    JComboBox opciones = new JComboBox();

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
            }});
        add(crear);

        //OPCIONES DE ESQUEMAS CREADOS
        opciones = new JComboBox();
        opciones.setBounds(170, 90, 50, 30);
        opciones.setBackground(Color.decode("#3B006A"));
        opciones.setForeground(Color.decode("#B76EF1"));
        opciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(opciones);

        setLayout(null);
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#060734"));
        setVisible(true);
    }

}
