package Logic.BinaryTree;

public class BinaryTree <T extends  Comparable<T>,V>{
    private Node<T,V> root=null;

    public void add(T key, V value) {
        this.root = this.addRecursive(root, key, value);
    }

    private Node<T,V> addRecursive(Node<T,V> current, T key, V value) {
        if (current == null) {
            root=new Node<>(key, value);
            return root;
        }
        if (current.key.compareTo(key) < 0) {//(value < current.value)
            current.left = addRecursive(current.left, key, value);
        } else if (current.key.compareTo(key) > 0) {//else if (value > current.value) {
            current.right = addRecursive(current.right, key, value);
        }
        return current;
    }

    public Node containsNode(T key) {
        return containsNodeRecursive(root,key);
    }

    private Node containsNodeRecursive(Node<T,V> current, T key) {
        if (current == null) {
            System.out.println(false);
            return null;
        }
        System.out.println(key);
        System.out.println(current.key);
        if (key.equals(current.key)) {
            System.out.println(true);
            return current;
        }
        return current.key.compareTo(key) < 0
                ? containsNodeRecursive(current.left,key)
                : containsNodeRecursive(current.right,key);
    }

    public void delete(T key, Object value) {
        root = deleteRecursive(root, key, value);
    }

    private Node deleteRecursive(Node<T,V> current, T key, Object value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here
            if (current.left == null && current.right == null) {
                return null;
            }
            else if (current.right == null) {
                return current.left;
            }

            else if (current.left == null) {
                return current.right;
            }
            else{
                V smallestValue = findSmallestValue(current.right);
                current.value =  smallestValue;
                current.right = deleteRecursive(current.right,key, smallestValue);
                return current;
            }
        }
        if (current.key.compareTo(key) < 0) {
            current.left = deleteRecursive(current.left, key,value);
            return current;
        }
        current.right = deleteRecursive(current.right,key, value);
        return current;
    }
    private V findSmallestValue(Node<T,V> root) {
        return root.left == null ?  root.value : findSmallestValue(root.left);
    }

}

//random para el key
