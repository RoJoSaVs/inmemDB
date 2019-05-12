package Logic.BinaryTree;

public class Node<T extends Comparable<T>,V> {
    public Node<T,V> left = null;
    public Node<T,V> right = null;
    public Node<T,V> parent = null;
    public T key;
    public V value;

    public Node(T key, V value) {
        this.value = value;
        this.key = key;
    }
}