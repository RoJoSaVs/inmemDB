package Logic.BinaryStringTree;

/**
 * CSE 373, Winter 2011, Jessica Miller
 * An binary search tree implementation of a Set for Strings.
 */
public class StringTreeSet implements StringSet {
    protected StringTreeNode root;
    protected int numElements;

    public StringTreeSet() {
        root = null;
    }

    /**
     * Adds a value to our String set.
     * @return true if this set did not already contain the added element
     */
    public boolean add(String value) {
        int oldSize = size();
        this.root = add(root, value);
        return oldSize != size();
    }

    /**
     * Recursive add helper method.
     * MODIFY THIS METHOD TO CORRECTLY FILL IN THE HEIGHT OF THE NODES WHEN
     * ELEMENTS ARE ADDED.
     * //@param root the old state of node being examined
     * @param value
     * @return the new state of the node being examined
     */
    protected StringTreeNode add(StringTreeNode node, String value) {
        if (node == null) {
            // found the spot where the new values should go;
            // create a node for it and increment the set size
            node = new StringTreeNode(value);
            numElements++;
        } else if (node.data.compareTo(value) == 0) {
            // the value is already in the set; alter nothing and return the
            // node that contains the value
            return node;
        } else if (node.data.compareTo(value) > 0) {
            // the value is less than the current node, recurse left
            // must apply x = change(x) to remember changes made to root.left
            node.left = add(node.left, value);
        } else {
            // the value is less than the current node, recurse left
            // must apply x = change(x) to remember changes made to root.left
            node.right = add(node.right, value);
        }
        return node;
    }

    /**
     * Returns true if the set contains the specified String.
     * @param value the value to search for
     * @return true if the found is found; false otherwise
     */
    public boolean contains(String value) {
        return contains(root, value);
    }

    /**
     * Recursive print helper; binary search the tree until we find the value
     * or determine that it is not in the place in the tree where it would be.
     * @param root the BST in which to search for the value
     * @param value the value to search for
     * @return true if the found is found; false otherwise
     */
    private boolean contains(StringTreeNode root, String value) {
        System.out.println(root.data);
        //System.out.println( root.right.data);
        //System.out.println( root.left.data);
        //System.out.println("El derecho es " + root.right.data);
        //System.out.println("El izquierdo  es " + root.left.data);
        if (root == null) {
            return false;                               // not in set
        } else if (root.data.compareTo(value) == 0) {
            return true;                                // found!
        } else if (root.data.compareTo(value) > 0) {
            return contains(root.left, value);          // search left
        } else {
            return contains(root.right, value);         // search right
        }
    }

    /**
     * Finds the minimum value in the given node's subtree.  This could
     * also be easily written non-recursively.
     * @param root the node in which to find the minimum value
     * @return the minimum node in the given node's subtree
     */
    private StringTreeNode findMin(StringTreeNode root) {
        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root;
        } else {
            return findMin(root.left);
        }
    }

    // IMPLEMENT THIS!
    public boolean isBalanced() {
        return false;
    }

    /**
     * Prints the BST sideways.  Good for debugging.
     */
    public void print() {
        print(this.root, 0);
    }

    /**
     * Recursive print helper; in-order traversal.
     * @param node
     * @param level
     */
    protected void print(StringTreeNode node, int level) {
        if (node == null)
            return;
        else {
            print(node.right, level + 1);
            printTabs(level);
            System.out.println(node.data);
            print(node.left, level + 1);
        }
    }

    private void printTabs(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
    }

    /**
     * Removes the specified String from this set if it is present.
     * @return true if this set contained the specified element
     */
    public boolean remove(String value) {
        int oldSize = size();
        root = remove(root, value);
        return oldSize != size();
    }

    /**
     * Recursive remove helper method.
     * MODIFY THIS METHOD TO CORRECTLY FILL IN THE HEIGHT OF THE NODES WHEN
     * ELEMENTS ARE REMOVED.
     * //@param root the old state of node being examined
     * @param value
     * @return the new state of the node being examined
     */
    protected StringTreeNode remove(StringTreeNode node, String value) {
        if (node == null) {
            // the value was not found; no change necessary
            return node;
        } else if (node.data.compareTo(value) > 0) {
            // the value is less than the current node, recurse left
            node.left = remove(node.left, value);
        } else if (node.data.compareTo(value) < 0) {
            // the value is less than the current node, recurse right
            node.right = remove(node.right, value);
        } else {
            // we have found the node to remove
            if (node.right != null && node.left != null) {
                // if the node has both left and right subtrees, find the
                // minimum value in the right branch; the node's value with
                // minimum value; remove minimum value from right branch
                node.data = findMin(node.right).data;
                node.right = remove(node.right, node.data);
            } else if (node.right != null) {
                // if the node's left subtree is empty, replace the node with
                // its right child
                node = node.right;
                numElements--;
            } else {
                // if the node's right subtree is empty or both subtrees are
                // empty, replace the node with its left child (i.e. null in
                // the both empty case)
                node = node.left;
                numElements--;
            }
        }
        return node;
    }

    /**
     * Returns the number of elements in the set.
     */
    public int size() {
        return numElements;
    }

    /**
     * Returns a String representation of StringTreeSet with elements in their
     * "natural order" (e.g., [Jake, Kasey, Marisa, Robert]).
     */
    public String toString() {
        String str = "[" + toString(root);
        if (str.length() > 1) { str = str.substring(0, str.length() - 2); }
        return str + "]";
    }

    // IMPLEMENT THIS!
    protected static int balanceFactor(StringTreeNode node) {
        return 0;
    }

    // IMPLEMENT THIS!
    protected static int computeHeight(StringTreeNode node) {
        return 0;
    }

    /**
     * Recursive print helper; in-order traversal.
     * MODIFY THIS METHOD TO ALSO PRINT OUT THE HEIGHT OF EACH NODE.
     * @param root
     * //@param node
     * //@param level
     */
    private String toString(StringTreeNode root) {
        String str = "";
        if (root != null) {
            str += toString(root.left);
            str += root.data + ", ";
            str += toString(root.right);
        }
        return str;
    }
}
