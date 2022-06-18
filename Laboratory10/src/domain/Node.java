package domain;



/**
 *
 * @author sofia
 */
public class Node {

    public Object data; //El dato almancenado en el nodo
    public Node next; //El apuntador al sgte nodo
    public Node prev;
    public int priority;//para las colas de prioridad
    //1 baja
    //2 media
    //3 alta

    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node() {
        this.next = this.prev = null;
    }

    public Node(Object data, int priority) {
        this.data = data;
        this.next = null;
        this.priority = priority;
    }
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    
    
}//end class
