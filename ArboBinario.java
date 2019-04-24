package com.company;

public class ArboBinario {

    Nodo root;

    public boolean esvacio(){
        return (root == null);
    }

    public boolean contiene(int number){
        return  contiene(number,root);
    }

    private boolean contiene(int number, Nodo actual){
        if (actual == null) {
            return false;
        }else if (number < actual.number){
            contiene(number,actual.left);
        }else if (number > actual.number){
            contiene(number,actual.right);
        }else{
            return true;
        }
        return false;
    }

    public void insertar(int number){
        root = insertar(number, root);
    }


    private Nodo insertar(int number, Nodo apuntador){
        if (apuntador == null){
            return new Nodo(number);
        }
        else if (number<apuntador.number){
            insertar(number,apuntador.left);
        }
        else if (number>apuntador.number){
            insertar(number,apuntador.right);
        }
        return apuntador;
    }


}
