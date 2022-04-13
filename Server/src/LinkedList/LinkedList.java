package LinkedList;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructo para inicializar la lista enlazada
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructor para agregar a la lista enlazada un elemento
     * @param value
     */
    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * Metodo para obtener el elemento en la posicion index
     * @return current.data
     */
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Metodo para eliminar el elemento correspondiente
     * @param value
     */
    public void remove(Objects value){
        Node<T> current = this.head;
        Node<T> previous = null;
        while (current != null) {
            if (current.data.equals(value)) {
                if (previous == null) {
                    this.head = this.head.next;
                } else {
                    previous.next = current.next;
                }
                this.size--;
            }
            previous = current;
            current = current.next;
        }
    }

    /**
     * Metodo para obtener el tamaño de la lista
     * @return size
     */
    public int size() {
        return this.size;
    }

    /**
     * Metodo para limpiar la lista
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Metodo para verificar si la lista contiene un elemento
     * @return boolean
     */
    public boolean contains(T value) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Metodo para obtener el indice de un elemento
     * @return index
     */
    public T indexOf(T value) {
        Node<T> current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (current.data.equals(value)) {
                return current.data;
            }
        }
        return null;
    }

    /**
     * Metodo para remover un elemento de la lista
     * @param value
     * @return
     */
    public T remove(T value) {
        Node<T> current = this.head;
        Node<T> previous = null;
        while (current != null) {
            if (current.data.equals(value)) {
                if (previous == null) {
                    this.head = this.head.next;
                } else {
                    previous.next = current.next;
                }
                this.size--;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    /**
     * Metodo para remover el primer elemento de la lista
     */
    public T removeFirst() {
        if (this.head == null) {
            return null;
        }
        Node<T> current = this.head;
        this.head = this.head.next;
        this.size--;
        return current.data;
    }

    /**
     * Metodo para remover el ultimo elemento de la lista
     */
    public void removeLast() {
        if (this.head == null) {
            return;
        }
        Node<T> current = this.head;
        Node<T> previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        this.size--;
    }

    /**
     * Metodo para obtener el ultimo elemento de la lista
     * @return
     */
    public T getLast() {
        if (this.head == null) {
            return null;
        }
        Node<T> current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Metodo para obtener el primer elemento de la lista
     * @return
     */
    public T getFirst() {
        if (this.head == null) {
            return null;
        }
        return this.head.data;
    }
}