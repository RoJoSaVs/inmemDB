package Logic.AVL;

public class Node {

    Node left, right, parent;
    int height = 1;
    int value;

    public Node (int val) {
        this.value = val;
    }
}
