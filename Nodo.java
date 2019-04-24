package com.company;

public class Nodo {
    Nodo left;
    int number;
    Nodo right;

    public Nodo(int number) {
        this.number = number;
    }


    public int []valores;
    public Nodo []nodo;
    public static int numValores;
    public boolean tengoHijos = false;
    public int ocupados = 0;
    public Nodo padre;

    public Nodo(){
        nodo = new Nodo [ArbolB.grado * 2 + 3];
        valores = new int [ArbolB.grado * 2 + 1];
    }
}
