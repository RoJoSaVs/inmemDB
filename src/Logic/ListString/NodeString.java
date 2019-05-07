package Logic.ListString;


/**
 *clase nodo de la lista List_of_pieces
 */
public class NodeString<T> {
    private String value;//este es el valor de logica para el arbol
    public NodeString<T> next;
    public NodeString<T> prev;
    public String valor;//este es el string que contiene

    NodeString(String value, String valor){
        this.value = value;
        this.next = null;
        //this.prev = null;
        this.valor= valor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getvalor() {
        return valor;
    }//the valor have always the same value, isn't needed method set_valor

    public NodeString<T> getNext() {
        return this.next;
    }

    public void setNext(NodeString<T> next) {
        this.next = next;
    }

    //public NodeString_of_pieces<T> getPrev() {
    //   return this.prev;
    //}
//
//    public void setPrev(NodeString_of_pieces<T> prev) {
//        this.prev = prev;
//    }

    public String valueStr(){
        String value = "";
        value += this.value;
        return value;
    }
}