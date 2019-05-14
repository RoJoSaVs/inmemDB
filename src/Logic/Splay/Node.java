package Logic.Splay;

class Node<T extends Comparable<T>,V> {
    public T key;
    public V value;
    Node parent; // pointer to the parent
    Node left; // pointer to left child
    Node right; // pointer to right child

    public Node(T key, V value) {
        this.value = value;
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}
