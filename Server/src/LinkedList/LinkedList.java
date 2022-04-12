package LinkedList;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

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

    public int size() {
        return this.size;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

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

    public T indexOf(T value) {
        Node<T> current = this.head;
        for (int i = 0; i < this.size; i++) {
            if (current.data.equals(value)) {
                return current.data;
            }
        }
        return null;
    }

    public void add(int index, T value) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<T>(value);
        if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node<T> current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        this.size++;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = value;
    }

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

    public T removeFirst() {
        if (this.head == null) {
            return null;
        }
        Node<T> current = this.head;
        this.head = this.head.next;
        this.size--;
        return current.data;
    }

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

    public T getFirst() {
        if (this.head == null) {
            return null;
        }
        return this.head.data;
    }

    public void reverse() {
        Node<T> current = this.head;
        Node<T> previous = null;
        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        this.head = previous;
    }

    public void print() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
