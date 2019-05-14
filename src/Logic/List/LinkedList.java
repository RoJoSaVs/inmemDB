package Logic.List;

public class LinkedList<T extends  Comparable<T>,V> {
    private static LinkedList LinkedList;
    public String Esquema;
    public String name;
    public Node head;
    private Node tail;
    public int length;

    public Node getHead() {
        return head;
    }

    public void List(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }
    /**
     * Add any kind of value to the list.
     */
    public void addLast(T key,V value){
        length += 1;
        if (head == null){
            head = new Node(key,value);
            tail = new Node(key,value);
        } else {
            Node tmp = (Node) this.head;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.next = new Node(key,value);
            //tmp.next.prev = tmp;
            tail = tmp.getNext();

        }
    }

    /**
     * @return Visual String of the list.
     */
    public String printL(){
        Node tmp = head;
        String result = "[ ";
        while (tmp != null){
            if (tmp.getNext() != null){
                result += (tmp.getValue() + " , ");
            } else {
                result += tmp.getValue();
            }
            tmp = tmp.getNext();
        }
        result += " ]";
        return result;
    }
    public void delete(V value){
        Node tmp = head;
        if (this.getHead().getValue()== value){
            this.head = head.next;
            this.length -= 1;

        } else {
            while (tmp.next != null){
                if ((tmp.next.getValue()) == value){
                    tmp.next = tmp.next.next;
                    length -= 1;
                } else {
                    tmp = tmp.next;
                }
            }
        }
    }
}