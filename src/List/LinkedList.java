package List;

import java.security.PublicKey;

/**
 * Esta clase genera las listas que se usaran
 */
public class LinkedList<T> {
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
     * Esta clase genera una lista singleton
     * @return La lista
     */
    public static LinkedList singleton_list(){//only one class can be created
        if (LinkedList == null){
            LinkedList= new LinkedList();
        }
        else{
            System.out.println("There is already an isinstance of this class");
        }
        return LinkedList;

    }


    /**
     * Add any kind of value to the list.
     */
    public void addLast(String value,int count,int points){
        length += 1;
        if (head == null){
            head = new Node(value, count, points);
            tail = new Node(value, count, points);
        } else {
            Node tmp = (Node) this.head;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.next = new Node(value, count, points);
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
    public void delete(T value){
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