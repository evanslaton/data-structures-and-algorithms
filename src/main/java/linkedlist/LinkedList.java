package linkedlist;


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
        this.setHead(new Node.Builder().value(value).next(this.getHead()).build());
    }
}
