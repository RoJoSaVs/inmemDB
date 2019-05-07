package Logic.ListString;

import java.security.PublicKey;

/**
 * Esta clase genera las ListStringas que se usaran
 */
public class LinkedListString<T> {
    private static LinkedListString LinkedListString;
    public String Esquema;
    public String name;
    public NodeString head;
    private NodeString tail;
    public int length;


    public NodeString getHead() {
        return head;
    }

    public void ListString(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }
    /**
     * Esta clase genera una ListStringa singleton
     * @return La ListStringa
     */

    /**
     * Add any kind of value to the ListString.
     */
    public void addLast(String value,String valor){
        length += 1;
        if (head == null){
            head = new NodeString(value, valor);
            tail = new NodeString(value,  valor);
        } else {
            NodeString tmp = (NodeString) this.head;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.next = new NodeString(value, valor);
            //tmp.next.prev = tmp;
            tail = tmp.getNext();

        }
    }

    /**
     * @return Visual String of the ListString.
     */
    public String printL(){
        NodeString tmp = head;
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
        NodeString tmp = head;
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