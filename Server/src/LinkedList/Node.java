package LinkedList;

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Obtiene el valor del nodo
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * Establece el valor del nodo
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Obtiene el nodo siguiente
     * @return next
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Establece el nodo siguiente
     * @param next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo anterior
     * @return prev
     */

    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Establece el nodo anterior
     * @param prev
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
