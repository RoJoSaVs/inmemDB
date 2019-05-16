package Logic.AA;

public class AA_container <T extends  Comparable<T>,V>{
    public V value_del_nodo=null;

    public void setValue_del_nodo(V value){
        value_del_nodo=value;
    }
}
