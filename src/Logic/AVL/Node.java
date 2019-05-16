package Logic.AVL;

public class Node<T extends Comparable<T>,V>  {

    private T data;
    public V value;
    private Node<T,V> left;
    private Node<T,V> right;
    public int level;

    private int depth;

    public Node(T data, V value) {
        this(data, null, null);
        this.value=value;
    }

    public Node(T data, Node<T,V> left, Node<T,V> right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
        if (left == null && right == null)
            setDepth(1);
        else if (left == null)
            setDepth(right.getDepth() + 1);
        else if (right == null)
            setDepth(left.getDepth() + 1);
        else
            setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T,V> getLeft() {
        return left;
    }

    public void setLeft(Node<T,V> left) {
        this.left = left;
    }

    public Node<T,V> getRight() {
        return right;
    }

    public void setRight(Node<T,V> right) {
        this.right = right;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param depth
     *            the depth to set
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }


    public int compareTo(Node<T,V> o) {
        return this.data.compareTo(o.data);
    }

    @Override
    public String toString() {
        return "Level " + level + ": " + data;
    }

}