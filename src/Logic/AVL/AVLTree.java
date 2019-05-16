package Logic.AVL;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>,V> {
    Node<T,V> root;

    public AVLTree() {
        root = null;
    }

    public T Maximum() {
        Node<T,V> local = root;
        if (local == null)
            return null;
        while (local.getRight() != null)
            local = local.getRight();
        return local.getData();
    }

    public T Minimum() {
        Node<T,V> local = root;
        if (local == null)
            return null;
        while (local.getLeft() != null) {
            local = local.getLeft();
        }
        return local.getData();
    }

    private int depth(Node<T,V> node) {
        if (node == null)
            return 0;
        return node.getDepth();
        // 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
    }

    public Node<T,V> insert(T data,V value) {
        root = insert(root, data,value);
        switch (balanceNumber(root)) {
            case 1:
                root = rotateLeft(root);
                break;
            case -1:
                root = rotateRight(root);
                break;
            default:
                break;
        }
        return root;
    }

    public Node<T,V> insert(Node<T,V> node, T data,V value) {
        if (node == null)
            return new Node<T,V>(data,value);
        if (node.getData().compareTo(data) > 0) {
            node = new Node<T,V>(node.getData(), insert(node.getLeft(), data,value),
                    node.getRight());
            // node.setLeft(insert(node.getLeft(), data));
        } else if (node.getData().compareTo(data) < 0) {
            // node.setRight(insert(node.getRight(), data));
            node = new Node<T,V>(node.getData(), node.getLeft(), insert(
                    node.getRight(), data,value));
        }
        // After insert the new node, check and rebalance the current node if
        // necessary.
        switch (balanceNumber(node)) {
            case 1:
                node = rotateLeft(node);
                break;
            case -1:
                node = rotateRight(node);
                break;
            default:
                return node;
        }
        return node;
    }

    private int balanceNumber(Node<T,V> node) {
        int L = depth(node.getLeft());
        int R = depth(node.getRight());
        if (L - R >= 2)
            return -1;
        else if (L - R <= -2)
            return 1;
        return 0;
    }

    private Node<T,V> rotateLeft(Node<T,V> node) {
        Node<T,V> q = node;
        Node<T,V> p = q.getRight();
        Node<T,V> c = q.getLeft();
        Node<T,V> a = p.getLeft();
        Node<T,V> b = p.getRight();
        q = new Node<T,V>(q.getData(), c, a);
        p = new Node<T,V>(p.getData(), q, b);
        return p;
    }

    private Node<T,V> rotateRight(Node<T,V> node) {
        Node<T,V> q = node;
        Node<T,V> p = q.getLeft();
        Node<T,V> c = q.getRight();
        Node<T,V> a = p.getLeft();
        Node<T,V> b = p.getRight();
        q = new Node<T,V>(q.getData(), b, c);
        p = new Node<T,V>(p.getData(), a, q);
        return p;
    }

    public V search(T data) {
        Node<T,V> local = root;
        while (local != null) {
            if (local.getData().compareTo(data) == 0)
                return local.value;
            else if (local.getData().compareTo(data) > 0)
                local = local.getLeft();
            else
                local = local.getRight();
        }
        return null;
    }

    public String toString() {
        return root.toString();
    }

    public void PrintTree() {
        root.level = 0;
        Queue<Node<T,V>> queue = new LinkedList<Node<T,V>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T,V> node = queue.poll();
            System.out.println(node);
            int level = node.level;
            Node<T,V> left = node.getLeft();
            Node<T,V> right = node.getRight();
            if (left != null) {
                left.level = level + 1;
                queue.add(left);
            }
            if (right != null) {
                right.level = level + 1;
                queue.add(right);
            }
        }
    }
}
