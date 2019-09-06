package linkedlist;

import java.util.Set;

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public int size() {
        Node<T> current = this.head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insert(T value) {
        this.head = new Node<>(value, this.head);
    }

    public void append(T value) {
        if (this.isEmpty()) {
            this.head = new Node<>(value);
        } else {
            Node<T> current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<>(value));
        }
    }

    public void insertBefore(T value, T valueToAdd) {
        Node<T> current = this.head;
        while (current != null && !current.getNext().getValue().equals(value)) {
            current = current.getNext();
        }
        insertHelper(valueToAdd, current);
    }

    public void insertAfter(T value, T valueToAdd) {
        Node<T> current = this.head;
        while (current != null && !current.getValue().equals(value)) {
            current = current.getNext();
        }
        insertHelper(valueToAdd, current);
    }

    private void insertHelper(T valueToAdd, Node<T> current) {
        if (current != null) {
            Node<T> newNode = new Node<>(valueToAdd, current.getNext());
            current.setNext(newNode);
        }
    }

    public boolean includes(T value) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void print() {
        if (this.isEmpty()) {
            System.out.print("This linked list is empty.");
        } else {
            Node<T> current = this.head;
            while (current != null) {
                System.out.print(current.getValue());
                current = current.getNext();
            }
        }
    }

    public T getKthNodeFromEnd(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("Input value must not be negative.");
        }
        Node<T> current = this.head;
        Node<T> forward = this.head;
        findKthNodeFromEnd(forward, current, k);
        if (current == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return current.getValue();
        }
    }

    private void findKthNodeFromEnd(Node<T> forward, Node<T> current, int k) {
        int count = 0;
        while (forward != null) {
            if (count < k) {
                count++;
            } else {
                current = current.getNext();
            }
            forward = forward.getNext();
        }
    }
}
