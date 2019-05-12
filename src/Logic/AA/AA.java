package Logic.AA;

public class AA <T extends  Comparable<T>,V> {
    private class nodoArbol<T extends Comparable<T>,V > {
        private AA hd;
        private AA hi;
        private T key;
        private V value;

        private void nodoArbol(){
            hd = null;
            hi = null;
            value = null;
        }
    }

    public nodoArbol raiz;

    public void AA(){
        nodoArbol raiz = new nodoArbol();
    }

    public boolean esVacio(){
        return (raiz == null);
    }

    public void insertar(T key, V value){
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.value =value;
            nuevo.hd = new AA();
            nuevo.hi = new AA();
            raiz = nuevo;
        }
        else {
            if (raiz.key.compareTo(key) > 0) {
                (raiz.hd).insertar(key,value);
            }
            if (raiz.key.compareTo(key) < 0){
                (raiz.hi).insertar(key,value);
            }
        }
    }

    public void preOrder(){
        if (!esVacio()) {
            System.out.print( raiz.value + ", "  );
            raiz.hi.preOrder();
            raiz.hd.preOrder();
        }
    }

    public void inOrder(){
        if (!esVacio()) {
            raiz.hi.inOrder();
            System.out.print( raiz.value + ", "  );
            raiz.hd.inOrder();
        }
    }

    public void posOrder(){
        if (!esVacio()) {
            raiz.hd.posOrder();
            raiz.hi.posOrder();
            System.out.print( raiz.value + ", "  );

        }
    }

    public AA buscar(T key, V value){
        AA arbolito = null;
        if (!esVacio()) {
            if (key.equals(raiz.key)) {
                return this;
            }
            else {
                if (raiz.key.compareTo(key) < 0) {
                    arbolito = raiz.hi.buscar(key,value);
                }
                else {
                    arbolito = raiz.hd.buscar(key,value);
                }
            }
        }
        return arbolito;
    }

    public boolean existe(T key, V value){
        if (!esVacio()) {
            if (key.equals(raiz.key)) {
                return true;
            }
            else {
                if (raiz.key.compareTo(key) < 0) {
                    raiz.hi.existe(key,value);
                }
                else {
                    raiz.hd.existe(key,value);
                }
            }
        }
        return false;
    }

    public int cantidad(){
        if (esVacio()) {
            return 0;
        }
        else {
            return (1 + raiz.hd.cantidad() + raiz.hi.cantidad());
        }
    }

    public int altura() {
        if (esVacio()) {
            return 0;
        }
        else {
            return (1 + Math.max(((raiz.hi).altura()), ((raiz.hd).altura())));
        }
    }

    public V buscarMin() {
        AA arbolActual = this;
        while( !arbolActual.raiz.hi.esVacio() ) {
            arbolActual = arbolActual.raiz.hi;
        }
        V devuelvo= (V) arbolActual.raiz.value;//?
        arbolActual.raiz=null;
        return devuelvo;
    }
    public V buscarMan() {
        AA arbolActual = this;
        while( !arbolActual.raiz.hd.esVacio() ) {
            arbolActual = arbolActual.raiz.hd;
        }
        V devuelvo=  (V) arbolActual.raiz.value;//?
        arbolActual.raiz=null;
        return devuelvo;
    }

    public boolean esHoja() {
        boolean hoja = false;
        if( (raiz.hi).esVacio() && (raiz.hd).esVacio() ) {
            hoja = true;
        }
        return hoja;
    }

    public void eliminar(T key, V value) {
        AA paraEliminar = buscar(key,value);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            }
            else {
                if (!paraEliminar.raiz.hi.esVacio() && !paraEliminar.raiz.hd.esVacio()) {
                    paraEliminar.raiz.value = paraEliminar.raiz.hd.buscarMin();
                }
                else {
                    if (paraEliminar.raiz.hi.esVacio()) {
                        paraEliminar.raiz = paraEliminar.raiz.hd.raiz;
                    }else{
                        paraEliminar.raiz = paraEliminar.raiz.hi.raiz;
                    }
                }
            }
        }
    }
}

