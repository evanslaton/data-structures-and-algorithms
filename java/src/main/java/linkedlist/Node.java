package linkedlist;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    protected T getValue() {
        return this.value;
    }

    protected Node<T> getNext() {
        return this.next;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    protected void setNext(Node<T> next) {
        this.next = next;
    }
}
