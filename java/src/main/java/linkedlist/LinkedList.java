/**
 * Linked List
 *
 * @author Evan Slaton
 *
 */

package linkedlist;

public class LinkedList<T> {
    private Node<T> head;

    /**
     * <p>Constructs an empty list.</p>
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * @param none
     * @return the node that is stored at the head of the linked list
     */
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * @param none
     * @return the number of elements in the list.
     */
    public int size() {
        Node<T> current = this.head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    /**
     * @param none
     * @return true if the list is empty, false if not.
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * @param T
     * @return true if the list contains the value specified, false if not.
     */
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

    public void insert(T value) {
        this.head = new Node<>(value, this.head);
    }

    public void append(T value) {
        if (this.isEmpty()) {
            this.head = new Node<>(value);
        } else {
            Node<T> lastNode = getLastNode();
            lastNode.setNext(new Node<>(value));
        }
    }

    private Node<T> getLastNode() {
        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public void insertBefore(T targetValue, T valueToAdd) {
        if (this.includes(targetValue)) {
            this.performInsertBefore(targetValue, valueToAdd);
        }
    }

    private void performInsertBefore(T targetValue, T valueToAdd) {
        if (this.headContains(targetValue)) {
            insert(valueToAdd);
        } else {
            Node<T> nodeToInsertAfter = getNodeToInsertAfter(targetValue);
            insertHelper(valueToAdd, nodeToInsertAfter);
        }
    }

    private Node<T> getNodeToInsertAfter(T targetValue) {
        Node<T> current = this.head;
        while (current != null && !current.getNext().getValue().equals(targetValue)) {
            current = current.getNext();
        }
        return current;
    }

    public void insertAfter(T targetValue, T valueToAdd) {
        if (this.includes(targetValue)) {
            this.performInsertAfter(targetValue, valueToAdd);
        }
    }

    private void performInsertAfter(T targetValue, T valueToAdd) {
        if (this.headContains(targetValue)) {
            Node<T> newNode = new Node(valueToAdd);
            this.head.setNext(newNode);
        } else {
            Node<T> nodeToInsertAfter = getNodeWithTargetValue(targetValue);
            insertHelper(valueToAdd, nodeToInsertAfter);
        }
    }

    private boolean headContains(T targetValue) {
        T valueAtHead = this.head.getValue();
        return valueAtHead.equals(targetValue);
    }

    private Node<T> getNodeWithTargetValue(T targetValue) {
        Node<T> current = this.head;
        while (current != null && !current.getValue().equals(targetValue)) {
            current = current.getNext();
        }
        return current;
    }

    private void insertHelper(T valueToAdd, Node<T> nodeToInsertAfter) {
        if (nodeToInsertAfter != null) {
            Node<T> newNode = new Node<>(valueToAdd, nodeToInsertAfter.getNext());
            nodeToInsertAfter.setNext(newNode);
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
