package linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void testInsert() {
        LinkedList l = new LinkedList();

        assertEquals(null, l.getHead());

        l.insert(100);
        assertEquals(100, l.getHead().getValue());
        assertEquals(null, l.getHead().getNext());

        l.insert("String");
        assertEquals("String", l.getHead().getValue());
        assertEquals(100, l.getHead().getNext().getValue());

        l.insert(true);
        assertEquals(true, l.getHead().getValue());
        assertEquals("String", l.getHead().getNext().getValue());
        assertEquals(100, l.getHead().getNext().getNext().getValue());
    }
}