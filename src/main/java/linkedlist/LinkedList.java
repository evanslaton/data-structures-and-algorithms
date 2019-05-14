package linkedlist;


public class LinkedList<T> {
    private Node head;

    public LinkedList setHead(Node head) {
        this.head = head;
        return this;
    }

    public LinkedList setHeadValue(T value) {
        this.head.setValue(value);
        return this;
    }

    public LinkedList setHeadNext(Node next) {
        this.head.setNext(next);
        return this;
    }
}
