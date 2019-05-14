package Logic.List;

public class Node<T extends Comparable<T>,V> {
    public Node<T,V> next;
    public Node<T,V> prev;
    public T key;
    public V value;

    Node(T key, V value){
        this.value = value;
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<T,V> getNext() {
        return this.next;
    }

    public void setNext(Node<T,V> next) {
        this.next = next;
    }

    //public Node_of_pieces<T> getPrev() {
    //   return this.prev;
    // }
//
//    public void setPrev(Node_of_pieces<T> prev) {
//        this.prev = prev;
//    }

}