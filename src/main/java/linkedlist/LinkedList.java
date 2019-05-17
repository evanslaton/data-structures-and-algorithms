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

    public void insertBefore(T value, T newValue) {
        Node current = this.head;

        while (current != null) {
            if (current.getNext().getValue() == value) {
                current.setNext(new Node.Builder().value(newValue).next(current.getNext()).build());
                break;
            }

            current = current.getNext();
        }
    }

    public void insertAfter(T value, T newValue) {
        Node current = this.head;

        while (current != null) {
            if (current.getValue() == value) {
                current.setNext(new Node.Builder().value(newValue).next(current.getNext()).build());
                break;
            }

            current = current.getNext();
        }
    }

    public T getKthFromEnd(int k) {
        if (k < 0) {
            throw new IndexOutOfBoundsException();
        }

        int length = this.getLength();

        if (k > length - 1) {
            throw new IndexOutOfBoundsException();
        }

        return (T) this.getKthFromEndNode(length, k).getValue();
    }

    private int getLength() {
        Node current = this.head;
        int length = 0;

        while (current != null) {
            length++;

            current = current.getNext();
        }

        return length;
    }

    private Node getKthFromEndNode(int length, int k) {
        Node current = this.head;

        for (int i = 0; i < length - k - 1; i++) {
            current = current.getNext();
        }

        return current;
    }
}
