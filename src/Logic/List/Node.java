package Logic.List;


/**
 *clase nodo de la lista List_of_pieces
 */
public class Node<T> {
    private String value;
    public Node<T> next;
    public Node<T> prev;
    private int count;
    private int points;

    Node(String value, int count, int points){
        this.value = value;
        this.next = null;
        //this.prev = null;
        this.count = count;
        this.points= points;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPoints() {
        return points;
    }//the points have always the same value, isn't needed method set_points

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    //public Node_of_pieces<T> getPrev() {
    //   return this.prev;
    //}
//
//    public void setPrev(Node_of_pieces<T> prev) {
//        this.prev = prev;
//    }

    public String valueStr(){
        String value = "";
        value += this.value;
        return value;
    }
}