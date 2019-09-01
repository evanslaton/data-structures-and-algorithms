package linkedlist;

public class Node<T> {
    private T value;
    private Node next;

    public static class Builder<T> {
        private T value;
        private Node next;

        public Builder() {
            this.value = null;
            this.next = null;
        }

        public Builder value(T value) {
            this.value = value;
            return this;
        }

        public Builder next(Node next) {
            this.next = next;
            return this;
        }

        public Node build() {
            return new Node(this);
        }
    }

    private Node(Builder builder) {
        this.value = (T) builder.value;
        this.next = builder.next;
    }

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
