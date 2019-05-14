package Logic.RedBlack;

/**
 */ // class RedBlackNode
class RedBlackNode<T extends Comparable<T>,V> {

    /** Possible color for this node */
    public static final int BLACK = 0;
    /** Possible color for this node */
    public static final int RED = 1;
    // the key of each node
    public T key;
    //el valor
    public V value;

    /** Parent of node */
    RedBlackNode<T,V> parent;
    /** Left child */
    RedBlackNode<T,V> left;
    /** Right child */
    RedBlackNode<T,V> right;
    // the number of elements to the left of each node
    public int numLeft = 0;
    // the number of elements to the right of each node
    public int numRight = 0;
    // the color of a node
    public int color;

    RedBlackNode(){
        color = BLACK;
        numLeft = 0;
        numRight = 0;
        parent = null;
        left = null;
        right = null;
    }

    // Constructor which sets key to the argument.
    RedBlackNode(T key,V value){
        this();
        this.key = key;
        this.value=value;
    }
}// end class RedBlackNode
