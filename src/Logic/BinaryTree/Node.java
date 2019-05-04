package Logic.BinaryTree;

public class Node <T> {

    Node left, right, parent;
    int value;
    T verdadero_valor;


    public Node(int val,T verda) {
        this.value = val;
        this.verdadero_valor=verda;
    }
}
