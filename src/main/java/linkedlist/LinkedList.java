package linkedlist;


import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node newHead) {
        this.head = newHead;
    }

    public void insert(T value) {
        this.setHead(new Node.Builder().value(value).next(this.head).build());
    }

    public boolean includes(T value) {
        Node current = this.head;

        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    public List<T> print() {
        List<T> allValues = new ArrayList<>();

        Node current = this.head;

        while (current != null) {
            allValues.add((T) current.getValue());
            current = current.getNext();
        }

        return allValues;
    }

    public void append(T value) {
        Node current = this.head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(new Node.Builder().value(value).build());
    }

    public void insertBefore(T value) {
        Node current = this.head;

        while (current != null) {
            current = current.getNext();
        }

        current.setNext(new Node.Builder().value(value).build());
    }
}
