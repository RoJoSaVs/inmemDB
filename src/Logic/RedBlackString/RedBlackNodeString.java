package Logic.RedBlackString;

/**
 */ // class RedBlackNodeString
public class RedBlackNodeString<T extends Comparable<T>> {

    /** Possible color for this node */
    public static final int BLACK = 0;
    /** Possible color for this node */
    public static final int RED = 1;
    // the key of each node
    public T key;
    //el valor
    public String value;

    /** Parent of node */
    public RedBlackNodeString<T> parent;
    /** Left child */
    public RedBlackNodeString<T> left;
    /** Right child */
    public RedBlackNodeString<T> right;
    // the number of elements to the left of each node
    public int numLeft = 0;
    // the number of elements to the right of each node
    public int numRight = 0;
    // the color of a node
    public int color;

    public RedBlackNodeString(){
        color = BLACK;
        numLeft = 0;
        numRight = 0;
        parent = null;
        left = null;
        right = null;
    }

    // Constructor which sets key to the argument.
    public RedBlackNodeString(T key, String value){
        this();
        this.value=value;
        this.key = key;
    }
}// end class RedBlackNodeString
