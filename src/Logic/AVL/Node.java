package Logic.AVL;

public class Node<T extends Comparable<T>,V> {

    Node left, right, parent;
    int height = 1;
    public T key;
    public V value;

    public Node(T key, V value) {
        this.value = value;
        this.key = key;
    }
}
