package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                System.out.println(Contenedor_de_esquemas.lista_de_esquemas);
                dispose();
            }});
        add(crear);

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
                        break;
                    }
                }

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
