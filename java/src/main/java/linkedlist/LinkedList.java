package linkedlist;

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
            insert(value);
        } else {
            Node<T> lastNode = getLastNode();
            Node<T> nodeToAppend = new Node<>(value);
            lastNode.setNext(nodeToAppend);
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
            Node<T> nodeToInsertAfter = getNodePreviousToTargetNode(targetValue);
            insertHelper(valueToAdd, nodeToInsertAfter);
        }
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
            Node<T> nodeToInsertAfter = getNodePreviousToTargetNode(targetValue).getNext();
            insertHelper(valueToAdd, nodeToInsertAfter);
        }
    }

    private boolean headContains(T targetValue) {
        T valueAtHead = this.head.getValue();
        return valueAtHead.equals(targetValue);
    }

    private Node<T> getNodePreviousToTargetNode(T targetValue) {
        Node<T> current = this.head;
        while (current != null && !current.getNext().getValue().equals(targetValue)) {
            current = current.getNext();
        }
        return current;
    }

    private void insertHelper(T valueToAdd, Node<T> nodeToInsertAfter) {
        Node<T> newNode = new Node<>(valueToAdd, nodeToInsertAfter.getNext());
        nodeToInsertAfter.setNext(newNode);
    }

    public Node<T> getKthNodeFromEnd(int k) {
        try {
            return this.kthNodeFromEnd(k);
        } catch (Exception exception) {
            throw exception;
        }
    }

    private Node<T> kthNodeFromEnd(int k) {
        Node<T> current = this.head;
        if (this.isInputValid(k)) {
            Node<T> kthNodeFromCurrent = getNodeKthNodeFromHead(k);
            while (kthNodeFromCurrent.getNext() != null) {
                current = current.getNext();
                kthNodeFromCurrent = kthNodeFromCurrent.getNext();
            }
        }
        return current;
    }

    private boolean isInputValid(int k) {
        if (this.isEmpty()) {
            throw new NullPointerException("This linked List is empty.");
        }else if (k < 0) {
            throw new IllegalArgumentException("Input must not be negative.");
        } else if (k > this.size() - 1) {
            throw new IllegalArgumentException("Input must not be greater than this linked list's size - 1.");
        } else {
            return true;
        }
    }

    private Node<T> getNodeKthNodeFromHead(int k) {
        Node<T> current = this.head;
        for (int i = 0; i < k; i++) {
            current = current.getNext();
        }
        return current;
    }

    public static <E> LinkedList<E> merge(LinkedList<E> list1, LinkedList<E> list2) {
        if (list1.isEmpty() || list2.isEmpty()) {
            return getNotEmptyLinkedList(list1, list2);
        } else {
            return mergeHelper(list1, list2);
        }
    }

    private static <E> LinkedList<E> getNotEmptyLinkedList(LinkedList<E> list1, LinkedList<E> list2) {
        return list1.size() > list2.size() ? list1 : list2;
    }

    private static <E> LinkedList<E> mergeHelper(LinkedList<E> list1, LinkedList<E> list2) {
        if (list1.size() > list2.size()) {
            return mergeShorterIntoLongerList(list1, list2);
        } else {
            return mergeShorterIntoLongerList(list2, list1);
        }
    }

    private static <E> LinkedList<E> mergeShorterIntoLongerList(LinkedList<E> listToMergeInto, LinkedList<E> listToMergeFrom) {
        Node<E> nodeFromMainList = listToMergeInto.head;
        Node<E> nodeFromMergingList = listToMergeFrom.head;
        Node<E> mainTemp;
        Node<E> mergeTemp;
        while(nodeFromMainList != null && nodeFromMergingList != null) {
            mainTemp = nodeFromMainList.getNext();
            mergeTemp = nodeFromMergingList.getNext();
            nodeFromMainList.setNext(nodeFromMergingList);
            nodeFromMergingList.setNext(mainTemp);
            nodeFromMainList = mainTemp;
            nodeFromMergingList = mergeTemp;
        }
        return listToMergeFrom;
    }

}
