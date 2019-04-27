package Logic;

public class Main {

    //Estructuras de datos para la búsqueda de índices
    public static void main(String[] args) {

        //EJEMPLOS DE LAS ESTRUCTURAS USADAS

        //PARA ÁRBOL BINARIO DE BÚSQUEDA
        ArboBinario arbolInicial = new ArboBinario();
        arbolInicial.insertar(15);
        arbolInicial.insertar(12);
        arbolInicial.insertar(20);
        arbolInicial.insertar(9);
        arbolInicial.insertar(11);
        arbolInicial.insertar(19);
        arbolInicial.insertar(21);


        //PARA ÁRBOL B, SE DEFINE EL GRADO DEL MISMO
        ArbolB arbolB = new ArbolB(5);
        arbolB.insertar(15);
        arbolB.insertar(7);

        //PARA ÁRBOL AVL
        ArbolAVL árbol = new ArbolAVL ();
        árbol.insertar(6);
        árbol.insertar(3);
        árbol.insertar(7);
        árbol.visualizar();

    }
}
