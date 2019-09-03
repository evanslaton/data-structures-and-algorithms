package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    Node<Integer> node1;
    Node<Integer> node2;
    Node<Integer> node3;

    @Before
    public void setNodes() {
        node1 = new Node<>(5);
        node2 = new Node<>(10, node1);
        node3 = new Node<>(15);
    }

    @Test
    public void testNodeConstructor_withValueArgumentOnly() {
        Integer expectedValue = 5;
        assertEquals(node1.getValue(), expectedValue);
        assertNull(node1.getNext());
    }

    @Test
    public void testNodeConstructor_withValueAndNextArguments() {
        Integer expectedValue = 10;
        assertEquals(node2.getValue(), expectedValue);
        assertEquals(node2.getNext(), node1);
    }

    @Test
    public void testGetValue() {
        Integer node1ExpectedValue = 5;
        Integer node2ExpectedValue = 10;
        Integer node3ExpectedValue = 15;
        assertEquals(node1.getValue(), node1ExpectedValue);
        assertEquals(node2.getValue(), node2ExpectedValue);
        assertEquals(node3.getValue(), node3ExpectedValue);
    }

    @Test
    public void testSetValue() {
        node1.setValue(20);
        node2.setValue(25);
        node3.setValue(30);
        Integer node1ExpectedValue = 20;
        Integer node2ExpectedValue = 25;
        Integer node3ExpectedValue = 30;
        assertEquals(node1.getValue(), node1ExpectedValue);
        assertEquals(node2.getValue(), node2ExpectedValue);
        assertEquals(node3.getValue(), node3ExpectedValue);
    }

    @Test
    public void testGetNext() {
        assertNull(node1.getNext());
        assertNull(node3.getNext());
        assertEquals(node2.getNext(), node1);
    }

    @Test
    public void testSetNext() {
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);
        assertEquals(node1.getNext(), node2);
        assertEquals(node2.getNext(), node3);
        assertEquals(node3.getNext(), node1);
    }
}